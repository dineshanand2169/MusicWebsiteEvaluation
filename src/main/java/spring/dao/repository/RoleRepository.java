package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Role;
import spring.model.Song;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("select role from Role role where role.role=:role")
    List<Role> getUserByRole(@Param("role") String role);
    @Query("select role from Role role where role.userName=:userName")
    Role getRoleByUserName(@Param("userName") String userName);
}
