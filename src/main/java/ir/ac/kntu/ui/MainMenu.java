package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.users.User;
import ir.ac.kntu.model.utils.ScannerWrapper;

public class MainMenu extends Menu {


    public MainMenu() {
        super("MainMenu.txt");
    }

    public void execute(Agency agency) {
        while (true) {
            showMenu();
            if (!inputProcessor(agency)) {
                break;
            }
        }
    }

    public boolean verifyUser(User user) {
        if (user == null) {
            System.out.println("no such user exists");
            return false;
        }
        System.out.print("Password : ");
        String password = ScannerWrapper.getInstance().nextLine();
        if (user.verifyUser(user.getUsername(), password)) {
            return true;
        }
        System.out.println("wrong password");
        return false;
    }

    public void loginCostumer(Agency agency) {
        System.out.print("costumer username : ");
        String username = ScannerWrapper.getInstance().nextLine();
        Costumer costumer = agency.findCustumer(username);
        if (verifyUser(costumer)) {
            costumer.getCostumerMenu().execute(agency);
        }
    }

    public boolean loginOperator(Agency agency) {
        System.out.print("operator username : ");
        String username = ScannerWrapper.getInstance().nextLine();
        Costumer costumer = agency.findCustumer(username);
        return verifyUser(costumer);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                System.out.println("admin username : ");
                String username = ScannerWrapper.getInstance().nextLine();
                if (agency.getAdmin().getUsername().equals(username)) {
                    if (verifyUser(agency.getAdmin())) {
                        agency.getAdmin().getAdminMenu().execute(agency);
                    }
                }
                return true;
            case "b":
                if (loginOperator(agency)) {
                    //Operator menu
                    return true;
                }
                return true;
            case "c":
                loginCostumer(agency);
                return true;
            case "d":
                //setting menu
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
