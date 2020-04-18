package app;


import entity.Albums;
import entity.Artists;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
        Artists artist = new Artists();
//        artist.setName("OCS");
//        artist.setCountry("Romania");
//        ArtistRepository.create(artist);
        System.out.println(ArtistRepository.findByID(8));
        System.out.println(ArtistRepository.findByName("RHCP"));
        System.out.println(AlbumRepository.findByID(7));
        System.out.println(AlbumRepository.findByName("Californication"));
        System.out.println(AlbumRepository.findByArtist(ArtistRepository.findByName("RHCP")));
        AlbumRepository.close();

    }
}
