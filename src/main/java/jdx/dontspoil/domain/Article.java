package jdx.dontspoil.domain;

import java.util.List;

/**
 * Article in the wiki.
 * An article has a unique title, and body text.
 */
public class Article {
    private String title;
    private List<Section> sectionList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
