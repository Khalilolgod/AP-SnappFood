package ir.ac.kntu;

import ir.ac.kntu.services.Costumer;

public class OperatorMenu extends Menu {

    OperatorMenu(){
        super("OperatorMenu.txt");
    }

    public void execute(Agency agency){
        while (true) {
            showMenu();
            if(!inputProcessor(agency)){
                break;
            }
        }
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        System.out.println(choice);
        switch (choice){
            case "a":
                Costumer costumer = new Costumer();
                agency.getChooseRestaurantMenu().execute(agency,costumer);
                return true;
            case "b":
                agency.getDeliveryMenu().execute(agency);
                return true;
            case "c":
                agency.getRestaurantMenu().editRestaurant(agency);
                return true;
            case "e":
                System.out.println("aight then imma exit");
                return false;
            default:
                System.out.println("Bad input");
                return true;
        }
    }
}
