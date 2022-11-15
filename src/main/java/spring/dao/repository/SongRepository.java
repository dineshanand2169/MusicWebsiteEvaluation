package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Integer> {
    @Query("select song from Song song where song.genre=:genre")
    List<Song> getSongByGenre(@Param("genre") String genre);
}
