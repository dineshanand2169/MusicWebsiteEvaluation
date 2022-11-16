package spring.dao;

import org.springframework.data.repository.query.Param;
import spring.model.Library;

import java.sql.SQLException;
import java.util.List;

public interface LibraryDao {
    void insertLibrary(List<Library> library);

    List<Library> getAllLibrary();

    void updateLibrary(Library library);

    void deleteLibrary(int libraryId) throws SQLException;

    Library getLibraryById(int libraryId) throws SQLException;
    List<Library> getLibraryOfUser(int userId);
}
