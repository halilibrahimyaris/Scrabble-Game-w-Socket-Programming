package scrabble_game;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class Letter implements Serializable {
    /*
    * Letter nesnesinin daha kolay erişilebilmesi ve kontrol edilebilmesi için yazılan sınıfımızdır*/
    Image image;//harflerin resimleri
    String name;//adları
    int point;//puan değerleri
    LinkedList<Letter> letters;
    /*
    * Letter sınıfının constructur yapısı */
    public Letter( Image image, String name,int point,  LinkedList<Letter> letters) {
        super();
        this.image = image;
        this.name = name;
        this.letters = letters;
        this.point=point;
        letters.add(this);
    }

    public Letter() {

    }


    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
    public int getPoint(){
        return point;
    }

    /*public LinkedList<WroteLetter> getLetters() {
        return letters;
    }*/


    public void setImage(Image image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLetters(LinkedList<Letter> letters) {
        this.letters = letters;
    }
}