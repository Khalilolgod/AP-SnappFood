package ir.ac.kntu;


import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    String name;
    String address;//could be a class too
    RestaurantType restaurantType;
    FoodMenu foodMenu;
    HashMap <String , Delivery> deliveries;//delivery id , Deliveryguy
    HashMap <String , Order> orders;
    ArrayList <Review> reviews;
    double rate;
    Schedule activeTime;

}
