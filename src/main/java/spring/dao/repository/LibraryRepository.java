package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Library;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library,Integer> {
    @Query("select library from Library library where library.userId=:userId")
    List<Library> getLibraryOfUser(@Param("userId") int userId);
}
