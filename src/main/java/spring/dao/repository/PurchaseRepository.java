package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.PurchaseDetails;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails,Integer> {
    @Query("select purchaseDetails from PurchaseDetails purchaseDetails where purchaseDetails.basketId=:basketId")
    PurchaseDetails getPurchaseByBasketId(@Param("basketId") int basketId);
}
