package jdx.dontspoil.domain;

/**
 * Episode of a series, unit of watching.
 * Each episode has a distinct ordering number, and a unique title.
 */
public class Episode {
    private int orderingNumber;
    private String title;

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
