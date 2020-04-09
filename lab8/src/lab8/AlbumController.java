/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author agach
 */
public class AlbumController implements AlbumDAO {
    List<Album> albums;
    public AlbumController() {
        albums = new ArrayList<>();
        Connection conn = Database.getInstance().getConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, artist_id, release_year FROM albums");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int artist_id=rs.getInt("artist_id");
                int release_year = rs.getInt("release_year");
                Album album = new Album(id, name, artist_id, release_year);
                albums.add(album);
            }
        }catch (SQLException e) {
            System.err.println("Eroare: ");
            System.err.println(e.getMessage());
        }
        try {
                conn.close();
            } catch(SQLException e) {
                System.out.println("Eroare la inchiderea conexiunii");
            }
    }
    @Override
    public List<Album> getAlbums() {
        return albums;
    }
    
    @Override
    public void create(String name, int artistId, int releaseYear) {
        Connection conn = Database.getInstance().getConnection();
        try{
            System.out.println(albums.size()+1);
            PreparedStatement pst = conn.prepareStatement("INSERT INTO albums VALUES(?, ?, ?, ?)");
            pst.setInt(1,albums.size()+1);
            pst.setString(2,name);
            pst.setInt(3,artistId);
            pst.setInt(4, releaseYear);
            pst.executeUpdate();
            System.out.println("inserare");
            Album album=new Album(albums.size()+1, name, artistId, releaseYear);
            albums.add(album);
            System.out.println("Albumul cu titlul " + name + " realizat de artistul cu id" + artistId + " scos in anul " + releaseYear + " a fost adaugat in baza de date");
        } catch(SQLException e) {
            System.out.println("Eroare la insert");
        }
        try {
                conn.close();
            } catch(SQLException e) {
                System.out.println("Eroare la inchiderea conexiunii");
            }
    }
    @Override
    public void findByArtist(int artistId) {
        Connection conn = Database.getInstance().getConnection();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, artist_id, release_year FROM albums WHERE artist_id=" + artistId);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("name");
                int artist_id=rs.getInt("artist_id");
                int release_year = rs.getInt("release_year");
                System.out.println("Albumul scos de artistul cu id " + artistId + " are idul " + id + " se numeste " + nume + " si a fost scos in data de " + release_year);
            }
        } catch(SQLException e) {
            System.out.println("Eroare la interogare");
        }
    }

}
