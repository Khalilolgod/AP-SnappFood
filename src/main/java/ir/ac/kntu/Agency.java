package ir.ac.kntu;

import ir.ac.kntu.services.*;

import java.util.ArrayList;


public class Agency {
    private ArrayList <Restaurant> restaurants;
    private Operator operator;

    private ChooseRestaurant chooseRestaurant;

    Agency()
    {
        this.setOperator(new Operator("admin" , "1234"));
        this.restaurants = new ArrayList<>();
        this.chooseRestaurant = new ChooseRestaurant();
    }

    public void operatorlogin(){
        while(true) {
            if(operator.verifyUser()){
                break;
            }
        }
        operator.getOperatorMenu().execute(this);
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

    public ChooseRestaurant getChooseRestaurant() {
        return chooseRestaurant;
    }

    public void setChooseRestaurant(ChooseRestaurant chooseRestaurant) {
        this.chooseRestaurant = chooseRestaurant;
    }
}
