package ra.model.service;

import java.util.Optional;

public interface IGenerate<T> {
    public Iterable<T> findAll();
    public Optional<T> findById(Long id);
    public void save(T customer);
    public void remove(Long id);

}
