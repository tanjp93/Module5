package ra.model.service;

import java.util.List;

public interface IGenerateService <T> {
    List<T> findAll();
    void save(T feedback);
    void update(T feedback);
    T findById(long id);
}
