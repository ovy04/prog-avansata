/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;
import java.sql.*;

/**
 *
 * @author agach
 */
public class Lab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArtistDAO artistdao = new ArtistController();
        artistdao.create("ovidiu", "romania");
        for(Artist i:artistdao.getArtists()) {
            System.out.println(i.getName());
        }
        artistdao.findByName("ovidiu");
        AlbumDAO albumdao = new AlbumController();
        albumdao.create("album1", 1, 2020);
        albumdao.findByArtist(1);
        for(Album i:albumdao.getAlbums()) {
            System.out.println(i.getName());
        }
    }
    
}
