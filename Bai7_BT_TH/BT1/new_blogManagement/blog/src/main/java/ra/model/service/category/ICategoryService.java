package ra.model.service.category;

import ra.model.entity.Category;
import ra.model.service.IGenerate;

public interface ICategoryService extends IGenerate<Category> {
    Iterable<Category>findAll();
}
