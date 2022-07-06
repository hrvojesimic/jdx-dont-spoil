package jdx.dontspoil.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Article in the wiki.
 * An article has a unique title, and body text.
 * Body text is made up from sections.
 */
@Entity
public class Article {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return title.replaceAll(" ", "_");
    }
}
