package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select user from User user where user.userName=:userName")
    public User getUserByUserName(@Param("userName") String name);

    @Query("select user from User user where user.status=:status")
    List<User> getUserByStatus(@Param("status") String status);
}
