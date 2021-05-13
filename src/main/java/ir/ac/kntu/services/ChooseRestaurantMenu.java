package ir.ac.kntu.services;

import ir.ac.kntu.Agency;
import ir.ac.kntu.Menu;
import ir.ac.kntu.ScannerWrapper;

import java.util.ArrayList;

public class ChooseRestaurant extends Menu {

    ArrayList<Restaurant> activeRestaurants;

    public void execute(Agency agency){
        showMenu(agency);
        inputProcessor(agency);
    }

    public void showMenu(Agency agency){
        activeRestaurants =  agency.activeRestaurants();
        int i = 1;
        for(Restaurant r : activeRestaurants){
            System.out.println(i+" "+r);
        }
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        int choice = ScannerWrapper.getInstance().nextInt();
        Restaurant theChosenOne = agency.getRestaurants().get(choice - 1);
        theChosenOne.getFoodMenu().execute(Agency);
        return false;
    }
}
