package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
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
        Basket basket = basketService.getBasketByUserId(userId,"Pending");
        if (basket != null) {
            List<Content> contentList = basket.getContentList();
            for (Content content : contentList) {
                songList1.add(getSongById(content.getSongId()));
            }
        }
        songList.removeAll(songList1);
        return songList;
    }
}
