package jdx.dontspoil.web;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Episode;
import jdx.dontspoil.service.ArticleService;
import jdx.dontspoil.service.EpisodeService;
import jdx.dontspoil.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SectionController {
    @Autowired
    private EpisodeService episodeService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SectionService sectionService;

    @GetMapping("/section/insert/{articleId}")
    public String getInsertSectionForm(Model model, @PathVariable Integer articleId) {
        List<Episode> episodes = episodeService.getAllEpisodes();
        InsertSectionCommand command = new InsertSectionCommand();
        command.setArticleId(articleId);
        command.setPosition(0);
        command.setShowFrom(episodes.get(1));
        command.setSectionContent("");
        model.addAttribute("command", command);
        model.addAttribute("episodes", episodes);
        return "insertSection";
    }

    @PostMapping("/section/insert")
    public String insertSection(InsertSectionCommand command) {
        sectionService.insertSection(
            command.getArticleId(),
            command.getPosition(),
            command.getSectionContent(),
            command.getShowFrom()
        );
        Article article = articleService.getArticle(command.getArticleId());
        String articleReference = article.getReference();
        return "redirect:/a/" + articleReference;
    }
}
