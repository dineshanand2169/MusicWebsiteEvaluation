package spring.service;

import spring.model.Library;

import java.sql.SQLException;
import java.util.List;

public interface LibraryService {
    void insertLibrary(List<Library> library);

    List<Library> getAllLibrary();

    void updateLibrary(Library library);

    void deleteLibrary(int libraryId) throws SQLException;

    Library getLibraryById(int libraryId) throws SQLException;
    List<Library> getLibraryOfUser(int userId);
}
