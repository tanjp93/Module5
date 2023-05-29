package ra.model.repository.category;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Category;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
