package ra.model.service.myBlog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.MyBlog;
import ra.model.service.IGenerate;

public interface IMyBlogService extends IGenerate<MyBlog> {
    public Page<MyBlog> findAll(Pageable pageable);
    public Page<MyBlog> findAllByCategoryNameContaining(String categoryName, Pageable pageable);

}
