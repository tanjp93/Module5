package ra.service.roleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.model.Role;
import ra.model.RoleName;
import ra.repository.IRoleRepository;
import ra.service.IRoleService;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RoleServiceIMPL implements IRoleService {
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
