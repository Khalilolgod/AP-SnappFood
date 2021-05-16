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
