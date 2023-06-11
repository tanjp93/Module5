package ra.service.userService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.model.User;
import ra.repository.IUserRepository;
import ra.service.IUserService;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements IUserService  {

    private final IUserRepository userRepository;
    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByPhone(String phone) {
         return userRepository.existsByPhone(phone);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
