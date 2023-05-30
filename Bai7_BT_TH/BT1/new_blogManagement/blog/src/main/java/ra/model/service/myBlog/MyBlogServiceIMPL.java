package ra.model.service.myBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.MyBlog;
import ra.model.repository.myBlog.IMyBlogRepository;

import java.util.Optional;

@Service
public class MyBlogServiceIMPL implements IMyBlogService{
    @Autowired
    private IMyBlogRepository myBlogRepository;

    @Override
    public Page<MyBlog> findAll(Pageable pageable, Sort sort) {
        pageable= PageRequest.of(pageable.getPageNumber(),3,sort);
        return myBlogRepository.findAll(pageable);
    }

    @Override
    public Optional<MyBlog> findById(Long id) {
        return myBlogRepository.findById(id);
    }

    @Override
    public void save(MyBlog myBlog) {
        myBlogRepository.save(myBlog);
    }

    @Override
    public void remove(Long id) {
        myBlogRepository.deleteById(id);
    }
}
