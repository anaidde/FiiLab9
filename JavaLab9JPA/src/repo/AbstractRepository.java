package repo;

import java.sql.SQLException;

public interface AbstractRepository<T>{
    void createEntity(T entity) throws SQLException;
    T getEntityByID(int id) throws SQLException;
    void saveEntity(T entity);
    void deleteEntity(T entity);

}
