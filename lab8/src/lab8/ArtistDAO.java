/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.List;

/**
 *
 * @author agach
 */
public interface ArtistDAO {
    public List<Artist> getArtists();
    public void create(String name, String country);
    public void findByName(String name);
}
