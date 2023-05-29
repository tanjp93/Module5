package ra.model.repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T customer);

    void remove(Long id);

}
