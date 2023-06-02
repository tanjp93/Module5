package ra.model.service.category;

import ra.model.entity.Category;
import ra.model.entity.MyBlog;
import ra.model.service.IGenerate;

import java.util.List;

public interface ICategoryService extends IGenerate<Category> {
    Iterable<Category>findAll();

}
