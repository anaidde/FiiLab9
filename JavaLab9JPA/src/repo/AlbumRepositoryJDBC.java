package repo;
import util.Database;
import entity.Albums;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryJDBC implements AbstractRepository<Albums> {

    @Override
    public void createEntity(Albums entity) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement insertionStatement = database.getStatement("INSERT INTO Albums(name, artist_id, release_year) VALUES (?, ?, ?)");
        insertionStatement.setString(1, entity.getName());
        insertionStatement.setInt(2, entity.getArtistId());
        insertionStatement.setInt(3, entity.getReleaseYear());
        insertionStatement.execute();
        insertionStatement.close();
    }

    @Override
    public Albums getEntityByID(int id) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement getAlbumsStatement = database.getStatement("SELECT * FROM Albums where id = ?");
        getAlbumsStatement.setInt(1, id);
        ResultSet albumsRows = getAlbumsStatement.executeQuery();
        Albums albumToBeReturned = new Albums();
        while (albumsRows.next()) {
            albumToBeReturned.setId(id);
            albumToBeReturned.setName(albumsRows.getString(2));
            albumToBeReturned.setArtistId(albumsRows.getInt(3));
            albumToBeReturned.setReleaseYear(albumsRows.getInt(4));
        }
        albumsRows.close();
        getAlbumsStatement.close();
        //database.endConnection();

        return albumToBeReturned;
    }

    @Override
    public void saveEntity(Albums entity) {
        Albums albums = new Albums();
        albums.setId(entity.getId());
        albums.setName(entity.getName());
        albums.setArtistId(entity.getArtistId());
        albums.setReleaseYear(entity.getReleaseYear());
    }

    @Override
    public void deleteEntity(Albums entity) {
        entity = null;
    }

    public void endConnecion(Database database) throws SQLException {
        database.endConnection();
    }

}
