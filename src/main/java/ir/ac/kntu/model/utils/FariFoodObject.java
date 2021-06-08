package ir.ac.kntu.model.utils;

import java.util.ArrayList;

public class FariFoodObject {

    private ArrayList<Review> reviews;

    public FariFoodObject(){
        reviews = new ArrayList<>();
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
