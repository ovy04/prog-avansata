/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.app;

import lab8.entity.Artists;
import lab8.repo.ArtistRepository;

/**
 *
 * @author agach
 */
public class AlbumManager {
    public static void main(String[] args) {
        Artists artist = new Artists();
        artist.setId(10);
        artist.setName("Ovidiu");
        artist.setCountry("Romania");
        ArtistRepository.create(artist);
        System.out.println(ArtistRepository.findById(10).toString());
    }
}
