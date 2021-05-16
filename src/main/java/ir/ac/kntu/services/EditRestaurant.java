package ir.ac.kntu.services;

import ir.ac.kntu.*;

public class EditRestaurant extends Menu {

    private Restaurant restaurant;

    public EditRestaurant (){
        super("EditRestaurant.txt");
    }

    public void editName(){
        System.out.println(restaurant.getName());
        System.out.println("new name : ");
        String name = ScannerWrapper.getInstance().nextLine();
        restaurant.setName(name);
    }

    public void editAddress(){
        System.out.println(restaurant.getAddress());
        System.out.println("new address : ");
        String address = ScannerWrapper.getInstance().nextLine();
        restaurant.setAddress(address);
    }

    public void editRestaurantType(){
        System.out.println(restaurant.getRestaurantType().name());
        int i = 'a';
        for(RestaurantType restaurantType : RestaurantType.values()){
            System.out.println(i+". "+restaurantType.name());
            i++;
        }
        System.out.println("new restaurant type : ");
        int choice = ScannerWrapper.getInstance().next()-'a';
        restaurant.setRestaurantType(RestaurantType.values()[choice]);
    }

    public void showOrders(){
        char i = 'a';
        for(Order order : restaurant.getOrders().values()){
            System.out.println(i + ". " + order);
            i++;
        }
    }

    public void addOrder(){
        Costumer costumer = new Costumer();//costumer(phone , address)
        restaurant.getFoodMenu().execute(restaurant,costumer);
    }

    public void editOrders(){
        System.out.println("a. Add         b. Remove         c. Edit");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":
                addOrder();
                break;
            case "b":
                removeOrder();
                break;
            case "c":
                editOrder();
                break;
            default:
                break;
        }

    }



    Restaurant selectRestaurant(Agency agency){
        char i = 'a';
        for (Restaurant restaurant : agency.getRestaurants()){
            System.out.println(i + ". " + restaurant);
            i++;
        }
        //System.out.println(i + ". Done");
        int choice = ScannerWrapper.getInstance().nextInt();
        return agency.getRestaurants().get(choice);
    }

    public boolean execute(Agency agency){
        this.restaurant = selectRestaurant(agency);
        showMenu();
        return inputProcessor(agency);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        return false;
    }
}
