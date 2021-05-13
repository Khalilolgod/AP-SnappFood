package ir.ac.kntu.services;

import ir.ac.kntu.Agency;
import ir.ac.kntu.ScannerWrapper;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodMenu  {

    private ArrayList <Food> foods;



    public FoodMenu(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void execute(Agency agency , Restaurant restaurant){
        showMenu();
        inputProcessor(agency,restaurant);
    }

    /**
     * shows food names and their price
     */

    public void showMenu(){
        int i = 1;
        for(Food food : getFoods()){
            System.out.println(i+". "+food);
        }
    }

    public boolean inputProcessor(Agency agency,Restaurant restaurant) {
        int choice = ScannerWrapper.getInstance().nextInt();
        return true;
    }


    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
