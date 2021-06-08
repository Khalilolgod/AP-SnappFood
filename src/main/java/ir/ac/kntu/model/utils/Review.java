package ir.ac.kntu.model.utils;

public class Review {
    private String comment;
    private boolean isByBuyer;

    public Review(String comment, boolean isByBuyer) {
        this.comment = comment;
        this.isByBuyer = isByBuyer;
    }

    public Review() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getIsByBuyer() {
        return isByBuyer;
    }

    public void setByBuyer(boolean byBuyer) {
        isByBuyer = byBuyer;
    }
}
