package ra.model.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ra.model.entity.MySong;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MySongIMPL implements IMySongService{
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
    public List<MySong> findAll() {
        String queryStr = "SELECT e FROM MySong AS e";
        TypedQuery <MySong> query=entityManager.createQuery(queryStr,MySong.class);
        return query.getResultList();
    }

    @Override
    public MySong findById(Long id) {
       String queryStr="Select e from MySong as e where e.id= :id";
       TypedQuery<MySong> query=entityManager.createQuery(queryStr,MySong.class);
       query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
       
    }

    @Override
    public void save(MySong song) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(song);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void update(MySong song) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            MySong updateSong=new MySong(song.getId(),song.getName(), song.getPathSong());
            session.update(updateSong);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
