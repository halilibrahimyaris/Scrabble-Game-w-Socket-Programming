/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Message.Message;
import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import scrabble_game.Board;

import static Message.Message.Message_Type.Selected;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author INSECT
 */
public class SClient {

    int id;
    public String name = "NoName";
    Socket soket;
    ObjectOutputStream sOutput;
    ObjectInputStream sInput;
    //clientten gelenleri dinleme threadi
    Listen listenThread;
    //cilent eşleştirme thredi
    PairingThread pairThread;
    //rakip client
    SClient rival;
    //eşleşme durumu
    public boolean paired = false;

    public SClient(Socket gelenSoket, int id) {
        this.soket = gelenSoket;
        this.id = id;
        try {
            this.sOutput = new ObjectOutputStream(this.soket.getOutputStream());
            this.sInput = new ObjectInputStream(this.soket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //thread nesneleri
        this.listenThread = new Listen(this);
        this.pairThread = new PairingThread(this);

    }

    //client mesaj gönderme
    public void Send(Message message) {
        try {
            this.sOutput.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //client dinleme threadi
    //her clientin ayrı bir dinleme thredi var
    class Listen extends Thread {

        SClient TheClient;

        //thread nesne alması için yapıcı metod
        Listen(SClient TheClient) {
            this.TheClient = TheClient;
        }

        public void run() {
            //client bağlı olduğu sürece dönsün
            while (TheClient.soket.isConnected()) {
                try {
                    //mesajı bekleyen kod satırı
                    Message received = (Message) (TheClient.sInput.readObject());
                    //mesaj gelirse bu satıra geçer
                    //mesaj tipine göre işlemlere ayır
                    switch (received.type) {
                        case Name:
                            TheClient.name = received.content.toString().concat(String.valueOf(TheClient.id));
                            // isim verisini gönderdikten sonra eşleştirme işlemine başla
                            System.out.println("Name casedeyim sclient");
                            TheClient.pairThread.start();
                            break;
                        case Disconnect:
                            break;
                        case Send:
                            //gelen kelimelerin aldığı case yapısı
                            Server.Send(TheClient.rival, received);
                            System.out.println("Sclient senddeyim");
                            break;
                        case Text:
                            //gelen metni direkt rakibe gönder
                            Server.Send(TheClient.rival, received);
                            break;
                        case Accept:
                            //kelimenin accept edildiği case yapısı
                            Server.Send(TheClient.rival,received);
                            break;
                        case Reject:
                            //kelimenin reject edildiği case yapısı
                            Server.Send(TheClient.rival,received);
                            break;
                        case Point:
                            Server.Send(TheClient.rival,received);
                            break;
                        case Selected:
                            //gelen seçim yapıldı mesajını rakibe gönder
                            Server.Send(TheClient.rival, received);
                            break;
                        case Bitis:
                            break;

                    }

                } catch (IOException ex) {
                    Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
                    //client bağlantısı koparsa listeden sil
                    Server.Clients.remove(TheClient);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
                    //client bağlantısı koparsa listeden sil
                    Server.Clients.remove(TheClient);
                }
            }

        }
    }

    //eşleştirme threadi
    //her clientin ayrı bir eşleştirme thredi var
    class PairingThread extends Thread {

        SClient TheClient;

        PairingThread(SClient TheClient) {
            this.TheClient = TheClient;
        }

        public void run() {
            //client bağlı ve eşleşmemiş olduğu durumda dön
            while (TheClient.soket.isConnected() && TheClient.paired == false) {
                try {
                    //lock mekanizması
                    //sadece bir client içeri grebilir
                    //diğerleri release olana kadar bekler
                    Server.pairTwo.acquire(1);
                    
                    //client eğer eşleşmemişse gir
                    if (!TheClient.paired) {
                        SClient crival = null;
                        //eşleşme sağlanana kadar dön
                        while (crival == null && TheClient.soket.isConnected()) {
                            //liste içerisinde eş arıyor
                            for (SClient clnt : Server.Clients) {
                                if (TheClient != clnt && clnt.rival == null) {
                                    //eşleşme sağlandı ve gerekli işaretlemeler yapıldı
                                    crival = clnt;
                                    crival.paired = true;
                                    crival.rival = TheClient;
                                    TheClient.rival = crival;
                                    TheClient.paired = true;
                                    break;
                                }
                            }
                            //sürekli dönmesin 1 saniyede bir dönsün
                            //thredi uyutuyoruz
                            sleep(1000);
                        }
                        //eşleşme oldu
                        //her iki tarafada eşleşme mesajı gönder 
                        //oyunu başlat
                        System.out.println("Rival bulundu");
                    }
                    //lock mekanizmasını servest bırak
                    //bırakılmazsa deadlock olur.
                    Server.pairTwo.release(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PairingThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}