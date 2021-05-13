package ir.ac.kntu;

import ir.ac.kntu.services.*;

import java.util.ArrayList;


public class Agency {
    private ArrayList <Restaurant> restaurants;
    private Operator operator;

    private ChooseRestaurantMenu chooseRestaurantMenu;

    Agency()
    {
        this.setOperator(new Operator("admin" , "1234"));
        this.restaurants = new ArrayList<>();
        this.chooseRestaurantMenu = new ChooseRestaurantMenu();
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
}
