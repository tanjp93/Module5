package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.repository.IProductRepository;

import java.util.Optional;
@Service
public class ProductServiceIMPL implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return productRepository.findById(id);
    }

}
