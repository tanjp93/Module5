package ra.model.service;

import ra.model.entity.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
