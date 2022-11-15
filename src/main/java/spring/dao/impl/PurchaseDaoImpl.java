package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.PurchaseDetailsDao;
import spring.dao.repository.PurchaseRepository;
import spring.model.PurchaseDetails;

import java.sql.SQLException;
import java.util.List;

public class PurchaseDaoImpl implements PurchaseDetailsDao {
    @Autowired
    PurchaseRepository purchaseRepository;

    public PurchaseRepository getPurchaseRepository() {
        return purchaseRepository;
    }

    public void setPurchaseRepository(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void insertPurchase(PurchaseDetails purchaseDetails) {
        purchaseRepository.save(purchaseDetails);

    }

    @Override
    public List<PurchaseDetails> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public void updatePurchase(PurchaseDetails purchaseDetails) {
        purchaseRepository.save(purchaseDetails);

    }

    @Override
    public void deletePurchase(int purchaseId) throws SQLException {
        purchaseRepository.deleteById(purchaseId);

    }

    @Override
    public PurchaseDetails getPurchaseById(int purchaseId) throws SQLException {
        return purchaseRepository.findById(purchaseId).get();
    }
}
