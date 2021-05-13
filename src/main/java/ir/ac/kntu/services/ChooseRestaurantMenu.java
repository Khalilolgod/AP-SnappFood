package ir.ac.kntu.services;

import ir.ac.kntu.Agency;
import ir.ac.kntu.ScannerWrapper;

import java.util.ArrayList;

public class ChooseRestaurantMenu  {

    ArrayList<Restaurant> activeRestaurants;

    public void execute(Agency agency,Costumer costumer){
        showMenu(agency);
        inputProcessor(agency,costumer );
    }

    public void showMenu(Agency agency){
        activeRestaurants =  agency.activeRestaurants();
        char i = 'a';
        for(Restaurant r : activeRestaurants){
            System.out.println(i+". "+r);
            i++;
        }
    }

    public boolean inputProcessor(Agency agency,Costumer costumer) {
        int choice = ScannerWrapper.getInstance().next()-'a';
        Restaurant theChosenOne = agency.getRestaurants().get(choice);
        theChosenOne.getFoodMenu().execute(theChosenOne,costumer);
        return false;
    }
}
