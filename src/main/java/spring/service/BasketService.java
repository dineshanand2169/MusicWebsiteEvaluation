package spring.service;

import spring.model.Basket;

import java.sql.SQLException;
import java.util.List;

public interface BasketService {
    void insertBasket(Basket basket);

    List<Basket> getAllBasket();

    void updateBasket(Basket basket);

    void deleteBasket(int basketId) throws SQLException;

    Basket getBasketById(int basketId) throws SQLException;
    Basket getBasketByUserId(int userId, String basketStatus);
    List<Basket> getAllBasketByUserId( int userId,String basketStatus);
    List<Basket> getAllBasketByStatus(String basketStatus);

}
