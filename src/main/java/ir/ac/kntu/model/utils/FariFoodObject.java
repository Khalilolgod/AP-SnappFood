package ir.ac.kntu.model.utils;

import java.util.ArrayList;

public class FariFoodObject {

    private ArrayList<Review> reviews;

    public FariFoodObject(){
        reviews = new ArrayList<>();
    }

    public ArrayList<Review> getReveiws() {
        return reviews;
    }

    public void setReveiws(ArrayList<Review> reveiws) {
        this.reviews = reveiws;
    }
}
