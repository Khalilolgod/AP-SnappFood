package ir.ac.kntu.services;

import ir.ac.kntu.*;

public class EditOrder extends Menu {

    public EditOrder(){
        super("EditOrder.txt");
    }

    public boolean execute(Restaurant restaurant){
        showMenu();
        return inputProcessor(restaurant);
    }



    public boolean inputProcessor(Restaurant restaurant) {
        return true;
    }


    //any good suggestion to avoid this type of problems? TODO
    @Override
    public boolean inputProcessor(Agency agency) {
        return false;
    }
}
