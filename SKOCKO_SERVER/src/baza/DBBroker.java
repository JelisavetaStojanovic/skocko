/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.Date;
import java.util.List;
import model.Igra;
import model.RezultatIgre;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class DBBroker {

    public void sacuvajIgru(RezultatIgre rezultat) {
        
        try {
            int idRez = -1;
            String upit = "INSERT INTO REZULTAT (datumVreme,dobitnaKomb,brPokusaja,rezultat) VALUES (?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
              
            java.sql.Timestamp sqlDatum = new java.sql.Timestamp(rezultat.getDatumVreme().getTime());
            ps.setTimestamp(1, sqlDatum);
            ps.setString(2, rezultat.getDobitnaKomb());
            ps.setInt(3, rezultat.getBrojPokusaja());
            ps.setString(4, rezultat.getRezultat());
                
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                idRez = rs.getInt(1);
            }
            System.out.println("ID JE: "+idRez);

            //sada radimo INSERT INTO za kolonu igra
            
            String upit1 = "INSERT INTO igra (kombinacija,namestu,vanmesta,rezultat) "+"VALUES (?,?,?,?)";
            PreparedStatement ps1 = Konekcija.getInstance().getConnection().prepareStatement(upit1);
            
            for(Igra igra : rezultat.getIgre()){
                ps1.setString(1, igra.getKombinacija());
                ps1.setInt(2, igra.getBrojPogodjenihNaMestu());
                ps1.setInt(3, igra.getBrojPogodjenihNisuNaMestu());
                ps1.setInt(4, idRez);
                ps1.addBatch();
            }
            
            ps1.executeBatch();
            
            Konekcija.getInstance().getConnection().commit();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    public List<RezultatIgre> vratiRezultate() {
        List<RezultatIgre> lista = new ArrayList<>();
        String upit = "SELECT * FROM rezultat";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
        
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp datumVreme = rs.getTimestamp("datumVreme");
                String dobitnaKomb = rs.getString("dobitnaKomb");
                int brojPokusaja = rs.getInt("brPokusaja");
                String rezultat = rs.getString("rezultat");
                java.util.Date datumVremeDate = new java.util.Date(datumVreme.getTime());
                RezultatIgre rezultatIgre = new RezultatIgre(id, datumVremeDate, dobitnaKomb, brojPokusaja, rezultat, new ArrayList<>());//ne izvlacimo ovde listu igara, tek kad se klikne na detalji; moze i null ali bolje prazna lista da ne bi posle imali null pointer exception
                
                lista.add(rezultatIgre);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public List<Igra> vratiIgre(int id) {
        List<Igra> lista = new ArrayList<>();
        String upit = "SELECT * FROM igra WHERE rezultat="+id;
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
        
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
      
                String kombinacija = rs.getString("kombinacija");
                int brPogodjenihNaMestu = rs.getInt("namestu");
                int brPogodjenihNisuNaMestu = rs.getInt("vanmesta");
                
                Igra igra = new Igra(-1, kombinacija, brPogodjenihNaMestu, brPogodjenihNisuNaMestu);//kod klijenta imamo sistem koji sam racuna rb, ali svakako ne treba da uzimamo id ovde; mozemo da ostavimo i -1 jer nam nije to ovde bitno
                lista.add(igra);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    
}
