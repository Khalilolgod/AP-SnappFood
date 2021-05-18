package ir.ac.kntu.ui;

import ir.ac.kntu.*;
import ir.ac.kntu.services.*;


public class EditRestaurant extends Menu {

    private Restaurant restaurant;

    public EditRestaurant() {
        super("EditRestaurant.txt");
    }

    public boolean execute(Agency agency) {
        this.restaurant = selectRestaurant(agency);
        showMenu();
        return inputProcessor(agency);
    }

    public void editName() {
        System.out.println(restaurant.getName());
        System.out.println("new name : ");
        String name = ScannerWrapper.getInstance().nextLine();
        restaurant.setName(name);
    }

    public void editAddress() {
        System.out.println(restaurant.getAddress());
        System.out.println("new address : ");
        String address = ScannerWrapper.getInstance().nextLine();
        restaurant.setAddress(address);
    }

    public void editRestaurantType() {
        System.out.println("current Type : " + restaurant.getRestaurantType().name());
        char i = 'a';
        for (RestaurantType restaurantType : RestaurantType.values()) {
            System.out.println(i + ". " + restaurantType.name());
            i++;
        }
        System.out.println("new restaurant type : ");
        int choice = ScannerWrapper.getInstance().next() - 'a';
        restaurant.setRestaurantType(RestaurantType.values()[choice]);
    }

    public void showOrders() {
        char i = 'a';
        System.out.println(restaurant.getOrders().get(0));
        for (Order order : restaurant.getOrders()) {
            System.out.println(i + ". " + order);
            i++;
        }
    }

    public void addOrder() {
        System.out.println("enter phone number");
        String phonenumber = ScannerWrapper.getInstance().nextLine();
        System.out.println("enter address");
        String address = ScannerWrapper.getInstance().nextLine();
        Costumer costumer = new Costumer(phonenumber,address);
        restaurant.getFoodMenu().execute(restaurant, costumer);
    }

    public void removeOrder() {
        showOrders();
        int choice = ScannerWrapper.getInstance().next() - 'a';
        if(choice < restaurant.getOrders().size())
        {
            restaurant.getOrders().remove(choice);
        }
    }

    public void editOrder(Restaurant restaurant) {
        showOrders();
        int choice = ScannerWrapper.getInstance().next() - 'a';
        if(choice < restaurant.getOrders().size()) {
            restaurant.getOrders().get(choice).getEditOrder().execute(restaurant);
        }
    }

    public void editOrders() {
        System.out.println("a. Add         b. Remove         c. Edit");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                addOrder();
                break;
            case "b":
                removeOrder();
                break;
            case "c":
                editOrder(restaurant);
                break;
            default:
                break;
        }

    }

    Restaurant selectRestaurant(Agency agency) {
        char i = 'a';
        for (Restaurant restaurant : agency.getRestaurants()) {
            System.out.println(i + ". " + restaurant);
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        System.out.println(agency.getRestaurants().get(choice).hashCode());
        return agency.getRestaurants().get(choice);
    }

    public void editRate() {
        System.out.println("current rate : "+restaurant.getRate());
        System.out.println("new rate : ");
        double rate = ScannerWrapper.getInstance().nextDouble();
        restaurant.setRate(rate);
    }



    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                editName();
                return true;
            case "b":
                editAddress();
                return true;
            case "c":
                editRestaurantType();
                return true;
            case "d":
                editOrders();
                return true;
            case "e":
                return true;
            case "f":
                return true;
            case "g":
                return true;
            case "h":
                editRate();
                return true;
            case "i":
                return false;
            default:
                return false;
        }
    }
}
