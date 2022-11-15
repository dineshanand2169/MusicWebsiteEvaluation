package spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Content;

public interface ContentRepository extends JpaRepository<Content,Integer> {
}
