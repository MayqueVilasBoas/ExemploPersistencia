package br.com.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UnidadePersistencia {
    
    private static final EntityManagerFactory em = 
            Persistence.createEntityManagerFactory("PersistenciaPU");
    
    public static EntityManager createEntityManager() {
        return em.createEntityManager();
    }
    
}
