package ra.model.repository.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.Category;
import ra.model.entity.MyBlog;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {


}
