package repo;

import entity.Albums;
import entity.Artists;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class AlbumRepository {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void create(Albums album){
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();

    }

    public static Albums findByID(int id) {

        entityManager.getTransaction().begin();
        Albums albumFound = entityManager.find(Albums.class, id);
        entityManager.getTransaction().commit();

        return albumFound;
    }

    public static Albums findByName(String name) {
        entityManager.getTransaction().begin();
        Albums albumFound = (Albums) entityManager.createNamedQuery
                ("Albums.findByName")
                .setParameter("name", name)
                .getSingleResult();

        entityManager.getTransaction().commit();
        return albumFound;
    }

    public static Albums findByArtist(Artists artist) {
        entityManager.getTransaction().begin();


        Albums albumsFound = entityManager.createNamedQuery(
                "Albums.findByArtistID", Albums.class)
               .setParameter("id", artist.getId())
                .getSingleResult();
        entityManager.getTransaction().commit();
        return albumsFound;
    }

    public static void close() {
        entityManager.close();
    }

}
