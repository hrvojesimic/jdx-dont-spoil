package jdx.dontspoil.service;

import jdx.dontspoil.domain.Article;
import jdx.dontspoil.domain.Episode;
import jdx.dontspoil.domain.Section;
import jdx.dontspoil.repository.ArticleRepository;
import jdx.dontspoil.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public void insertSection(Integer articleId, int position, String sectionContent, Episode showFrom) {
        Section s = new Section();
        s.setContent(sectionContent);
        s.setShowFrom(showFrom);
        Article article = articleRepository.findById(articleId).get();
        List<Section> sectionList = article.getSectionList();
        sectionList.add(position, s);
        articleRepository.save(article);
    }
}
