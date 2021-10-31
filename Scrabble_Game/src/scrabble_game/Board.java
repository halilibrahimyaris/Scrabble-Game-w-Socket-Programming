/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble_game;


import Message.Message;

import java.awt.Cursor;
import java.awt.Point;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author halil
 */
public class Board {

    /**
     * @param args the command line arguments
     */
    /*
    * Bu alanda programın içinde kullanacağım değişkenleri tanımladım*/
    public static boolean isRejected=false;
    public static int temp2=0;
    public static JFrame jFrame;//jframe nesnesi oluşturuldu
    public String wordState="";
    public boolean isMouseClicked = false;
    public String selectedletter;
    public static int counter = 0;
    public static Board game;
    public LinkedList<Squares> squares = new LinkedList<>();//ekrandaki kareler için bir linkedlist
    public LinkedList<SpecialSquare> specialSquares = new LinkedList<>();//ekrandaki özel kareler iiçin linkedlist
    public static LinkedList<Letter> letters = new LinkedList<>();//harflerin strore edilmesi için bir linkedlist
    public static LinkedList<WroteLetter> wroteLetters = new LinkedList<>();//yazılan harflerin store edilmesi için bir linkedlist.
    public static  JTextField systemMessage;
    public static JTextField txtPoint;
    public LinkedList<Word> words = new LinkedList<>();
    public ArrayList<WroteLetter> wordLetters = new ArrayList<>();
    public LinkedList<WroteLetter> turnLetters = new LinkedList<>();
    public int mouseClickX;
    public int mouseClickY;
    public int wordWeight;
    public  Word word = new Word("", 0, words, wordLetters);
    public String tempWord = "";
    public static int totalPoint=0;
    public static int temp=0;
//Bu kısım kullandığım imageleri bir defaya mahsus oluşturmak için kullanıldı
    public BufferedImage crossBufferedImage = null;
    //Ozel kare resimleri
    public Image crossImage = ReadImage(crossBufferedImage, "C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\2L.png");
    public Image crossImage2w = ReadImage(crossBufferedImage, "C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\2W.png");
    public Image crossImage3w = ReadImage(crossBufferedImage, "C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\3W.png");
    public Image crossImagecenter = ReadImage(crossBufferedImage, "C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\center.png");
    public Image crossImage3L = ReadImage(crossBufferedImage, "C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\3L.png");
    //Harflerin resimleri
    public Image imageA = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/A.png");
    public Image imageB = ReadImage(crossBufferedImage, "C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\letters\\B.png");
    public Image imageC = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/C.png");
    public Image imageD = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/D.png");
    public Image imageE = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/E.png");
    public Image imageF = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/F.png");
    public Image imageG = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/G.png");
    public Image imageH = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/H.png");
    public Image imageI = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/I.png");
    public Image imageJ = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/J.png");
    public Image imageK = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/K.png");
    public Image imageL = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/L.png");
    public Image imageM = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/M.png");
    public Image imageN = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/N.png");
    public Image imageO = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/O.png");
    public Image imageP = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/P.png");
    public Image imageQ = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/Q.png");
    public Image imageR = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/R.png");
    public Image imageS = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/S.png");
    public Image imageT = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/T.png");
    public Image imageU = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/U.png");
    public Image imageV = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/V.png");
    public Image imageW = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/W.png");
    public Image imageX = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/X.png");
    public Image imageY = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/Y.png");
    public Image imageZ = ReadImage(crossBufferedImage, "Scrabble_Game/src/letters/Z.png");
    //Harf nesneleri
    public Letter LetterA = new Letter(imageA, "A", 1, letters);
    public Letter LetterB = new Letter(imageB, "B", 3, letters);
    public Letter LetterC = new Letter(imageC, "C", 3, letters);
    public Letter LetterD = new Letter(imageD, "D", 2, letters);
    public Letter LetterE = new Letter(imageE, "E", 1, letters);
    public Letter LetterF = new Letter(imageF, "F", 4, letters);
    public Letter LetterG = new Letter(imageG, "G", 2, letters);
    public Letter LetterH = new Letter(imageH, "H", 4, letters);
    public Letter LetterI = new Letter(imageI, "I", 1, letters);
    public Letter LetterJ = new Letter(imageJ, "J", 8, letters);
    public Letter LetterK = new Letter(imageK, "K", 5, letters);
    public Letter LetterL = new Letter(imageL, "L", 1, letters);
    public Letter LetterM = new Letter(imageM, "M", 3, letters);
    public Letter LetterN = new Letter(imageN, "N", 1, letters);
    public Letter LetterO = new Letter(imageO, "O", 1, letters);
    public Letter LetterP = new Letter(imageP, "P", 3, letters);
    public Letter LetterQ = new Letter(imageQ, "Q", 10, letters);
    public Letter LetterR = new Letter(imageR, "R", 1, letters);
    public Letter LetterS = new Letter(imageS, "S", 1, letters);
    public Letter LetterT = new Letter(imageT, "T", 1, letters);
    public Letter LetterU = new Letter(imageU, "U", 1, letters);
    public Letter LetterV = new Letter(imageV, "V", 4, letters);
    public Letter LetterW = new Letter(imageW, "W", 4, letters);
    public Letter LetterX = new Letter(imageX, "X", 8, letters);
    public Letter LetterY = new Letter(imageY, "Y", 4, letters);
    public Letter LetterZ = new Letter(imageZ, "Z", 10, letters);

