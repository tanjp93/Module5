package ra.model.service.myBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.model.entity.MyBlog;
import ra.model.repository.myBlog.IMyBlogRepository;

import java.util.Optional;

@Service
public class MyBlogServiceIMPL implements IMyBlogService{
    @Autowired
    private IMyBlogRepository myBlogRepository;

    @Override
    public Iterable<MyBlog> findAll() {
        return myBlogRepository.findAll();
    }

    @Override
    public Optional<MyBlog> findById(Long id) {
        return myBlogRepository.findById(id);
    }

    @Override
    public void save(MyBlog customer) {
        myBlogRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        myBlogRepository.deleteById(id);
    }

    @Override
    public Page<MyBlog> findAll(Pageable pageable) {
        return myBlogRepository.findAll(pageable);
    }

    @Override
    public Page<MyBlog> findAllByCategoryNameContaining(String categoryName, Pageable pageable) {
        return null;
    }
}
