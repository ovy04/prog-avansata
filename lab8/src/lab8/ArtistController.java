/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author agach
 */
public class ArtistController implements ArtistDAO {
    List<Artist> artists;
    public ArtistController() {
        artists = new ArrayList<>();
        Connection conn = Database.getInstance().getConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, country FROM artists");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country=rs.getString("country");
                Artist artist = new Artist(id, name, country);
                artists.add(artist);
            }
        }catch (SQLException e) {
            System.err.println("Eroare in constructor: ");
            System.err.println(e.getMessage());
        }
        try {
                conn.close();
            } catch(SQLException e) {
                System.out.println("Eroare la inchiderea conexiunii");
            }
    }
    @Override
    public List<Artist> getArtists() {
        return artists;
    }
    
    @Override
    public void create(String name, String country) {
        Connection conn = Database.getInstance().getConnection();
        try{
            System.out.println(artists.size()+1);
            PreparedStatement pst = conn.prepareStatement("INSERT INTO artists VALUES(?, ?, ?)");
            pst.setInt(1,artists.size()+1);
            pst.setString(2,name);
            pst.setString(3,country);
            pst.executeUpdate();
            System.out.println("inserare");
            Artist artist=new Artist(artists.size()+1, name, country);
            artists.add(artist);
            System.out.println("Artistul cu numele " + name + " din tara " + country + " a fost adaugat in baza de date");
        } catch(SQLException e) {
            System.out.println("Eroare la insert");
        }
        try {
            conn.close();
        } catch(SQLException e) {
            System.out.println("Eroare la close");
        }
    }
    
    @Override
    public void findByName(String name) {
        Connection conn = Database.getInstance().getConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, country FROM artists WHERE name='" + name + "'");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("name");
                String country=rs.getString("country");
                System.out.println("Artistul " + name + " are idul " + id + " si este din tara " + country);
            }
        } catch(SQLException e) {
            System.out.println("Eroare la interogare");
        }
        try {
            conn.close();
        } catch(SQLException e) {
            System.out.println("Eroare la close");
        }
    }


}
