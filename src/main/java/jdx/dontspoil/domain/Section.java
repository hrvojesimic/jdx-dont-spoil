package jdx.dontspoil.domain;

/**
 * Section of an article.
 * Content is in markdown format.
 * Is shown from specific episode in the series.
 */
public class Section {
    private String content;
    private Episode showFrom;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Episode getShowFrom() {
        return showFrom;
    }

    public void setShowFrom(Episode showFrom) {
        this.showFrom = showFrom;
    }
}
