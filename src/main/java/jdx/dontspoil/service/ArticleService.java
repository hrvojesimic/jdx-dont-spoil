package jdx.dontspoil.service;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Episode;
import jdx.dontspoil.domain.Section;
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

    private Parser parser = Parser.builder().build();

    private HtmlRenderer renderer = HtmlRenderer.builder().build();

    public Article createArticle() {
        List<Episode> episodes = episodeService.getAllEpisodes();
        Article article = new Article();
        article.setTitle("NASLOV KOJI SMO POSTAVILI PROGRAMSKI");
        Section s1 = new Section();
        s1.setContent("**Boldani tekst** običan tekst \n - prva\n - druga");
        s1.setShowFrom(episodes.get(1));
        Section s2 = new Section();
        s2.setContent("![](https://s7d2.scene7.com/is/image/PetSmart/WEB-1262551-Apr22_BSB-LOGO_StrangerThings_MO?fmt=png-alpha)");
        s2.setShowFrom(episodes.get(3));
        article.setSectionList(List.of(s1, s2));
        return article;
    }

    public Page getPage(int bookmark) {
        Article article = createArticle();
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
