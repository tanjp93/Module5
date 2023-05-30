package ra.model.repository.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Comment;
@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment,Long> {
    Page<Comment> findAllByImgOfDay(String imgPath, Pageable pageable);
    Page<Comment>findAll(Pageable pageable);
}
