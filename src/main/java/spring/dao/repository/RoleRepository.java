package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
