package app;


import entity.Albums;
import entity.Artists;
import repo.AlbumRepository;
import repo.AlbumRepositoryJDBC;
import repo.ArtistRepositoryJDBC;
import repo.ArtistRepository;
import util.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class AlbumManager {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        File file = new File("C:\\Users\\dadam\\OneDrive\\Desktop\\Sem2An2\\PA\\JavaLab9JPA\\src\\app\\initializationFile.txt");
        Scanner scanner = new Scanner(file);
        Database database = Database.getInstance();
        Artists artist = new Artists();
        Albums albums = new Albums();
        AlbumRepositoryJDBC albumJDBC = new AlbumRepositoryJDBC();
        ArtistRepositoryJDBC artistJDBC = new ArtistRepositoryJDBC();
        int index = 0;
        while(scanner.hasNextLine()) {
            String option = scanner.nextLine();
            index ++;
            if(option.equals("JPA")) {
                System.out.println("From JPA: ");
                System.out.println(ArtistRepository.findByID(8));
                System.out.println(ArtistRepository.findByName("RHCP"));
                System.out.println(AlbumRepository.findByID(7));
                System.out.println(AlbumRepository.findByName("Californication"));
                System.out.println(AlbumRepository.findByArtist(ArtistRepository.findByName("RHCP")));
            } else {
                System.out.println("From JDBC");
                System.out.println(albumJDBC.getEntityByID(7));
                System.out.println(artistJDBC.getEntityByID(6));
            }
        }
        scanner.close();
        AlbumRepository.close();
        artistJDBC.endConnecion(database);
    }
}
