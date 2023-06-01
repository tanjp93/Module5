package ra.service;

import java.util.Optional;

public interface IProductService <Product>{
    Iterable<Product>findAll();
    Optional<Product>findById(Long id);
}
