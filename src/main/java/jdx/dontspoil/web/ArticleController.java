package jdx.dontspoil.web;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.service.ArticleService;
import jdx.dontspoil.service.EpisodeService;
import jdx.dontspoil.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/a/{reference}")
    public String articlePage(
            @PathVariable String reference,
            Model model,
            @CookieValue(name="bookmark", defaultValue="0") int bookmark
    ) {
        BookmarkCommand bookmarkCommand = new BookmarkCommand();
        bookmarkCommand.setEpisodeNumber(bookmark);
        Page page = articleService.getPage(reference, bookmark);
        if (page == null) {
            Article article = new Article();
            article.setTitle(reference.replaceAll("_", " "));
            model.addAttribute("article", article);
            return "createArticle";
        }
        model.addAttribute("page", page);
        model.addAttribute("episodes", episodeService.getAllEpisodes());
        model.addAttribute("articles", articleService.getAllArticles());
        model.addAttribute("bookmarkCommand", bookmarkCommand);
        return "article";
    }

    @PostMapping("/bookmark")
    public String bookmark(BookmarkCommand bookmarkCommand, HttpServletResponse response) {
        int bookmark = bookmarkCommand.getEpisodeNumber();
        response.addCookie(new Cookie("bookmark", String.valueOf(bookmark)));
        return "redirect:/";
    }

    @GetMapping("/a")
    public String newArticleForm(Model model) {
        Article article = new Article();
        article.setTitle("");
        article.setSectionList(List.of());
        model.addAttribute("article", article);
        return "createArticle";
    }

    @PostMapping("/a")
    public String createArticle(Article article) {
        article.setSectionList(List.of());
        articleService.createArticle(article);
        return "redirect:/a/" + article.getReference();
    }
}
