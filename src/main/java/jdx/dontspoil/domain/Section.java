package jdx.dontspoil.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Section of an article.
 * Content is in markdown format.
 * Is shown from specific episode in the series.
 */
@Entity
public class Section {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(max = 1000)
    private String content;

    @ManyToOne
    private Episode showFrom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
