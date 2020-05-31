package spbstu.valdemar.four.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.valdemar.four.domain.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
