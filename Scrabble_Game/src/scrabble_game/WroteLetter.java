package scrabble_game;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

public class WroteLetter extends Letter {
    int indexX;//Tablodaki x değeri
    int indexY;//tablodaki y değeri
    int screenX;//ekrandaki x değeri
    int screenY;//ekrandaki y değeri
    int point; //yazılan harfin puan değeri
    Image image;//image değişkeni
    String name;//adı

    LinkedList<WroteLetter> letters;
    /*
       sınıfın ilgili construcuter yapısı kurulmuştur.
        */
    public WroteLetter(int indexX, int indexY,String name, LinkedList<WroteLetter> letters,int point) {
        super();
        this.indexX = indexX;
        this.indexY = indexY;
        this.screenX = indexX * 44;
        this.screenY = indexY * 44;
        this.name = name;
        this.letters = letters;
        this.point=point;
        letters.add(this);
    }
/*
* sınıfın getter ve setter fonksiyonları yazılmıştır.*/
    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public LinkedList<WroteLetter> getLetters() {
        return letters;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLetters() {
        setLetters();
    }


}