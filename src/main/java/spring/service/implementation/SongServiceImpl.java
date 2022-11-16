package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import spring.dao.SongDao;
import spring.model.Basket;
import spring.model.Content;
import spring.model.Library;
import spring.model.Song;
import spring.service.BasketService;
import spring.service.LibraryService;
import spring.service.SongService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SongServiceImpl implements SongService {
    @Autowired
    SongDao songDao;
    @Autowired
    LibraryService libraryService;
    @Autowired
    BasketService basketService;

    public SongDao getSongDao() {
        return songDao;
    }

    public void setSongDao(SongDao songDao) {
        this.songDao = songDao;
    }

    @Override
    public void insertSong(Song song) {
        songDao.insertSong(song);

    }

    @Override
    public List<Song> getAllSong() {
        return songDao.getAllSong();
    }

    @Override
    public void updateSong(Song song) {
        songDao.updateSong(song);

    }

    @Override
    public void deleteSong(int songId) throws SQLException {
        songDao.deleteSong(songId);

    }

    @Override
    public Song getSongById(int songId) throws SQLException {
        return songDao.getSongById(songId);
    }

    @Override
    public List<Song> getSongByGenre(String genre) {
        return songDao.getSongByGenre(genre);
    }

    @Override
    public List<Song> getAvailableSongs(int userId) throws SQLException {
        List<Song> songList = getAllSong();
        List<Library> userLibrary= libraryService.getLibraryOfUser(userId);
        List<Song>songList1 = new ArrayList<>();
        for(Library library :userLibrary){
            songList1.add(getSongById(library.getSongId()));
        }
        Basket pendingBasket = basketService.getBasketByUserId(userId,"Pending");
        if (pendingBasket != null) {
            List<Content> pendingBasketContentList = pendingBasket.getContentList();
            for (Content content : pendingBasketContentList) {
                songList1.add(getSongById(content.getSongId()));
            }
        }
        Basket approvedBasket = basketService.getBasketByUserId(userId,"Approved");
        if(approvedBasket!=null){
            List<Content> approvedBasketContentList = approvedBasket.getContentList();
            for(Content content : approvedBasketContentList){
                songList1.add(getSongById(content.getSongId()));
            }
        }
        songList.removeAll(songList1);
        return songList;
    }

    @Override
    public ModelAndView validateSong(Song song) {
        if((Objects.equals(song.getGenre(), "Romance"))||(Objects.equals(song.getGenre(), "Party"))||(Objects.equals(song.getGenre(), "Melody"))||(Objects.equals(song.getGenre(), "Trending"))){
            song.setDownloadCount(0);
            insertSong(song);
            return new ModelAndView("requestManagementSuccessful");
        }else return new ModelAndView("error");

    }
}
