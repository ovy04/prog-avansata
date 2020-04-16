/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lab8.entity.Albums;
import lab8.entity.Artists;
import lab8.util.PersistenceUtil;

/**
 *
 * @author agach
 */
public class AlbumRepository {
    public static void create(Albums album) {
        EntityManager em;
        em = PersistenceUtil.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        PersistenceUtil.closeFactory();
        em.close();
    }
    
    public static Albums findById(int id) {
        EntityManager em;
        em = PersistenceUtil.getFactory().createEntityManager();
        Albums album = (Albums) em.createNamedQuery("Albums.findById").setParameter("id", id).getSingleResult();
        PersistenceUtil.closeFactory();
        em.close();
        return album;
    }
    
    public static List<Albums> findByName(String name) {
        EntityManager em;
        em=PersistenceUtil.getFactory().createEntityManager();
        TypedQuery<Albums> query = em.createNamedQuery("Albums.findByName", Albums.class).setParameter("name", name);
        List<Albums> albums = query.getResultList();
        PersistenceUtil.closeFactory();
        em.close();
        return albums;
    }
    
    public static List<Albums> findByArtist(Artists artistId) {
        EntityManager em;
        em=PersistenceUtil.getFactory().createEntityManager();
        TypedQuery<Albums> query = em.createNamedQuery("Albums.findByArtistId", Albums.class).setParameter("artistId", artistId);
        List<Albums> albums = query.getResultList();
        PersistenceUtil.closeFactory();
        em.close();
        return albums;
    }
}
