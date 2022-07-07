package jdx.dontspoil;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Episode;
import jdx.dontspoil.domain.Section;
import jdx.dontspoil.repository.ArticleRepository;
import jdx.dontspoil.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Fills in database with some initial data.
 */
@Component
public class InitialData {
    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private Lorem lorem = LoremIpsum.getInstance();

    private static List<String> EPISODES = List.of(
            "The Vanishing of Will Byers", "The Weirdo on Maple Street",
            "Holly, Jolly", "The Body", "The Flea and the Acrobat",
            "The Monster", "The Bathtub", "The Upside Down"
    );

    public void insertAllEpisodes() {
        for (int i = 0; i < EPISODES.size(); i++) {
            String title = "1." + (i + 1) + " " + EPISODES.get(i);
            Episode episode = new Episode();
            episode.setOrderingNumber(i + 1);
            episode.setTitle(title);
            episodeRepository.save(episode);
            Article episodeArticle = new Article();
            episodeArticle.setTitle(title);
            Section s = new Section();
            String paragraphs = lorem.getParagraphs(1, 3);
            paragraphs = paragraphs.replaceAll("\n", "\n\n");
            s.setContent(paragraphs);
            s.setShowFrom(episode);
            episodeArticle.setSectionList(List.of(s));
            articleRepository.save(episodeArticle);
        }
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        System.out.println("UBACUJEM POČETNE PODATKE");
        insertAllEpisodes();
        insertHomeArticle();
    }

    private void insertHomeArticle() {
        List<Episode> episodes = episodeRepository.findAll();
        Article homeArticle = new Article();
        homeArticle.setTitle("Stranger Things");
        Section s1 = new Section();
        s1.setContent("**Stranger Things** is an American science fiction horror drama television series created by the [Duffer Brothers](/a/Duffer_Brothers) that is streaming on Netflix. The brothers serve as showrunners and are executive producers along with Shawn Levy and Dan Cohen. The first season of the series was released on Netflix on July 15, 2016");
        s1.setShowFrom(episodes.get(0));
        Section s2 = new Section();
        s2.setContent("![](https://upload.wikimedia.org/wikipedia/commons/3/38/Stranger_Things_logo.png)");
        s2.setShowFrom(episodes.get(1));
        homeArticle.setSectionList(List.of(s1, s2));
        articleRepository.save(homeArticle);
    }
}
