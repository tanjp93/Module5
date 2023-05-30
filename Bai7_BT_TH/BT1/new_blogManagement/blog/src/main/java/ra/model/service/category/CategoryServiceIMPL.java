package ra.model.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Category;
import ra.model.repository.category.ICategoryRepository;

import java.util.Optional;
@Service
public class CategoryServiceIMPL implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Page findAll(Pageable pageable, Sort sort) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category customer) {
        categoryRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
