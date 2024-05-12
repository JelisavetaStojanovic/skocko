/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class RezultatIgre implements Serializable {
    
    private int id;
    private Date datumVreme;
    private String dobitnaKomb;
    private int brojPokusaja;
    private String rezultat;
    private List<Igra> igre;

    public RezultatIgre() {
    }

    public RezultatIgre(int id, Date datumVreme, String dobitnaKomb, int brojPokusaja, String rezultat, List<Igra> igre) {
        this.id = id;
        this.datumVreme = datumVreme;
        this.dobitnaKomb = dobitnaKomb;
        this.brojPokusaja = brojPokusaja;
        this.rezultat = rezultat;
        this.igre = igre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getDobitnaKomb() {
        return dobitnaKomb;
    }

    public void setDobitnaKomb(String dobitnaKomb) {
        this.dobitnaKomb = dobitnaKomb;
    }

    public int getBrojPokusaja() {
        return brojPokusaja;
    }

    public void setBrojPokusaja(int brojPokusaja) {
        this.brojPokusaja = brojPokusaja;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public List<Igra> getIgre() {
        return igre;
    }

    public void setIgre(List<Igra> igre) {
        this.igre = igre;
    }
    
    
}
