package ra.model.service;

import java.util.List;

public interface IGeneralService <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T customer);

    void remove(Long id);
}
