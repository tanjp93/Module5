package ra.model.service.myBlog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.MyBlog;
import ra.model.service.IGenerate;

public interface IMyBlogService extends IGenerate<MyBlog> {
    Iterable<MyBlog> findMyBlogListByCategoryId(Long id);
}
