package ir.ac.kntu.services;

import ir.ac.kntu.Agency;
import ir.ac.kntu.Menu;

public class EditRestaurant extends Menu {

    public EditRestaurant (){
        super("EditRestaurant.txt");
    }

    public boolean execute(Agency agency){
        showMenu();
        return inputProcessor(agency);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        return false;
    }
}
