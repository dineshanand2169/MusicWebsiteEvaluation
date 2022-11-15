package spring.dao;

import org.springframework.data.repository.query.Param;
import spring.model.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongDao {
    void insertSong(Song song);

    List<Song> getAllSong();

    void updateSong(Song song);

    void deleteSong(int songId) throws SQLException;

    Song getSongById(int songId) throws SQLException;
    List<Song> getSongByGenre(String genre);
}
