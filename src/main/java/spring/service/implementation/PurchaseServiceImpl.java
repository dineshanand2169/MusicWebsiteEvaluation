package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.PurchaseDetailsDao;
import spring.model.PurchaseDetails;
import spring.service.PurchaseDetailsService;

import java.sql.SQLException;
import java.util.List;

public class PurchaseServiceImpl implements PurchaseDetailsService {
    @Autowired
    PurchaseDetailsDao purchaseDetailsDao;

    public PurchaseDetailsDao getPurchaseDetailsDao() {
        return purchaseDetailsDao;
    }

    public void setPurchaseDetailsDao(PurchaseDetailsDao purchaseDetailsDao) {
        this.purchaseDetailsDao = purchaseDetailsDao;
    }

    @Override
    public void insertPurchase(PurchaseDetails purchaseDetails) {
        purchaseDetailsDao.insertPurchase(purchaseDetails);

    }

    @Override
    public List<PurchaseDetails> getAllPurchase() {
        return purchaseDetailsDao.getAllPurchase();
    }

    @Override
    public void updatePurchase(PurchaseDetails purchaseDetails) {
        purchaseDetailsDao.updatePurchase(purchaseDetails);

    }

    @Override
    public void deletePurchase(int purchaseId) throws SQLException {
        purchaseDetailsDao.deletePurchase(purchaseId);

    }

    @Override
    public PurchaseDetails getPurchaseById(int purchaseId) throws SQLException {
        return purchaseDetailsDao.getPurchaseById(purchaseId);
    }
}
