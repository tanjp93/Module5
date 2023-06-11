package ra.service;

import ra.model.User;

import java.util.Optional;

public interface IUserService {
    boolean existsByUserName(String userName);
    boolean existsByPhone(String phone);
    Optional<User> findByUserName(String userName);
    User save(User user);
}
