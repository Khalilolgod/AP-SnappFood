package ir.ac.kntu.services;

import ir.ac.kntu.delivery.*;
import ir.ac.kntu.time.*;
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private RestaurantType restaurantType;
    private FoodMenu foodMenu;
    private ArrayList<Delivery> deliveries;
    private ArrayList<Order> orders;
    private ArrayList<Order> deliveredOrders;//todo
    //private ArrayList <Review> reviews;
    private double rate;
    private Schedule schedule;

    public Restaurant(String name, String address, RestaurantType restaurantType, FoodMenu foodMenu, Schedule schedule) {
        this.name = name;
        this.address = address;
        this.restaurantType = restaurantType;
        this.foodMenu = foodMenu;
        this.deliveries = new ArrayList<>();
        this.schedule = schedule;
        this.rate = 5;
        this.orders = new ArrayList<>();
        this.deliveredOrders = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", restaurantType=" + restaurantType.name() +
                ", deliveries=" + deliveries.size() +
                ", orders=" + orders.size() +
                ", rate=" + rate +
                ", schedule=" + schedule +
                '}';
    }

    public boolean isActive() {
        return getSchedule().isTodayWorkDay();
    }

    public int availableDelivery() {
        int i = 0;
        for (Delivery delivery : deliveries) {
            if (delivery.getActiveOrder() == null) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean addDelivery(Delivery delivery){
        return delivery.addRestaurant(this);
    }

    public void processOrder(Order order) {
        if (order.getOrderStatus() == OrderStatus.PROCESSING) {
            int index = availableDelivery();
            if (index != -1) {
                getDeliveries().get(index).setActiveOrder(order);
                order.setDelivery(getDeliveries().get(index));
                order.setOrderStatus(OrderStatus.SENDING);
            }
        } else if (order.getOrderStatus() == OrderStatus.SENDING) {
            //TODO
            System.out.println("nigaaaaaaaaa");
        }
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

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
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
