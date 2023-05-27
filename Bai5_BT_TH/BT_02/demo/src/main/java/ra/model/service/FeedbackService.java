package ra.model.service;

import org.springframework.stereotype.Service;
import ra.model.dao.FeedbackDao_IPLM;
import ra.model.dao.IFeedbackDao;
import ra.model.entity.Feedback;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FeedbackService {
    IFeedbackDao feedbackDao = new FeedbackDao_IPLM();

    public List<Feedback> findAll() {
        return feedbackDao.findAll();
    }

    public void save(Feedback feedback) {
        feedbackDao.save(feedback);
    }

    public void update(Feedback feedback) {
        feedbackDao.update(feedback);
    }

    public Feedback findById(long id) {
        return feedbackDao.findById(id);
    }
}
