package jdx.dontspoil.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Episode of a series, unit of watching.
 * Each episode has a distinct ordering number, and a unique title.
 */
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Integer id;
    private int orderingNumber;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderingNumber() {
        return orderingNumber;
    }

    public void setOrderingNumber(int orderingNumber) {
        this.orderingNumber = orderingNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
