package ir.ac.kntu.model.services;

import ir.ac.kntu.model.utils.Review;

import java.util.ArrayList;

public class Product {

    private String name;
    private double price;
    private int prepTime;
    private double rate;
    private ArrayList<Review> reviews;
    private Provider provider;


    /**
     *
     * @param name name of your food
     * @param price by Tomans
     * @param prepTime by minutes
     */
    public Product(String name, double price, int prepTime) {
        this.setName(name);
        this.setPrice(price);
        this.setPrepTime(prepTime);
        this.setRate(5);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", prepTime=" + prepTime +
                ", rate=" + rate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    /*public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

     */
}
