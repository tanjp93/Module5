package ra.model.repository;

import ra.model.entity.MyBlog;

import javax.transaction.Transactional;
import java.util.List;
public interface IMyBlogRepository extends IGeneralRepository <MyBlog> {
}
