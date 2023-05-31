package ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.Product;

public interface IProductService {
    Page<Product>findAll(Pageable pageable);
    void save(Product product);
    Page<Product>findAllByNameContaining(String name,Pageable pageable);
    Page<Product>findByNameProduct(String search,Pageable pageable);
}