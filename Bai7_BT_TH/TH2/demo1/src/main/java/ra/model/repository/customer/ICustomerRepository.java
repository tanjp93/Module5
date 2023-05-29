package ra.model.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Customer;
import ra.model.entity.Province;
@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
//    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstName,Pageable pageable);
}
