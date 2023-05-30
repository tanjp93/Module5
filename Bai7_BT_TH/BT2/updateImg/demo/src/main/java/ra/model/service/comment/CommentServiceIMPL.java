package ra.model.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Comment;
import ra.model.repository.comment.ICommentRepository;

import java.util.Optional;
@Service
public class CommentServiceIMPL implements ICommentService{
    @Autowired
    private ICommentRepository commentRepository;
    @Override
    public Page<Comment> findAll(Pageable pageable, Sort sort) {
        pageable= PageRequest.of(pageable.getPageNumber(), 3,sort);
        return commentRepository.findAll(pageable);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment customer) {
        commentRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
