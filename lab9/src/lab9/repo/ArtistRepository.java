/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lab8.util.PersistenceUtil;
import lab8.entity.Artists;
/**
 *
 * @author agach
 */
public class ArtistRepository {
    public static void create(Artists artist) {
        EntityManager em;
        em = PersistenceUtil.getFactory().createEntityManager();
        em.getTransaction().begin();
        Artists a = artist;
        em.persist(a);
        em.getTransaction().commit();
        PersistenceUtil.closeFactory();
        em.close();
    }
    
    public static Artists findById(int id) {
        EntityManager em;
        em=PersistenceUtil.getFactory().createEntityManager();
        Artists artist = (Artists) em.createNamedQuery("Artists.findById").setParameter("id", id).getSingleResult();
        PersistenceUtil.closeFactory();
        em.close();
        return artist;
    }
    
    public static List<Artists> findByName(String name) {
        EntityManager em;
        em=PersistenceUtil.getFactory().createEntityManager();
        TypedQuery<Artists> query = em.createNamedQuery("Artists.findByName", Artists.class).setParameter("name", name);
        List<Artists> artists = query.getResultList();
        PersistenceUtil.closeFactory();
        em.close();
        return artists;
    }
}
