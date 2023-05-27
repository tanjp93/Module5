package ra.model.repository;

import ra.model.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryIMPL implements ICustomerRepository {
    @PersistenceContext
    private EntityManager en;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = en.createQuery("select c from Customer as c", Customer.class);
//        System.out.println("findAll>>>"+query.getResultList());
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = en.createQuery("select c from Customer  as c where c.id= :id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            en.merge(customer);
        } else {
            en.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            en.remove(customer);
        }
    }
}
