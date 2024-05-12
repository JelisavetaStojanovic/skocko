/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Igra implements Serializable {
    private int rb;
    private String kombinacija;
    private int brojPogodjenihNaMestu;
    private int brojPogodjenihNisuNaMestu;

    public Igra() {
    }

    public Igra(int rb, String kombinacija, int brojPogodjenihNaMestu, int brojPogodjenihNisuNaMestu) {
        this.rb = rb;
        this.kombinacija = kombinacija;
        this.brojPogodjenihNaMestu = brojPogodjenihNaMestu;
        this.brojPogodjenihNisuNaMestu = brojPogodjenihNisuNaMestu;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getKombinacija() {
        return kombinacija;
    }

    public void setKombinacija(String kombinacija) {
        this.kombinacija = kombinacija;
    }

    public int getBrojPogodjenihNaMestu() {
        return brojPogodjenihNaMestu;
    }

    public void setBrojPogodjenihNaMestu(int brojPogodjenihNaMestu) {
        this.brojPogodjenihNaMestu = brojPogodjenihNaMestu;
    }

    public int getBrojPogodjenihNisuNaMestu() {
        return brojPogodjenihNisuNaMestu;
    }

    public void setBrojPogodjenihNisuNaMestu(int brojPogodjenihNisuNaMestu) {
        this.brojPogodjenihNisuNaMestu = brojPogodjenihNisuNaMestu;
    }

    @Override
    public String toString() {
        return "Igra{" + "rb=" + rb + ", kombinacija=" + kombinacija + ", brojPogodjenihNaMestu=" + brojPogodjenihNaMestu + ", brojPogodjenihNisuNaMestu=" + brojPogodjenihNisuNaMestu + '}';
    }
    
    
}
