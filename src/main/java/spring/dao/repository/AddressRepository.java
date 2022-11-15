package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select addressDetails from Address addressDetails where addressDetails.userId=:userId")
    List<Address> getByUserId(@Param("userId") int userId);
}
