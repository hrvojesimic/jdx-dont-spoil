package jdx.dontspoil.service;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Section;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    public Article createArticle() {
        Article article = new Article();
        article.setTitle("NASLOV KOJI SMO POSTAVILI PROGRAMSKI");
        Section s1 = new Section();
        s1.setContent("<p>Probni tekst probni tekst tekst probni tekst.</p>");
        Section s2 = new Section();
        s2.setContent("<p>Neki drugi tekst. Neki drugi tekst.</p>");
        article.setSectionList(List.of(s1, s2));
        return article;
    }
}
