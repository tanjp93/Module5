package ra.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface IGenerate<T> {
    public Page<T> findAll(Pageable pageable, Sort sort);
    public Optional<T> findById(Long id);
    public void save(T customer);
    public void remove(Long id);

}
