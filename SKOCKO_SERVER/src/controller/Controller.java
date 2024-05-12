/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import forme.ServerskaForma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Igra;
import model.RezultatIgre;

/**
 *
 * @author Korisnik
 */
public class Controller {
    
    private static Controller instance;
    private DBBroker dbb;
    private ServerskaForma sf;
    
    private List<Igra> igre;
    private RezultatIgre rezultat;

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        igre = new ArrayList<>();
        rezultat = new RezultatIgre(-1, new Date(), null, -1, "izgubio", igre);
        dbb = new DBBroker();
    }

    public Igra pogadjaj(Igra igra) {
        if(igre.size()>5){
            return igra;
        }
        
        String kombinacijaNaServeru = sf.vratiKombinaciju();
        String kombinacijaNaKlijentu = igra.getKombinacija();
        //System.out.println(kombinacijaNaServeru);
        //System.out.println(kombinacijaNaServeru);
        
        int brojacNaMestu = 0;
        int brojacVanMesta = 0;
        
        String[] niz1 = kombinacijaNaServeru.split("-");
        String[] niz2 = kombinacijaNaKlijentu.split("-");
        boolean[] proverenServer = new boolean[4];
        boolean[] proverenKlijent = new boolean[4];
        
        
        for (int i = 0; i < niz2.length; i++) {
            if (niz2[i].equals(niz1[i])) {
                brojacNaMestu++;
                proverenServer[i] = true;
                proverenKlijent[i] = true;
            }
        }
        
        for (int i = 0; i < niz2.length; i++) {
            if (!proverenKlijent[i]) {
                for (int j = 0; j < niz1.length; j++) {
                    if (niz2[i].equals(niz1[j]) && !proverenServer[j]) {
                        brojacVanMesta++;
                        proverenServer[j] = true;
                        break;
                    }
                }
            }
        }

        igra.setBrojPogodjenihNaMestu(brojacNaMestu);
        igra.setBrojPogodjenihNisuNaMestu(brojacVanMesta);
        
        igre.add(igra);
        if(brojacNaMestu == 4){
            rezultat.setRezultat("pobedio");
        }
        
        return igra;
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

    public void sacuvajIgru() {
        rezultat.setDobitnaKomb(sf.vratiKombinaciju());
        rezultat.setBrojPokusaja(igre.size());
        dbb.sacuvajIgru(rezultat);
    }

    public List<RezultatIgre> vratiRezultate() {
        return dbb.vratiRezultate();
    }

    public List<Igra> vratiIgre(int id) {
        return dbb.vratiIgre(id);
    }

  
    
    
    
}
