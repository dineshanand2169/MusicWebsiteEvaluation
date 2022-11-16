package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.LibraryDao;
import spring.model.Library;
import spring.service.LibraryService;

import java.sql.SQLException;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryDao libraryDao;

    public LibraryDao getLibraryDao() {
        return libraryDao;
    }

    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    @Override
    public void insertLibrary(List<Library> library) {
        libraryDao.insertLibrary(library);

    }

    @Override
    public List<Library> getAllLibrary() {
        return libraryDao.getAllLibrary();
    }

    @Override
    public void updateLibrary(Library library) {
        libraryDao.updateLibrary(library);

    }

    @Override
    public void deleteLibrary(int libraryId) throws SQLException {
        libraryDao.deleteLibrary(libraryId);

    }

    @Override
    public Library getLibraryById(int libraryId) throws SQLException {
        return libraryDao.getLibraryById(libraryId);
    }

    @Override
    public List<Library> getLibraryOfUser(int userId) {
        return libraryDao.getLibraryOfUser(userId);
    }
}
