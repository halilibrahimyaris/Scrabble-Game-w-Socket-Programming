/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;


/**
 *
 * @author INSECT
 */

public class Message implements java.io.Serializable {

    public static enum Message_Type {None, Name, Disconnect,RivalConnected,Accept,Reject,Point, Text, Selected, Bitis,Start,Send}
    
    public Message_Type type;
    public Object content;
    public Message(Message_Type t)
    {
        this.type=t;
    }
 

    
    
}