package ir.ac.kntu.services;

import ir.ac.kntu.Agency;
import ir.ac.kntu.ScannerWrapper;

import java.util.ArrayList;

public class FoodMenu  {

    private ArrayList <Food> foods;

    public FoodMenu(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void execute(Restaurant restaurant,Costumer costumer){
        showMenu();
        inputProcessor(restaurant,costumer);
    }

    /**
     * shows food names and their price
     */
    public void showMenu(){
        char i = 'a';
        for(Food food : getFoods()){
            System.out.println(i+". "+food);
            i++;
        }
        System.out.println(i+". " +"done");
    }

    public boolean inputProcessor(Restaurant restaurant,Costumer costumer) {
        int choice = ScannerWrapper.getInstance().next()-'a';
        Order order = new Order(costumer);
        while (choice < getFoods().size()) {
            order.addFood(foods.get(choice));
            System.out.println("added "+foods.get(choice).getName());
            System.out.println("next food: ");
            choice = ScannerWrapper.getInstance().next()-'a';
        }
        System.out.println("Total : "+order.getFinalPrice());
        restaurant.getOrders().add(order);
        System.out.println(restaurant.getOrders().get(0));
        restaurant.processOrder(order);
        return false;
    }


    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
