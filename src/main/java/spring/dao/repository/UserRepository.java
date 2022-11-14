package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
