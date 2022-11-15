package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.ContentDao;
import spring.model.Content;
import spring.service.ContentService;

import java.sql.SQLException;
import java.util.List;

public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentDao contentDao;

    public ContentDao getContentDao() {
        return contentDao;
    }

    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    @Override
    public void insertContent(Content content) {
        contentDao.insertContent(content);

    }

    @Override
    public List<Content> getAllContent() {
        return contentDao.getAllContent();
    }

    @Override
    public void updateContent(Content content) {
       contentDao.updateContent(content);
    }

    @Override
    public void deleteContent(int contentId) throws SQLException {
        contentDao.deleteContent(contentId);
    }

    @Override
    public Content getContentById(int contentId) throws SQLException {
        return contentDao.getContentById(contentId);
    }
}
