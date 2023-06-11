package ra.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.myproject.model.Role;
import ra.myproject.model.RoleName;

import java.util.Optional;

public interface IRoleRespository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}
