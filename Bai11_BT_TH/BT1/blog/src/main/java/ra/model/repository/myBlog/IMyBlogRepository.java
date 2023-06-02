package ra.model.repository.myBlog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.MyBlog;

import java.util.List;

@Repository
public interface IMyBlogRepository extends PagingAndSortingRepository<MyBlog, Long> {

    List<MyBlog> findAllByCategory_Id(Long idCate);
    Page<MyBlog> findAllByCategoryNameContaining(String categoryName, Pageable pageable);
    Page<MyBlog> findAll(Pageable pageable);
    @Query("select b from MyBlog as b where b.category.id=:categoryId")
    Iterable<MyBlog>findMyBlogListByCategoryId(@Param("categoryId") Long categoryId);
}
