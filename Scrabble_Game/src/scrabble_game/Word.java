package scrabble_game;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * ilgili harfler kullanılarak yazılan keilmelerin kontorü için yazılmış bir classtır*/
public class Word {
    String text = "";//text değeri
    int weight = 0;//toplam puanı
    LinkedList<Word> words = new LinkedList<>();
    ArrayList<WroteLetter> letters = new ArrayList<>();
    Point startPoint = new Point();//başlangıç noktası
    Point endPoint = new Point();//bitişi noktası

    /*
     sınıfın ilgili construcuter yapısı kurulmuştur.
      */
    public Word(String text, int weight, LinkedList<Word> words, ArrayList<WroteLetter> letters) {
        this.text = text;
        this.weight = weight;
        //this.letters=letters;
        words.add(this);
    }

    /*
     * sınıfın getter ve setter fonksiyonları yazılmıştır.*/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LinkedList<Word> getWords() {
        return words;
    }

    public void setWords(LinkedList<Word> words) {
        this.words = words;
    }

    public ArrayList<WroteLetter> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<WroteLetter> letters) {
        this.letters = letters;
    }
    /*
    * Bu fonksiyon yazılan kelimeni oyun tahtası içerisindeki başlangıç ve bitiş konumlarınınn belirlenmesi için yazılmıştır */
    public void setBorders() {
        int maxX = 1, minX = 14;
        for (WroteLetter letter : letters) {//kelimenin harfleri içerisinde dönüyorum
            if (letter.indexX + 1 > maxX) {//eğer kelimenın son indexi max değerinde buyükse
                maxX = letter.indexX + 1;//yeni max değeri tanımlanır
            }
            if (letter.indexX - 1 < minX) {//eğer başlangıç değeri kelimenin yeni başlangıç değerinden küçükse
                minX = letter.indexX - 1; //yeni minx değeri tanımlanır.
            }


        }
        this.startPoint.x = minX;//bu mix değeri ilgili kelimeye startpoint olarak atanır
        this.endPoint.x = maxX;//bu maxXdeğeri ilgili kelimeye endpoint olarakatanır.
        System.out.println(this.startPoint);
        System.out.println(this.endPoint);
    }
}

