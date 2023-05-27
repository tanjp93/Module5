package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dao.IFeedbackDao;
import ra.model.entity.Feedback;

import java.util.List;

@Service
public class FeedbackServiceIMPL implements IFeedbackService{
    @Autowired
    private IFeedbackDao feedbackDao;

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
