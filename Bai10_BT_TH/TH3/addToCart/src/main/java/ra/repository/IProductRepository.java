package ra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ra.model.Product;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
