package jdx.dontspoil.web;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.service.ArticleService;
import jdx.dontspoil.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/a")
    public String articlePage(Model model) {
        Article article = articleService.createArticle();
        model.addAttribute("article", article);
        model.addAttribute("episodes", episodeService.getAllEpisodes());
        return "article";
    }
}
