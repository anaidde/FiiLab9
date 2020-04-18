package repo;

import entity.Albums;
import entity.Artists;

import javax.persistence.*;

public class ArtistRepository {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void create(Artists artist){
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();

    }

    public static Artists findByID(int id) {
        entityManager.getTransaction().begin();
        Artists artistFound = entityManager.find(Artists.class, id);
        entityManager.getTransaction().commit();

        return artistFound;
    }

    public static Artists findByName(String name) {
        entityManager.getTransaction().begin();
        Artists artistFound = (Artists) entityManager.createNamedQuery
                ("Artists.findByName")
                .setParameter("name", name)
                .getSingleResult();

        entityManager.getTransaction().commit();
        return artistFound;
    }

    public static void close() {
        entityManager.close();
    }
}
