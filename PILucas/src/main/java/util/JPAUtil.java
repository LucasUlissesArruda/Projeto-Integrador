package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("drop-pace");
    public static EntityManager getEtityManager (){
        return FACTORY.createEntityManager();
    }
}
