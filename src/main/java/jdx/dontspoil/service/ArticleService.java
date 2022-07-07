package jdx.dontspoil.service;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Episode;
import jdx.dontspoil.domain.Section;
import jdx.dontspoil.repository.ArticleRepository;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private EpisodeService episodeService;
    @Autowired
    private ArticleRepository articleRepository;

    private Parser parser = Parser.builder().build();

    private HtmlRenderer renderer = HtmlRenderer.builder().build();

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Page getPage(String articleReference, int bookmark) {
        String title = articleReference.replaceAll("_", " ");
        Article article = articleRepository.getByTitle(title);
        if (article == null) {
            return null;
        }
        Page page = new Page();
        page.setTitle(article.getTitle());
        List<String> htmlSections = new ArrayList<>();
        for (Section section: article.getSectionList()) {
            int episodeFrom = section.getShowFrom().getOrderingNumber();
            if (episodeFrom <= bookmark) {
                String markdown = section.getContent();
                Node document = parser.parse(markdown);
                String html = renderer.render(document);
                htmlSections.add(html);
            }
        }
        page.setHtmlSections(htmlSections);
        return page;
    }
}
