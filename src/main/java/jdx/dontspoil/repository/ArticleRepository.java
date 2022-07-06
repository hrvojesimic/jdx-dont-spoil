package jdx.dontspoil.repository;

import jdx.dontspoil.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Article getByTitle(String title);
}
