/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class PokreniServer extends Thread {
    
    private boolean kraj = false;
    private ServerSocket serverskiSoket;

    @Override
    public void run() {
        try {
            serverskiSoket = new ServerSocket(9000);
            System.out.println("SOKET JE POVEZAN");
            
            while(!kraj){
                
                Socket s = serverskiSoket.accept();
                System.out.println("KLIJENT JE POVEZAN");
                
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(s);
                nit.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void zaustaviServer(){
        kraj = true;
        
        try {
            serverskiSoket.close();
            System.out.println("SOKET JE ZATVOREN");
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
}
