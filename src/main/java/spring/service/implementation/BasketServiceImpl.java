package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.BasketDao;
import spring.model.Basket;
import spring.service.BasketService;

import java.sql.SQLException;
import java.util.List;

public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketDao basketDao;

    public BasketDao getBasketDao() {
        return basketDao;
    }

    public void setBasketDao(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    @Override
    public void insertBasket(Basket basket) {
        basketDao.insertBasket(basket);

    }

    @Override
    public List<Basket> getAllBasket() {
        return basketDao.getAllBasket();
    }

    @Override
    public void updateBasket(Basket basket) {
        basketDao.updateBasket(basket);
    }

    @Override
    public void deleteBasket(int basketId) throws SQLException {
        basketDao.deleteBasket(basketId);
    }

    @Override
    public Basket getBasketById(int basketId) throws SQLException {
        return basketDao.getBasketById(basketId);
    }

    @Override
    public Basket getBasketByUserId(int userId, String basketStatus) {
        return basketDao.getBasketByUserId(userId,basketStatus);
    }

    @Override
    public List<Basket> getAllBasketByUserId(int userId, String basketStatus) {
        return basketDao.getAllBasketByUserId(userId,basketStatus);
    }

    @Override
    public List<Basket> getAllBasketByStatus(String basketStatus) {
        return basketDao.getAllBasketByStatus(basketStatus);
    }
}
