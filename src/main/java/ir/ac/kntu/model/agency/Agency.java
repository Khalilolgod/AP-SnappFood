package ir.ac.kntu.model.agency;

import ir.ac.kntu.model.deliverySystem.Deliverer;
import ir.ac.kntu.model.users.Admin;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.ui.*;

import java.util.ArrayList;


public class Agency {

    private Admin admin;
    private ArrayList<Provider> providers;
    private ArrayList<Deliverer> allDeliveries;
    private ArrayList<Costumer> costumers;


    private ChooseRestaurantMenu chooseRestaurantMenu;
    private DeliveryMenu deliveryMenu;
    private RestaurantMenu restaurantMenu;


    Agency() {
        this.setAdmin(new Admin("admin", "1234"));
        this.providers = new ArrayList<>();
        this.chooseRestaurantMenu = new ChooseRestaurantMenu();
        this.deliveryMenu = new DeliveryMenu();
        this.restaurantMenu = new RestaurantMenu();
        this.allDeliveries = new ArrayList<>();
    }

    public Costumer findCustumer(String username){
        for(Costumer c : costumers){
            if(c.getUsername().equals(username)){
                return c;
            }
        }
        return null;
    }

    public Operator findOperator(String username){
        for(Provider p : getProviders()){
            if(p.getOperator().getUsername().equals(username)){
                return p.getOperator();
            }
        }
        return null;
    }

    public void operatorlogin() {
        while (true) {
            if (admin.verifyUser()) {
                break;
            }
        }
        admin.getOperatorMenu().execute(this);
        System.out.println("Exit");
    }


    public ArrayList<Provider> activeRestaurants() {
        ArrayList<Provider> activeOnes = new ArrayList<>();
        for (Provider r : getProviders()) {
            if (r.isActive()) {
                activeOnes.add(r);
            }
        }
        return activeOnes;
    }


    public ArrayList<Provider> getProviders() {
        return providers;
    }

    public void setProviders(ArrayList<Provider> providers) {
        this.providers = providers;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ArrayList<Deliverer> getAllDeliveries() {
        return allDeliveries;
    }

    public void setAllDeliveries(ArrayList<Deliverer> allDeliveries) {
        this.allDeliveries = allDeliveries;
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

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;
    }
}
