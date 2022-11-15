package spring.service;

import spring.model.Content;

import java.sql.SQLException;
import java.util.List;

public interface ContentService {
    void insertContent(Content content);

    List<Content> getAllContent();

    void updateContent(Content content);

    void deleteContent(int contentId) throws SQLException;

    Content getContentById(int contentId) throws SQLException;
}
