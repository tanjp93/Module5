package ra.security.userPrincipal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ra.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserPrincipal implements UserDetails {

    private Long id;
    private String userName;
    @JsonIgnore
    private String password;
    private String fullName;
    private String avatar;
    private String phone;
    private Collection<? extends GrantedAuthority> roles;
    public static UserPrincipal build(User user){
        List<GrantedAuthority>grantedAuthorities=user.getRoles().stream().map(
                role->new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
        return UserPrincipal.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .fullName(user.getFullName())
                .avatar(user.getAvatar())
                .phone(user.getPhone())
                .roles(grantedAuthorities)
                .build();

    };

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
