package ra.model.dao;

import java.util.List;

public interface IDao<T> {
    List<T> findAll();
    void save(T feedback);
    void update(T feedback);
    T findById(long id);
}
