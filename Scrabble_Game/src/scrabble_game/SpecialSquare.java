package scrabble_game;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.LinkedList;

public class SpecialSquare extends Squares{

    /*
    * Özel karelerin kotrolü için yazılış bir sınıftır
    * içerisinde özel karelerin ekran konumlarını ve tablo konumlarını barındırır
    * Bu sayede daha rahat kontrol edilebilmektedir.*/
    int indexX;//Tablodaki x değeri
    int indexY;//tablodaki y değeri
    int screenX;//ekrandaki x değeri
    int screenY;//ekrandaki y değeri
    Image image ;//image deişikeni
    String name;//adı
    LinkedList<SpecialSquare> specialSquares;
    /*
    sınıfın ilgili construcuter yapısı kurulmuştur.
     */
    public SpecialSquare(int indexX, int indexY, Image image, String name,  LinkedList<SpecialSquare> specialSquares){
        super();
        this.indexX=indexX;
        this.indexY=indexY;
        this.screenX=indexX*44;
        this.screenY=indexY*44;
        this.image=image;
        this.name = name;
        this.specialSquares = specialSquares;
        specialSquares.add(this);
    }

}
