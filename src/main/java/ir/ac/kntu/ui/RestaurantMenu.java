package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.services.*;


public class RestaurantMenu extends Menu {

    private EditRestaurant editRestaurant;

    private NewRestaurant newRestaurant;

    public RestaurantMenu() {
        super("RestaurantsMenu.txt");
        this.editRestaurant = new EditRestaurant();
        this.newRestaurant = new NewRestaurant();
    }

    public boolean execute(Agency agency) {
        do {
            showMenu();
        } while (inputProcessor(agency));
        return false;
    }

    public void showRestaurants(Agency agency) {
        char i = 'a';
        for (Provider r : agency.getRestaurants()) {
            System.out.println(i + ". " + r);
            i++;
        }
    }



    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                showRestaurants(agency);
                return true;
            case "b":
                editRestaurant.execute(agency);
                return true;
            case "c":
                newRestaurant.execute(agency);
                return true;
            case "d":
                return false;
            default:
                return false;
        }
    }
}
