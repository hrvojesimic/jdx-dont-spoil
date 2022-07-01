package jdx.dontspoil;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Episode;
import jdx.dontspoil.domain.Section;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProbaController {
    @GetMapping("")
    public ResponseEntity<String> proba() {
        return ResponseEntity.ok("*Dobro* nam došli!");
    }

    @GetMapping("/bok/{ime}")
    public ResponseEntity<String> pozdrav(@PathVariable String ime) {
        return ResponseEntity.ok("Bok, " + ime + "!");
    }

    @GetMapping("/article/{}")
    public ResponseEntity<Article> getArticle() {
        Episode ep1 = new Episode();
        ep1.setOrderingNumber(1);
        ep1.setTitle("Fatalni ponedjeljak");
        Article article = new Article();
        article.setTitle("Čudesne avanture srednjoškolaca u CROZ-u");
        Section s1 = new Section();
        s1.setContent("Nekoć davno, bilo je osam srednjoškolaca...");
        s1.setShowFrom(ep1);
        article.setSectionList(List.of(s1));
        return ResponseEntity.ok(article);
    }

    @GetMapping("/try/markdown")
    public ResponseEntity<String> tryMarkdown() {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is **Sparta**");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(document);
        return ResponseEntity.ok(html);
    }
}
