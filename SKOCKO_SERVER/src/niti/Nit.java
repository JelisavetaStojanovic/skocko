/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Korisnik
 */
public class Nit extends Thread {
    
    private boolean kraj = false;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

    public Nit(JLabel jLabel1, JLabel jLabel2, JLabel jLabel3, JLabel jLabel4) {
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
    }

    
    @Override
    public void run() {
        while(!kraj){
            int broj1 = (int) Math.round(Math.random()*5);
            int broj2 = (int) Math.round(Math.random()*5);
            int broj3 = (int) Math.round(Math.random()*5);
            int broj4 = (int) Math.round(Math.random()*5);
            
            jLabel1.setText(String.valueOf(broj1));
            jLabel2.setText(String.valueOf(broj2));
            jLabel3.setText(String.valueOf(broj3));
            jLabel4.setText(String.valueOf(broj4));
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void zaustaviServer(){
        kraj = true;
        //interrupt();
    }
    
    
    
}
