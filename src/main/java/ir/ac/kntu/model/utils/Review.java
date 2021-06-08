package ir.ac.kntu.model.utils;

public class Review {
    private String comment;
    private boolean isByBuyer;
    private double rate;
    private FariFoodObject fariFoodObject;

    public Review(String comment, int rate, boolean isByBuyer , FariFoodObject fariFoodObject) {
        this.comment = comment;
        this.isByBuyer = isByBuyer;
        this.rate = rate;
        this.fariFoodObject = fariFoodObject;
    }

    public Review() {

    }

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", rate=" + rate +
                ", isByBuyer=" + isByBuyer +
                '}';
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public FariFoodObject getFariFoodObject() {
        return fariFoodObject;
    }

    public void setFariFoodObject(FariFoodObject fariFoodObject) {
        this.fariFoodObject = fariFoodObject;
    }
}
