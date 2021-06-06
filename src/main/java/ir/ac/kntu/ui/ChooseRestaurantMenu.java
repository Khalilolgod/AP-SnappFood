package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.Provider;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.users.Costumer;

import java.util.ArrayList;

public class ChooseRestaurantMenu {

    private ArrayList<Provider> activeProviders;

    public void execute(Agency agency, Costumer costumer) {
        showMenu(agency);
        inputProcessor(agency, costumer);
    }

    public void showMenu(Agency agency) {
        activeProviders = agency.activeRestaurants();
        char i = 'a';
        for (Provider r : activeProviders) {
            System.out.println(i + ". " + r);
            i++;
        }
    }

    public boolean inputProcessor(Agency agency, Costumer costumer) {
        System.out.println("restaurant : ");
        int choice = ScannerWrapper.getInstance().next() - 'a';
        Provider theChosenOne = activeProviders.get(choice);
        theChosenOne.getFoodMenu().execute(theChosenOne, costumer);
        return false;
    }

    public ArrayList<Provider> getActiveRestaurants() {
        return activeProviders;
    }

    public void setActiveRestaurants(ArrayList<Provider> activeProviders) {
        this.activeProviders = activeProviders;
    }
}