    //Reading pictures from files
    public BufferedImage ReadImage(BufferedImage fullPiecesImage, String filePath) {
        try {
            fullPiecesImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fullPiecesImage;
    }
//Bu fonksiyon ekranımdaki oyun tahtamın çizimi için yazımlıştır
    public static JPanel drawSquare(LinkedList<WroteLetter>writtenLetters) {
        JPanel jpanel = new JPanel() {//j panel oluşturuyorum
            public void paint(Graphics g) {//Graphics kütüphanesinin paint fonksiyonu
                boolean isWhite = true;

                //Bu döngüde 15x15 boyutlarında 44px lik bir oyun tahtası çizdiriyorum.
                for (int i = 0; i < 15; i++) {
                    for (int j = -1; j < 15; j++) {
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setStroke(new BasicStroke(3));
                        g.drawLine(i * 44, j * 44, (i + 1) * 44, (j) * 44);
                        g.drawLine(i * 44, j * 44, (i) * 44, (j + 1) * 44);
                        isWhite = !isWhite;
                    }
                }
                //bu kısımda özel karelerimi oluşturuyorum
                //2L özel karesi için belirlenen koordinatlarda create işlemi
                SpecialSquare ss0 = new SpecialSquare(0, 3, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss1 = new SpecialSquare(0, 11, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss2 = new SpecialSquare(2, 6, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss3 = new SpecialSquare(2, 8, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss4 = new SpecialSquare(3, 0, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss5 = new SpecialSquare(3, 7, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss6 = new SpecialSquare(3, 7, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss7 = new SpecialSquare(3, 14, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss8 = new SpecialSquare(3, 0, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss9 = new SpecialSquare(11, 0, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss10 = new SpecialSquare(6, 2, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss11 = new SpecialSquare(8, 2, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss12 = new SpecialSquare(0, 3, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss13 = new SpecialSquare(7, 3, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss14 = new SpecialSquare(14, 3, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss15 = new SpecialSquare(6, 6, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss16 = new SpecialSquare(8, 6, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss17 = new SpecialSquare(6, 8, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss18 = new SpecialSquare(8, 8, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss19 = new SpecialSquare(12, 6, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss20 = new SpecialSquare(6, 12, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss21 = new SpecialSquare(11, 7, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss22 = new SpecialSquare(7, 11, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss23 = new SpecialSquare(14, 12, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss24 = new SpecialSquare(12, 14, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss25 = new SpecialSquare(12, 8, game.crossImage, "2L", game.specialSquares);
                SpecialSquare ss26 = new SpecialSquare(8, 12, game.crossImage, "2L", game.specialSquares);
                //SpecialSquare ss27 = new SpecialSquare(7,7,crossImagecenter,"center",specialSquares);
                // word x2 karesi için oluşturma işlemi
                for (int i = 1; i <= 4; i++) {
                    SpecialSquare ss = new SpecialSquare(i, i, game.crossImage2w, "2W", game.specialSquares);
                }
                for (int i = 13; i >= 10; i--) {
                    SpecialSquare ss = new SpecialSquare(i, i, game.crossImage2w, "2W", game.specialSquares);
                }
                for (int i = 13; i >= 10; i--) {
                    SpecialSquare ss = new SpecialSquare(14 - i, i, game.crossImage2w, "2W", game.specialSquares);

                }
                for (int i = 13; i >= 10; i--) {
                    SpecialSquare ss = new SpecialSquare(i, 14 - i, game.crossImage2w, "2W", game.specialSquares);

                }
                // wordx3 karesi için oluşturma işlemi
                for (int i = 0; i <= 14; i = i + 7) {
                    for (int j = 0; j <= 14; j = j + 7) {
                        if (!(i == 7 && j == 7)) {
                            SpecialSquare ss = new SpecialSquare(i, j, game.crossImage3w, "3W", game.specialSquares);
                        }
                    }
                }
                //harfx3 için kare oluşturma işlmei
                for (int i = 1; i <= 13; i = i + 4) {
                    for (int j = 1; j <= 13; j = j + 4) {
                        if (!(i == 1 && j == 1 || i == 1 && j == 13 || i == 13 && j == 1 || i == 13 && j == 13)) {
                            SpecialSquare ss = new SpecialSquare(i, j, game.crossImage3L, "3L", game.specialSquares);
                        }
                    }
                }
                //tahtanın merkezindeki kare için oluşturma işlemi
                SpecialSquare ss27 = new SpecialSquare(7, 7, game.crossImagecenter, "center", game.specialSquares);
                //tüm oluşturulan kareler bir linkedlist yapsına atılır
                for (SpecialSquare ss : game.specialSquares) {
                    //Graphics classının drawimage fonksiyonu ile kareler tahtaya çizdirilir
                    g.drawImage(ss.image, ss.screenX, ss.screenY, this);
                }
                System.out.println("fonksiyondayım");
                //Bu yapı yazılan harflerin tekrardan çizilebilmesi için yazılmıştır.
                System.out.println(wroteLetters.size());
                for (WroteLetter wl : wroteLetters) {
                    for (Letter let : letters) {
                        if (wl.name.equals(let.name)) {
                            g.drawImage(let.image, wl.screenX, wl.screenY, this);
                            System.out.println("wroteletter çizidim");
                        }
                    }

                }
                //Eger mouseClicked geğişkeni true olursa
                if (game.isMouseClicked) {

                    //Burada 26 harf için bir switch case yapısı kuruldu.
                    switch (game.selectedletter) {

                        case "A":
                            //Eger a harfi seçildiyse letter a için bir çizim fonksiyonu çağrılacak.
                            g.drawImage(game.LetterA.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            //yazılan harf oluşturulup ilgili linkedliste atılacak
                            WroteLetter wlA = new WroteLetter(game.mouseClickX, game.mouseClickY, "A", game.wroteLetters, game.LetterA.point);
                            game.turnLetters.add(wlA);
                            game.word.letters.add(wlA);
                            //ilgili point değeri artacak.
                            game.tempWord += game.LetterA.getName();
                            game.wordWeight += game.LetterA.getPoint();
                            break;
                        case "B":
                            //Eger b harfi seçildiyse letter a için bir çizim fonksiyonu çağrılacak.
                            g.drawImage(game.LetterB.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            //yazılan harf oluşturulup ilgili linkedliste atılacak
                            WroteLetter wlB = new WroteLetter(game.mouseClickX, game.mouseClickY, "B", game.wroteLetters, game.LetterB.point);
                            game.word.letters.add(wlB);
                            game.turnLetters.add(wlB);
                            game.tempWord += game.LetterB.getName();
                            //ilgili point değeri artacak.
                            game.wordWeight += game.LetterB.getPoint();
                            break;
                        case "C":
                            g.drawImage(game.LetterC.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            //Eger c harfi seçildiyse letter a için bir çizim fonksiyonu çağrılacak.
                            //yazılan harf oluşturulup ilgili linkedliste atılacak
                            WroteLetter wlC = new WroteLetter(game.mouseClickX, game.mouseClickY, "C", game.wroteLetters, game.LetterC.point);
                            game.word.letters.add(wlC);
                            game.turnLetters.add(wlC);
                            game.tempWord += game.LetterC.getName();
                            //ilgili point değeri artacak.
                            game.wordWeight += game.LetterC.getPoint();
                            break;
                        case "D":
                            g.drawImage(game.LetterD.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            //Eger c harfi seçildiyse letter a için bir çizim fonksiyonu çağrılacak.
                            WroteLetter wlD = new WroteLetter(game.mouseClickX, game.mouseClickY, "D", game.wroteLetters, game.LetterD.point);
                            //yazılan harf oluşturulup ilgili linkedliste atılacak
                            game.word.letters.add(wlD);
                            game.turnLetters.add(wlD);
                            game.tempWord += game.LetterD.getName();
                            //ilgili point değeri artacak.
                            game.wordWeight += game.LetterD.getPoint();
                            break;
                        case "E":
                            g.drawImage(game.LetterE.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlE = new WroteLetter(game.mouseClickX, game.mouseClickY, "E", game.wroteLetters, game.LetterE.point);
                            game.word.letters.add(wlE);
                            game.turnLetters.add(wlE);
                            game.tempWord += game.LetterE.getName();
                            game.wordWeight += game.LetterE.getPoint();
                            break;
                        case "F":
                            g.drawImage(game.LetterF.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlF = new WroteLetter(game.mouseClickX, game.mouseClickY, "F", game.wroteLetters, game.LetterF.point);
                            game.word.letters.add(wlF);
                            game.turnLetters.add(wlF);
                            game.tempWord += game.LetterF.getName();
                            game.wordWeight += game.LetterF.getPoint();
                            break;
                        case "G":
                            g.drawImage(game.LetterG.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlG = new WroteLetter(game.mouseClickX, game.mouseClickY, "G", game.wroteLetters, game.LetterG.point);
                            game.word.letters.add(wlG);
                            game.turnLetters.add(wlG);
                            game.tempWord += game.LetterG.getName();
                            game.wordWeight += game.LetterG.getPoint();
                            break;
                        case "H":
                            g.drawImage(game.LetterH.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlH = new WroteLetter(game.mouseClickX, game.mouseClickY, "H", game.wroteLetters, game.LetterH.point);
                            game.word.letters.add(wlH);
                            game.turnLetters.add(wlH);
                            game.tempWord += game.LetterH.getName();
                            game.wordWeight += game.LetterH.getPoint();
                            break;
                        case "I":
                            g.drawImage(game.LetterI.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlI = new WroteLetter(game.mouseClickX, game.mouseClickY, "I", game.wroteLetters, game.LetterI.point);
                            game.word.letters.add(wlI);
                            game.turnLetters.add(wlI);
                            game.tempWord += game.LetterI.getName();
                            game.wordWeight += game.LetterI.getPoint();
                            break;
                        case "J":
                            g.drawImage(game.LetterJ.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlJ = new WroteLetter(game.mouseClickX, game.mouseClickY, "J", game.wroteLetters, game.LetterJ.point);
                            game.word.letters.add(wlJ);
                            game.turnLetters.add(wlJ);
                            game.tempWord += game.LetterJ.getName();
                            game.wordWeight += game.LetterJ.getPoint();
                            break;
                        case "K":
                            g.drawImage(game.LetterK.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlK = new WroteLetter(game.mouseClickX, game.mouseClickY, "K", game.wroteLetters, game.LetterK.point);
                            game.word.letters.add(wlK);
                            game.turnLetters.add(wlK);
                            game.tempWord += game.LetterK.getName();
                            game.wordWeight += game.LetterK.getPoint();
                            break;
                        case "L":
                            g.drawImage(game.LetterL.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlL = new WroteLetter(game.mouseClickX, game.mouseClickY, "L", game.wroteLetters, game.LetterL.point);
                            game.word.letters.add(wlL);
                            game.turnLetters.add(wlL);
                            game.tempWord += game.LetterL.getName();
                            game.wordWeight += game.LetterL.getPoint();
                            break;
                        case "M":
                            g.drawImage(game.LetterM.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlM = new WroteLetter(game.mouseClickX, game.mouseClickY, "M", game.wroteLetters, game.LetterM.point);
                            game.word.letters.add(wlM);
                            game.turnLetters.add(wlM);
                            game.tempWord += game.LetterM.getName();
                            game.wordWeight += game.LetterM.getPoint();
                            break;
                        case "N":
                            g.drawImage(game.LetterN.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlN = new WroteLetter(game.mouseClickX, game.mouseClickY, "N", game.wroteLetters, game.LetterN.point);
                            game.word.letters.add(wlN);
                            game.turnLetters.add(wlN);
                            game.tempWord += game.LetterN.getName();
                            game.wordWeight += game.LetterN.getPoint();
                            break;
                        case "O":
                            g.drawImage(game.LetterO.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlO = new WroteLetter(game.mouseClickX, game.mouseClickY, "O", game.wroteLetters, game.LetterO.point);
                            game.word.letters.add(wlO);
                            game.turnLetters.add(wlO);
                            game.tempWord += game.LetterO.getName();
                            game.wordWeight += game.LetterO.getPoint();
                            break;
                        case "P":
                            g.drawImage(game.LetterP.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlP = new WroteLetter(game.mouseClickX, game.mouseClickY, "P", game.wroteLetters, game.LetterP.point);
                            game.word.letters.add(wlP);
                            game.turnLetters.add(wlP);
                            game.tempWord += game.LetterP.getName();
                            game.wordWeight += game.LetterP.getPoint();
                            break;
                        case "Q":
                            g.drawImage(game.LetterQ.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlQ = new WroteLetter(game.mouseClickX, game.mouseClickY, "Q", game.wroteLetters, game.LetterQ.point);
                            game.word.letters.add(wlQ);
                            game.turnLetters.add(wlQ);
                            game.tempWord += game.LetterQ.getName();
                            game.wordWeight += game.LetterQ.getPoint();
                            break;
                        case "R":
                            g.drawImage(game.LetterR.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlR = new WroteLetter(game.mouseClickX, game.mouseClickY, "R", game.wroteLetters, game.LetterR.point);
                            game.word.letters.add(wlR);
                            game.turnLetters.add(wlR);
                            game.tempWord += game.LetterR.getName();
                            game.wordWeight += game.LetterR.getPoint();
                            break;
                        case "S":
                            g.drawImage(game.LetterS.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlS = new WroteLetter(game.mouseClickX, game.mouseClickY, "S", game.wroteLetters, game.LetterS.point);
                            game.word.letters.add(wlS);
                            game.turnLetters.add(wlS);
                            game.tempWord += game.LetterS.getName();
                            game.wordWeight += game.LetterS.getPoint();
                            break;
                        case "T":
                            g.drawImage(game.LetterT.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlT = new WroteLetter(game.mouseClickX, game.mouseClickY, "T", game.wroteLetters, game.LetterT.point);
                            game.word.letters.add(wlT);
                            game.turnLetters.add(wlT);
                            game.tempWord += game.LetterT.getName();
                            game.wordWeight += game.LetterT.getPoint();
                            break;
                        case "U":
                            g.drawImage(game.LetterU.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlU = new WroteLetter(game.mouseClickX, game.mouseClickY, "U", game.wroteLetters, game.LetterU.point);
                            game.word.letters.add(wlU);
                            game.turnLetters.add(wlU);
                            game.tempWord += game.LetterU.getName();
                            game.wordWeight += game.LetterU.getPoint();
                            break;
                        case "V":
                            g.drawImage(game.LetterV.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlV = new WroteLetter(game.mouseClickX, game.mouseClickY, "V", game.wroteLetters, game.LetterV.point);
                            game.word.letters.add(wlV);
                            game.turnLetters.add(wlV);
                            game.tempWord += game.LetterV.getName();
                            game.wordWeight += game.LetterV.getPoint();
                            break;
                        case "W":
                            g.drawImage(game.LetterW.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlW = new WroteLetter(game.mouseClickX, game.mouseClickY, "W", game.wroteLetters, game.LetterW.point);
                            game.word.letters.add(wlW);
                            game.turnLetters.add(wlW);
                            game.tempWord += game.LetterW.getName();
                            //wordwordWeight+= LetterW.getPoint();
                            break;
                        case "X":
                            g.drawImage(game.LetterX.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlX = new WroteLetter(game.mouseClickX, game.mouseClickY, "X", game.wroteLetters, game.LetterX.point);
                            game.word.letters.add(wlX);
                            game.turnLetters.add(wlX);
                            game.tempWord += game.LetterX.getName();
                            game.wordWeight += game.LetterX.getPoint();
                            break;
                        case "Y":
                            g.drawImage(game.LetterY.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlY = new WroteLetter(game.mouseClickX, game.mouseClickY, "Y", game.wroteLetters, game.LetterY.point);
                            game.word.letters.add(wlY);
                            game.turnLetters.add(wlY);
                            game.tempWord += game.LetterY.getName();
                            game.wordWeight += game.LetterY.getPoint();
                            break;
                        case "Z":
                            g.drawImage(game.LetterZ.image, game.mouseClickX * 44, game.mouseClickY * 44, this);
                            WroteLetter wlZ = new WroteLetter(game.mouseClickX, game.mouseClickY, "Z", game.wroteLetters, game.LetterZ.point);
                            game.word.letters.add(wlZ);
                            game.turnLetters.add(wlZ);
                            game.tempWord += game.LetterZ.getName();
                            game.wordWeight += game.LetterZ.getPoint();
                            break;
                        default:
                            //Eğer hiçbir harf seçilmezse bir mesaj yazılacak
                            //systemMessage.setText("no item is selected");
                            break;
                    }


                    game.word.setBorders();
                    game.selectedletter = "";
                    game.isMouseClicked = false;
                }

            }

        };

        return jpanel;
    }


    public static void main(String[] args) {
        // TODO code application logic here

        jFrame = new JFrame();//jframe nesnesi initilaze edilir
        jFrame.setBounds(10, 10, 1200, 900);//boyutları belirtilir.
        game=new Board();
        JPanel jpanel = drawSquare(game.wroteLetters);// paneli oluşturmak için fonksiyonumuzu çağırıyoruz.

        jFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /* Bu kısımda mouse tıklandığında ilgili x ve y değerlerini değişkenlere atıyorum*/
                game.mouseClickX = e.getX() / 44;
                game.mouseClickY = e.getY() / 44;
                System.out.println("x= " + game.mouseClickX + " " + " y = " + game.mouseClickY);
                game.isMouseClicked = !game.isMouseClicked;
                /*
                if (isMouseClicked) {
                    isMouseSecondClicked = true;
                    isMouseClicked = false;
                } else {
                    isMouseClicked = true;
                    isMouseSecondClicked = false;
                }
*/

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //her mouse bırakıldığında cursor u eski haline getiriyorum
                game.neKaresi(e.getX() / 44, e.getY() / 44, game.squares, game.specialSquares);
                jFrame.setCursor(Cursor.getDefaultCursor());
                //ve j frame i repaint fonksiyonuyla yeniden çizdiriyorum.
                jFrame.repaint();




            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JButton connectServer = new JButton("Connect");
        connectServer.setBounds(680, 50, 100, 30);
        connectServer.setBackground(Color.BLUE);
        jFrame.add(connectServer);

        connectServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //server a connect olmak için oyuncuların tıklaması gereken buton
                Client.Start("127.0.0.1", 2000);
                connectServer.setEnabled(false);
                //Client.Send(msg);
            }


        });
        JLabel lbl_Point = new JLabel();
        lbl_Point.setText("Total Point: ");
        lbl_Point.setBounds(680, 130, 100, 30);
        jFrame.add(lbl_Point);

        //kullanıcının punanını gösteren textArea
        txtPoint = new JTextField("");
        txtPoint.setBounds(800, 130, 200, 30);
        jFrame.add(txtPoint);



        //sistem mesajlarının gösterilmesi için text area
        systemMessage = new JTextField("");
        systemMessage.setBounds(680, 200, 200, 200);
        jFrame.add(systemMessage);

        //Kullanıcının rakibinin kelimesini kabul ettiği buton
        JButton acceptWord = new JButton("Accept");
        acceptWord.setBounds(900, 240, 100, 40);
        acceptWord.setBackground(Color.green);
        jFrame.add(acceptWord);

        acceptWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(Message.Message_Type.Accept);
                //eger kullanıcı kelimeyi kabul ederse mesaj olarak kabul edildi gidiyor.
                msg.content = "Kelimeniz kabul edildi";
                Client.Send(msg);
                systemMessage.setText(game.wordState);

            }


        });
        //Kullanıcının rakibinin kelimesini ret ettiği buton
        JButton rejectWord = new JButton("Reject");
        rejectWord.setBounds(900, 300, 100, 40);
        rejectWord.setBackground(Color.red);
        jFrame.add(rejectWord);

        rejectWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eger kullanıcı kelimeyi kabul ederse mesaj olarak red edildi gidiyor.
                Message msg = new Message(Message.Message_Type.Reject);
                msg.content = "Kelimeniz Reddedildi";
                Client.Send(msg);

            }


        });
        Random randNum = new Random();
        /*
        * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l0 = new JButton("B");
        l0.setBounds(50, 750, 50, 30);//buton boundsları set edilir
        l0.setBackground(Color.yellow);
        jFrame.add(l0);

        l0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l0.getText();
                //Burada corsor belirlenen resim olarak değiştirilir
                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));

                l0.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l1 = new JButton("A");
        l1.setBounds(50 + 70, 750, 50, 30);//buton boundsları set edilir
        l1.setBackground(Color.yellow);
        jFrame.add(l1);
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l1.getText();
                //Burada corsor belirlenen resim olarak değiştirilir
                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("Scrabble_Game/src/images/Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));

                l1.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l2 = new JButton("C");
        l2.setBounds(50 + 140, 750, 50, 30);//buton boundsları set edilir
        l2.setBackground(Color.yellow);
        jFrame.add(l2);
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l2.getText();
//Burada corsor belirlenen resim olarak değiştirilir
                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("Scrabble_Game/src/images/Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));
                l2.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l3 = new JButton("X");
        l3.setBounds(50 + 210, 750, 50, 30);//buton boundsları set edilir
        l3.setBackground(Color.yellow);
        jFrame.add(l3);
        l3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l3.getText();
                //Burada corsor belirlenen resim olarak değiştirilir
                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("Scrabble_Game/src/images/Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));
                l3.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l4 = new JButton("Q");
        l4.setBounds(50 + 280, 750, 50, 30);//buton boundsları set edilir
        l4.setBackground(Color.yellow);
        jFrame.add(l4);
        l4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l4.getText();
//Burada corsor belirlenen resim olarak değiştirilir
                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("Scrabble_Game/src/images/Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));
                l4.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l5 = new JButton("Y");
        l5.setBounds(50 + 350, 750, 50, 30);//buton boundsları set edilir
        l5.setBackground(Color.yellow);
        jFrame.add(l5);
        l5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l5.getText();
//Burada corsor belirlenen resim olarak değiştirilir
                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("C:\\Users\\halil\\OneDrive\\Masaüstü\\Scrabble-Game\\Scrabble_Game\\src\\images\\Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));
                l5.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım kullanıcının o elde sahip olduğu harflerin butonlarının tanımladığı kısımımız */
        JButton l6 = new JButton("O");
        l6.setBounds(50 + 420, 750, 50, 30);//buton boundsları set edilir
        l6.setBackground(Color.yellow);
        jFrame.add(l6);
        l6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.selectedletter = l6.getText();

                jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("Scrabble_Game/src/images/Scrabble_icon.png").getImage(),
                        new Point(0, 0), "custom cursor"));
                l6.setText(String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray()[randNum.nextInt("ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray().length)]));

            }


        });
        /*
         * Bu kısım Kullanının yazmış oluduğu kelimeyi karşıya göndermek için kullanacağı butondur.*/
        JButton changeTurn = new JButton("sendWord");
        changeTurn.setBounds(50 + 500, 750, 100, 30);//buton boundsları set edilir
        changeTurn.setBackground(Color.yellow);
        jFrame.add(changeTurn);

        changeTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // bu kısım kullanıcının ikinci hamlesinde yaptığı hamleden kazanacağı puanı belirler.
                if (counter==0){
                    //oyunun başlangıcında yazılan kelime puanı 2 ile çarpılır.
                    game.wordWeight=game.wordWeight*2;
                    counter = 1;
                }
                if (counter == 1) {
                    for (int i = 0; i < game.turnLetters.size(); i++) {
                        for (SpecialSquare ss : game.specialSquares) {
                            if (ss.indexX == game.turnLetters.get(i).indexX && ss.indexY == game.turnLetters.get(i).indexY) {
                                //2l ve 3l için optimization yapılması lazım.
                                //eğer 2L ise
                                if (ss.name == "2L") {
                                    System.out.println("ben 2 l yim");
                                    int temp1;
                                    //ilgili harf 2 ile çarpılır
                                    temp1 = (game.turnLetters.get(i).point * 2);
                                    game.wordWeight = temp1;
                                    break;
                                }
                                //eğer 3l ise
                                if (ss.name == "3L") {
                                    System.out.println("ben 3 l yim");
                                    //ilgili harf 3 ile çarpılır
                                    game.wordWeight = (game.turnLetters.get(i).point * 3);
                                    break;
                                }
                                //eğer o kare 2w ise
                                if (ss.name == "2W") {
                                    System.out.println("ben 2w yim");
                                    //ilgili kelime puanı 2 ile çarpılır
                                    game.wordWeight = game.wordWeight * 2;
                                    break;
                                }
                                //eğer 3w ise
                                if (ss.name == "3W") {
                                    System.out.println("ben 3w yim");
                                    //ilgili kelime puanı 3 ile çarpılır.
                                    game.wordWeight = game.wordWeight * 3;
                                    break;
                                }
                            }
                        }
                    }

                }

                //Burada oyunun başlangıcı için bir puan belirleme işlemi yapılır


                Word word = new Word(game.tempWord, game.wordWeight, game.words, game.wordLetters);
                System.out.println("kazanılan puan: " + game.wordWeight);
                //Message nesnesi oluşturulur.
                Message msg = new Message(Message.Message_Type.Send);
                //message nesnesi olarak ilgili linkedlist atanır
                LinkedList<WroteLetter> kullanAt = new LinkedList<>();
                kullanAt.addAll(wroteLetters);
                msg.content = kullanAt;
                System.out.println(wroteLetters.size());
                //ilgli client e msg gönderilir
                Client.Send(msg);
                //ikinci bir message nesnesi oluşrulur.
                Message msg2 = new Message(Message.Message_Type.Point);
                msg2.content= game.wordWeight;
                //ilgili clienta point değeri gönderilir.
                Client.Send(msg2);
                temp=game.wordWeight;
                totalPoint+=temp;
                System.out.println("Ben mesajı gönderdim");
                game.tempWord = "";
                game.wordWeight = 0;
                game.turnLetters.clear();

            }


        });
        jFrame.setUndecorated(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jpanel);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        //jFrame.setLocationRelativeTo(null);
        //Pencerelerin ekrandaki konumlarının yerleşimi için yazılan kodlar
        if (temp2==1){
            //eğer değer1 ise ekranın sağ üstünde
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
            Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
            int x = (int) rect.getMaxX() - jFrame.getWidth();
            int y = 0;
            jFrame.setLocation(x, y);
            temp2++;
        }
        if (temp2==0){
            //eğer değer 0 ise sol ortasında konumlanır.
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
            Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
            int x = 0;
            int y =  jFrame.getWidth()-(int) rect.getMaxY() ;
            jFrame.setLocation(x, y);
            temp2++;
        }




    }
    public static void myRepaint(LinkedList<WroteLetter> wl){
        //jframe nesnesi için yazılmış repaint fonksiyonu.
        wroteLetters.addAll(wl);
        jFrame.repaint();
    }

    public static void setPoint(int temp){
        int yeni=0;
        if(systemMessage.getText().equals("Kelimeniz kabul edildi")){
            if(!(txtPoint.getText().equals(""))){
                yeni=Integer.valueOf(txtPoint.getText());
            }
            txtPoint.setText(String.valueOf(temp+yeni));
        }

    }


    public void neKaresi(int indexX, int indexY, LinkedList<Squares> squares, LinkedList<SpecialSquare> specialSquares) {
        /*
        for (SpecialSquare specialSquare : specialSquares) {
            if (specialSquare.indexX == indexX && specialSquare.indexY == indexY) {
                System.out.println(specialSquare.name);
                return;
            }
        }
        */

        for (Squares square : squares) {
            if (square.indexX == indexX && square.indexY == indexY) {
                System.out.println("x= " + square.indexX + " y= " + square.indexY);
                return;
            }

        }


    }



}