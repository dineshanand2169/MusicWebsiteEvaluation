package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.SongDao;
import spring.dao.repository.SongRepository;
import spring.model.Song;

import java.sql.SQLException;
import java.util.List;

public class SongDaoImpl implements SongDao {
    @Autowired
    SongRepository songRepository;

    public SongRepository getSongRepository() {
        return songRepository;
    }

    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void insertSong(Song song) {
        songRepository.save(song);

    }

    @Override
    public List<Song> getAllSong() {
        return songRepository.findAll();
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteSong(int songId) throws SQLException {
        songRepository.deleteById(songId);

    }

    @Override
    public Song getSongById(int songId) throws SQLException {
        return songRepository.findById(songId).get();
    }

    @Override
    public List<Song> getSongByGenre(String genre) {
        return songRepository.getSongByGenre(genre);
    }
}
