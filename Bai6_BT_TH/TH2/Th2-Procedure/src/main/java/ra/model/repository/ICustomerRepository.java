package ra.model.repository;

import ra.model.entity.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);

}
