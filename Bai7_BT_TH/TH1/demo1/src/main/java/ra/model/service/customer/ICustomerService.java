package ra.model.service.customer;

import ra.model.entity.Customer;
import ra.model.entity.Province;
import ra.model.service.IGenerateService;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
