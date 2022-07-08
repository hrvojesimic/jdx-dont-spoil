package jdx.dontspoil.web;

import jdx.dontspoil.domain.Episode;

public class InsertSectionCommand {
    private Integer articleId;
    private String sectionContent;
    private Episode showFrom;
    private int position;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public Episode getShowFrom() {
        return showFrom;
    }

    public void setShowFrom(Episode showFrom) {
        this.showFrom = showFrom;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
