package ra.model.service.customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ra.model.entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerServiceIPLM implements ICustomerService{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try{
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (HibernateException hibernateException){
            hibernateException.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer>query=entityManager.createQuery(queryStr,Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        String queryStr = "Select c from Customer as c where c.id = :id";
        TypedQuery<Customer>query=entityManager.createQuery(queryStr,Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void save(Customer customer) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Override
    public void update(Customer customer) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            Customer updateCustomer=findById(customer.getId());
            updateCustomer.setName(customer.getName());
            updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setEmail(customer.getEmail());
            session.update(updateCustomer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
