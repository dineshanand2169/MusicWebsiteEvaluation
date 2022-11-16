package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Basket;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
    @Query("select basket from Basket basket where basket.userId=:userId and basket.basketStatus=:basketStatus")
    Basket getBasketByUserId(@Param("userId") int userId, @Param("basketStatus") String basketStatus);
    @Query("select basket from Basket basket where basket.userId=:userId and basket.basketStatus=:basketStatus")
    List<Basket> getAllBasketByUserId(@Param("userId") int userId, @Param("basketStatus") String basketStatus);
    @Query("select basket from Basket basket where basket.basketStatus=:basketStatus")
    List<Basket> getAllBasketByStatus(@Param("basketStatus") String basketStatus);
}
