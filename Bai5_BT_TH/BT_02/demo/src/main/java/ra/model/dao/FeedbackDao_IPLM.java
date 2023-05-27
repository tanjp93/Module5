package ra.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Update;
import ra.model.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FeedbackDao_IPLM implements IFeedbackDao{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory=new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager=sessionFactory.createEntityManager();
        }catch (HibernateException hibernateException){
            hibernateException.printStackTrace();
        }
    }
    @Override
    public List<Feedback> findAll() {
        String queryStr = "SELECT f FROM Feedback AS f";
        TypedQuery<Feedback> query=entityManager.createQuery(queryStr,Feedback.class);
        return query.getResultList();
    }

    @Override
    public void save(Feedback feedback) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(feedback);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }
    @Override
    public void update(Feedback feedback) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            Feedback feedback1=new Feedback(feedback.getId(),feedback.getAuthor(),feedback.getFeedback(),feedback.getStar(),feedback.getCountStar());
            session.update(feedback1);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public Feedback findById(long id) {
        String queryStr="Select f from Feedback as f where f.id= :id ";
        TypedQuery<Feedback>query=entityManager.createQuery(queryStr,Feedback.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
