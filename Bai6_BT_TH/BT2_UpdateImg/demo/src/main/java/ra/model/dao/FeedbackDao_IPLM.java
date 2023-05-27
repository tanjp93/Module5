package ra.model.dao;
import ra.model.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class FeedbackDao_IPLM implements IFeedbackDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> findAll() {
        TypedQuery<Feedback> query = entityManager.createQuery( "SELECT f FROM Feedback AS f", Feedback.class);
        return query.getResultList();
    }

    @Override
    public void save(Feedback feedback) {
            entityManager.persist(feedback);
    }

    @Override
    public void update(Feedback feedback) {
        entityManager.merge(feedback);
    }

    @Override
    public Feedback findById(long id) {
        String queryStr = "Select f from Feedback as f where f.id= :id ";
        TypedQuery<Feedback> query = entityManager.createQuery(queryStr, Feedback.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
