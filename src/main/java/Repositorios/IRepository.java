package Repositorios;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    boolean create(T entity);
    Optional<T> findById(String id);
    List<T> findAll();
    boolean update(T entity);
    boolean delete(String id);
}
