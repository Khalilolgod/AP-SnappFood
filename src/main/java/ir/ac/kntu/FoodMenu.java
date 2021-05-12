package ir.ac.kntu;

import java.util.ArrayList;

public class FoodMenu {

    ArrayList <Food> foods;

    /**
     * shows food names and their price
     */
    void showFoods(){
        for(Food food : foods ){
            System.out.println(food);
        }
    }

    void showMenu(){
        showFoods();
    }

    void handleMenu(){
        //TODO
     }

}
