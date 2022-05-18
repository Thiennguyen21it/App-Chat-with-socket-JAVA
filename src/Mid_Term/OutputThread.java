/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mid_Term;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author DELL
 */
public class OutputThread extends Thread{
    Socket socket;
    JTextArea txt;
    BufferedReader bf;
    String sender;
    String received;
    
     public OutputThread(Socket s, JTextArea txt, String sender, String received) {
         super();
         this.socket = s;
         this.txt = txt;
         this.sender = sender;
         this.received = received;
         try{
             bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             
         }catch(Exception ex) {
             ex.printStackTrace();
         }
         
     }  

    @Override
    public void run() {
        while(true) {
            try{
                if(socket != null){
                    String msg ;
                    if((msg = bf.readLine()) != null && msg.length() >0){
                        txt.append("\n" +received+":" +msg);
                    }
                    sleep(1000);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
