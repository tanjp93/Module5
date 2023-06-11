package ra.security.userPrincipal;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ra.model.User;
import ra.service.IUserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   User user=userService.findByUserName(username).orElseThrow(
           ()-> new UsernameNotFoundException("Failed -> Not found user"));
        return UserPrincipal.build(user);
    }
}
