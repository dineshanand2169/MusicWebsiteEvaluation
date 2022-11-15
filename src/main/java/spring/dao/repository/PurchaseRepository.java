package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.PurchaseDetails;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails,Integer> {
}
