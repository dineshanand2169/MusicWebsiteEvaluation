package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.ContentDao;
import spring.dao.repository.ContentRepository;
import spring.model.Content;

import java.sql.SQLException;
import java.util.List;

public class ContentDaoImpl implements ContentDao {
    @Autowired
    ContentRepository contentRepository;

    public ContentRepository getContentRepository() {
        return contentRepository;
    }

    public void setContentRepository(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public void insertContent(Content content) {
        contentRepository.save(content);

    }

    @Override
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public void updateContent(Content content) {
        contentRepository.save(content);

    }

    @Override
    public void deleteContent(int contentId) throws SQLException {
        contentRepository.deleteById(contentId);

    }

    @Override
    public Content getContentById(int contentId) throws SQLException {
        return contentRepository.findById(contentId).get();
    }
}
