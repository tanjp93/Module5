package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.MyBlog;
import ra.model.repository.IMyBlogRepository;

import java.util.List;
@Service
public class MyBlogServiceIMPL implements IMyBlogService {
    @Autowired
    private IMyBlogRepository myBlogRepository;
    @Override
    public List<MyBlog> findAll() {
        return  myBlogRepository.findAll();
    }

    @Override
    public MyBlog findById(Long id) {
        return  myBlogRepository.findById(id);
    }

    @Override
    public void save(MyBlog customer) {
        myBlogRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        myBlogRepository.remove(id);
    }
}
