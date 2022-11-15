package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Basket;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
    @Query("select basket from Basket basket where basket.userId=:userId and basket.basketStatus=:basketStatus")
    Basket getBasketByUserId(@Param("userId") int userId, @Param("basketStatus") String basketStatus);
}
