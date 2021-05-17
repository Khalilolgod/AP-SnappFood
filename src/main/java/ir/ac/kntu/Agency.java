package ir.ac.kntu;

import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.services.*;

import java.util.ArrayList;


public class Agency {
    private ArrayList <Restaurant> restaurants;
    private Operator operator;
    private ArrayList<Delivery> allDeliveries;

    private ChooseRestaurantMenu chooseRestaurantMenu;
    private DeliveryMenu deliveryMenu;
    private RestaurantMenu restaurantMenu;

    Agency()
    {
        this.setOperator(new Operator("admin" , "1234"));
        this.restaurants = new ArrayList<>();
        this.chooseRestaurantMenu = new ChooseRestaurantMenu();
        this.deliveryMenu = new DeliveryMenu();
        this.restaurantMenu = new RestaurantMenu();
        this.allDeliveries = new ArrayList<>();
    }

    public void operatorlogin(){
        while(true) {
            if(operator.verifyUser()){
                break;
            }
        }
        operator.getOperatorMenu().execute(this);
        System.out.println("Exit");
    }


    public  ArrayList <Restaurant> activeRestaurants(){
        ArrayList <Restaurant> activeOnes = new ArrayList<>();
        for(Restaurant r :  getRestaurants()){
            if(r.isActive()){
                activeOnes.add(r);
            }
        }
        return activeOnes;
    }


    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ChooseRestaurantMenu getChooseRestaurantMenu() {
        return chooseRestaurantMenu;
    }

    public void setChooseRestaurantMenu(ChooseRestaurantMenu chooseRestaurantMenu) {
        this.chooseRestaurantMenu = chooseRestaurantMenu;
    }

    public DeliveryMenu getDeliveryMenu() {
        return deliveryMenu;
    }

    public void setDeliveryMenu(DeliveryMenu deliveryMenu) {
        this.deliveryMenu = deliveryMenu;
    }

    public ArrayList<Delivery> getAllDeliveries() {
        return allDeliveries;
    }

    public void setAllDeliveries(ArrayList<Delivery> allDeliveries) {
        this.allDeliveries = allDeliveries;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }
}
