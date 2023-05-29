package ra.model.repository.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import ra.model.entity.Customer;
import ra.model.entity.Province;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
