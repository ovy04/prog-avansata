/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author agach
 */
public class PersistenceUtil {
    private static EntityManagerFactory factory;
    private static PersistenceUtil singleton;
    
    private PersistenceUtil() {
    }
    
    public static PersistenceUtil getInstance() {
        if(singleton == null)
            singleton = new PersistenceUtil();
        return singleton;
    }
    
    public static EntityManagerFactory getFactory() {
        if(factory==null) {
            factory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
        return factory;
    }
    
    public static void closeFactory() {
        if(factory!=null) {
            factory.close();
            factory=null;
        }
    }
}
