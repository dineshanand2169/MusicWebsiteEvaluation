package spring.service;

import org.springframework.web.servlet.ModelAndView;
import spring.model.Basket;
import spring.model.Library;
import spring.model.Song;

import java.sql.SQLException;
import java.util.List;

public interface ValidationService {
    ModelAndView categorizeSongsForUser(int userId) throws SQLException;

    Basket validateUserBasket(int userId);

    List<Song> getLibrarySongs(int userId, List<Library> libraryList) throws SQLException;

    ModelAndView basketStatusValidation(int userId) throws SQLException;
}
