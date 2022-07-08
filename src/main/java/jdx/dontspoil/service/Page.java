package jdx.dontspoil.service;

import java.util.List;

/**
 * Page represents an article as seen by user for specific bookmark.
 * Sections are formatted in HTML.
 * Title is the same as in the article.
 */
public class Page {
    private Integer articleId;
    private String title;
    private List<String> htmlSections;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getHtmlSections() {
        return htmlSections;
    }

    public void setHtmlSections(List<String> htmlSections) {
        this.htmlSections = htmlSections;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
