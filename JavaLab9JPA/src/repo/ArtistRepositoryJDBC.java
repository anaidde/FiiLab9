package repo;

import entity.Artists;
import util.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistRepositoryJDBC implements AbstractRepository<Artists> {
    @Override
    public void createEntity(Artists entity) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement insertionStatement = database.getStatement("INSERT INTO Artists(name, country) VALUES (?, ?)");
        insertionStatement.setString(1, entity.getName());
        insertionStatement.setString(2, entity.getCountry());
        insertionStatement.execute();
        insertionStatement.close();
    }

    @Override
    public Artists getEntityByID(int id) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement getArtistsStatement = database.getStatement("SELECT ID, Name, Country FROM Artists WHERE id = ?");
        getArtistsStatement.setInt(1, id);
        ResultSet artistRows = getArtistsStatement.executeQuery();
        Artists artistToBeReturned = new Artists();
        while (artistRows.next()) {
            artistToBeReturned.setId(id);
            artistToBeReturned.setName(artistRows.getString(2));
            artistToBeReturned.setCountry(artistRows.getString(3));
        }
        artistRows.close();
        getArtistsStatement.close();
        //database.endConnection();
        return artistToBeReturned;
    }

    @Override
    public void saveEntity(Artists entity) {
        Artists artists = new Artists();
        artists.setId(entity.getId());
        artists.setName(entity.getName());
        artists.setCountry(entity.getCountry());
    }

    @Override
    public void deleteEntity(Artists entity) {
        entity = null;
    }

    public void endConnecion(Database database) throws SQLException {
        database.endConnection();
    }

}
