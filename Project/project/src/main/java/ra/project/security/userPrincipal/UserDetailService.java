package com.dsecurity.security.userPrincipal;

import com.dsecurity.model.User;
import com.dsecurity.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Failed -> NOT FOUND USE at username: " + username));

        return UserPrincipal.build(user);
    }
}
