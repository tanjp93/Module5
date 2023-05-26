package ra.model.service;

import java.util.List;

public interface IService <T>{

    List<T> findAll();

    T findById(Long id);

    void deleteById(Long id);

    void save(T song);
    void update(T song);
}
