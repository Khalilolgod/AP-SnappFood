package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.users.Costumer;

public class AdminMenu extends Menu {

    public AdminMenu(){
        super("AdminMenu.txt");
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
        switch (choice){
            case "a":
                System.out.println("enter Costumer UserName");
                String userName = ScannerWrapper.getInstance().nextLine();
                Costumer costumer = agency.findCustumer(userName);
                agency.getChooseProviderMenu().execute(agency,costumer);
                return true;
            case "b":
                agency.getDeliveryMenu().execute(agency);
                return true;
            case "c":
                agency.getRestaurantMenu().execute(agency);
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
