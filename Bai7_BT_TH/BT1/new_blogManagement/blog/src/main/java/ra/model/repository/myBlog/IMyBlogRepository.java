package ra.model.repository.myBlog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.MyBlog;

@Repository
public interface IMyBlogRepository extends PagingAndSortingRepository<MyBlog, Long> {
    Page<MyBlog> findAllByCategoryNameContaining(String categoryName, Pageable pageable);
    Page<MyBlog> findAll(Pageable pageable);
}
