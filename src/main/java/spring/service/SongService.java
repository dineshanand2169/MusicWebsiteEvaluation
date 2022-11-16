package spring.service;

import org.springframework.web.servlet.ModelAndView;
import spring.model.Library;
import spring.model.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongService {
    void insertSong(Song song);

    List<Song> getAllSong();

    void updateSong(Song song);

    void deleteSong(int songId) throws SQLException;
    Song getSongById(int songId) throws SQLException;
    List<Song> getSongByGenre(String genre);
   List<Song> getAvailableSongs(int userId) throws SQLException;
   ModelAndView validateSong(Song song);

}
