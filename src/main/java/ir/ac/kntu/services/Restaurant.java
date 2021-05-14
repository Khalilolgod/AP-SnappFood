package ir.ac.kntu.services;

import ir.ac.kntu.delivery.*;
import ir.ac.kntu.time.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    private String name;
    private String address;//could be a class too
    private RestaurantType restaurantType;
    private FoodMenu foodMenu;
    private HashMap <String , Delivery> deliveries;//delivery id , Deliveryguy
    private HashMap <Costumer , Order> orders;
    //private ArrayList <Review> reviews;
    private double rate;
    private Schedule schedule;

    public Restaurant(String name) {
        this.name = name;
        orders = new HashMap<>();
        //making random shifts
        ArrayList<Shift> shifts =  new ArrayList<Shift>();
        Shift shift1 = new Shift(LocalTime.of(0,00) , LocalTime.of(20,00) );
        Shift shift2 = new Shift(LocalTime.of(21,0) , LocalTime.of(23,59) );
        shifts.add(shift1);
        shifts.add(shift2);
        //random workdays
        ArrayList <WorkDay> workDays = new ArrayList<WorkDay>();
        WorkDay workDay1 = new WorkDay(DayOfWeek.THURSDAY,shifts);
        workDays.add(workDay1);
        //random schedule
        this.schedule = new Schedule(workDays);

        ArrayList <Food> foods = new ArrayList<>();
        Food food1 = new Food("kabab",1000,30);
        Food food2 = new Food("morgh",2000,3);
        Food food3 = new Food("goh",3000,2);
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        foodMenu = new FoodMenu(foods);

    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean isActive(){
        return getSchedule().isTodayWorkDay();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    public HashMap<String, Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(HashMap<String, Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public HashMap<Costumer, Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Costumer, Order> orders) {
        this.orders = orders;
    }

   /*
   public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    */

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}