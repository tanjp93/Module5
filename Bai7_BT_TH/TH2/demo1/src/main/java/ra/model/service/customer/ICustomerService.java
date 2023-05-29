package ra.model.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.Customer;
import ra.model.entity.Province;
import ra.model.service.IGenerateService;

public interface ICustomerService extends IGenerateService<Customer> {
//    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer>findAllByFirstNameContaining(String firstname,Pageable pageable);
}
