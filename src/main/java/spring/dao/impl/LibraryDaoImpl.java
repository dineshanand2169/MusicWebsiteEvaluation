package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.LibraryDao;
import spring.dao.repository.LibraryRepository;
import spring.model.Library;

import java.sql.SQLException;
import java.util.List;

public class LibraryDaoImpl implements LibraryDao {
    @Autowired
    LibraryRepository libraryRepository;

    public LibraryRepository getLibraryRepository() {
        return libraryRepository;
    }

    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public void insertLibrary(List<Library> library) {
        libraryRepository.saveAll(library);

    }

    @Override
    public List<Library> getAllLibrary() {
        return libraryRepository.findAll();
    }

    @Override
    public void updateLibrary(Library library) {
        libraryRepository.save(library);

    }

    @Override
    public void deleteLibrary(int libraryId) throws SQLException {
        libraryRepository.deleteById(libraryId);

    }

    @Override
    public Library getLibraryById(int libraryId) throws SQLException {
        return libraryRepository.findById(libraryId).get();

    }

    @Override
    public List<Library> getLibraryOfUser(int userId) {
        return libraryRepository.getLibraryOfUser(userId);
    }
}
