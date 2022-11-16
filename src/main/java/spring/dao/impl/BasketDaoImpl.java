package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.BasketDao;
import spring.dao.repository.BasketRepository;
import spring.model.Basket;

import java.sql.SQLException;
import java.util.List;

public class BasketDaoImpl implements BasketDao {
    @Autowired
    BasketRepository basketRepository;

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public void setBasketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void insertBasket(Basket basket) {
        basketRepository.save(basket);

    }

    @Override
    public List<Basket> getAllBasket() {
        return basketRepository.findAll();
    }

    @Override
    public void updateBasket(Basket basket) {
        basketRepository.save(basket);

    }

    @Override
    public void deleteBasket(int basketId) throws SQLException {
        basketRepository.deleteById(basketId);

    }

    @Override
    public Basket getBasketById(int basketId) throws SQLException {
        return basketRepository.findById(basketId).get();
    }

    @Override
    public Basket getBasketByUserId(int userId, String basketStatus) {
        return basketRepository.getBasketByUserId(userId,basketStatus);
    }

    @Override
    public List<Basket> getAllBasketByUserId(int userId, String basketStatus) {
        return basketRepository.getAllBasketByUserId(userId,basketStatus);
    }

    @Override
    public List<Basket> getAllBasketByStatus(String basketStatus) {
        return basketRepository.getAllBasketByStatus(basketStatus);
    }
}
