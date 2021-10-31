/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabble_game;

import java.util.LinkedList;

public class Squares {
    /*
     * ekrandaki her karenin kotrolü için yazılmış bir sınıftır
     * içerisinde karelerin ekran konumlarını ve tablo konumlarını barındırır
     * Bu sayede daha rahat kontrol edilebilmektedir.*/
    int indexX;//Tablodaki x değeri
    int indexY;//tablodaki y değeri
    int screenX;//ekrandaki x değeri
    int screenY;//ekrandaki y değeri

    String name;//adı
    boolean isEmpty=false;
    LinkedList<Squares> squares;
    /*
     sınıfın ilgili construcuter yapısı kurulmuştur.
      */
    public Squares(int indexX, int indexY, String name, LinkedList<Squares> squares){
        this.indexX=indexX;
        this.indexY=indexY;
        this.screenX=indexX*44;
        this.screenY=indexY*44;

        this.name = name;
        this.squares = squares;
        squares.add(this);
    }

    public Squares() {

    }

    public void paint(){

    }


}
