package spring.dao;

import spring.model.PurchaseDetails;

import java.sql.SQLException;
import java.util.List;

public interface PurchaseDetailsDao {
    void insertPurchase(PurchaseDetails purchaseDetails);

    List<PurchaseDetails> getAllPurchase();

    void updatePurchase(PurchaseDetails purchaseDetails);

    void deletePurchase(int purchaseId) throws SQLException;

    PurchaseDetails getPurchaseById(int purchaseId) throws SQLException;
}
