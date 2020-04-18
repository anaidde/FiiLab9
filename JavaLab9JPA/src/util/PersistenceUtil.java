package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static final PersistenceUtil singleton = new PersistenceUtil();
    protected EntityManagerFactory entityManager;

    public static PersistenceUtil getInstance() {
        return singleton;
    }

    private PersistenceUtil() {

    }

    protected void createEntityManagerFactory() {
        this.entityManager = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if(this.entityManager == null)
            createEntityManagerFactory();
        return this.entityManager;
    }

    public void closeEntityManagerFactory() {
        if(this.entityManager != null) {
            this.entityManager.close();
            this.entityManager = null;
        }
    }
}
