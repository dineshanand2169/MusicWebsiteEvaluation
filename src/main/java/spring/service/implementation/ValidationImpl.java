package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Basket;
import spring.model.Content;
import spring.model.Library;
import spring.model.Song;
import spring.service.BasketService;
import spring.service.SongService;
import spring.service.ValidationService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationImpl implements ValidationService {
    @Autowired
    SongService songService;
    @Autowired
    BasketService basketService;
    private static final String ACTION_1 = "Pending";
    private static final String ACTION_2 = "Approved";

    @Override
    public ModelAndView categorizeSongsForUser(int userId) throws SQLException {
        List<Song> songList = songService.getAvailableSongs(userId);
        List<Song> romanceSongs = new ArrayList<>();
        List<Song> partySongs = new ArrayList<>();
        List<Song> melodySongs = new ArrayList<>();
        List<Song> trendingSongs = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();
        for (Song song : songList) {
            if (Objects.equals(song.getGenre(), "Romance")) {
                romanceSongs.add(song);
            } else if (Objects.equals(song.getGenre(), "Party")) {
                partySongs.add(song);
            } else if (Objects.equals(song.getGenre(), "Melody")) {
                melodySongs.add(song);
            } else if (Objects.equals(song.getGenre(), "Trending")) {
                trendingSongs.add(song);
            }
        }
        modelAndView.addObject("romanceSongs", romanceSongs);
        modelAndView.addObject("partySongs", partySongs);
        modelAndView.addObject("melodySongs", melodySongs);
        modelAndView.addObject("trendingSongs", trendingSongs);
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @Override
    public Basket validateUserBasket(int userId) {
        if (basketService.getBasketByUserId(userId, ACTION_1) == null) {
            Basket basket = new Basket();
            basket.setUserId(userId);
            basket.setBasketStatus(ACTION_1);
            basketService.insertBasket(basket);
            return basket;
        } else return basketService.getBasketByUserId(userId, ACTION_1);
    }

    @Override
    public List<Song> getLibrarySongs(int userId, List<Library> libraryList) throws SQLException {
        List<Song> librarySongs = new ArrayList<>();
        for (Library library : libraryList) {
            Song song = songService.getSongById(library.getSongId());
            librarySongs.add(song);
        }
        return librarySongs;
    }

    @Override
    public ModelAndView basketStatusValidation(int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        if ((basketService.getBasketByUserId(userId, ACTION_1) == null) && (basketService.getBasketByUserId(userId, ACTION_2) == null)) {
            modelAndView.setViewName("nullBasket");
        } else if (basketService.getBasketByUserId(userId, ACTION_1) == null) {
            if (basketService.getBasketByUserId(userId, ACTION_2) != null) {
                Basket basket = basketService.getBasketByUserId(userId, ACTION_2);
                basketHandling(userId, modelAndView, basket);
                modelAndView.setViewName("approvedBasket");
            }
        } else if ((basketService.getBasketByUserId(userId, ACTION_1) != null) && (basketService.getBasketByUserId(userId, ACTION_2) == null)) {
            Basket basket = basketService.getBasketByUserId(userId, ACTION_1);
            basketHandling(userId, modelAndView, basket);
            modelAndView.setViewName("pendingBasket");
        } else if ((basketService.getBasketByUserId(userId, ACTION_1) != null) && (basketService.getBasketByUserId(userId, ACTION_2) != null)) {
            Basket pendingBasket = basketService.getBasketByUserId(userId, ACTION_1);
            Basket approvedBasket = basketService.getBasketByUserId(userId, ACTION_2);
            List<Content> pendingBasketContent = pendingBasket.getContentList();
            List<Song> pendingBasketSongs = new ArrayList<>();
            List<Content> approvedBasketContent = approvedBasket.getContentList();
            List<Song> approvedBasketSongs = new ArrayList<>();
            for (Content content : pendingBasketContent) {
                pendingBasketSongs.add(songService.getSongById(content.getSongId()));
            }
            modelAndView.addObject("pendingSongList", pendingBasketSongs);
            modelAndView.addObject("song", new Song());
            modelAndView.addObject("userId", userId);
            for (Content content : approvedBasketContent) {
                approvedBasketSongs.add(songService.getSongById(content.getSongId()));
            }
            modelAndView.addObject("approvedSongList", approvedBasketSongs);
            modelAndView.addObject("basketId", approvedBasket.getBasketId());
            modelAndView.setViewName("twoBaskets");
        }
        return modelAndView;
    }

    public void basketHandling(int userId, ModelAndView modelAndView, Basket basket) throws SQLException {
        List<Content> contentList = basket.getContentList();
        List<Song> songList = new ArrayList<>();
        for (Content content : contentList) {
            songList.add(songService.getSongById(content.getSongId()));
        }
        modelAndView.addObject("songList", songList);
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("basketId", basket.getBasketId());
    }
}
