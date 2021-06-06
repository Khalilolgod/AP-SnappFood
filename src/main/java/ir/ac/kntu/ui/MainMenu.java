package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.users.User;
import ir.ac.kntu.model.utils.ScannerWrapper;

public class MainMenu extends Menu {

    public MainMenu(){
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

    private boolean verifyUser(User user){
        System.out.print("Password : ");
        String password = ScannerWrapper.getInstance().nextLine();
        if(user.verifyUser(user.getUsername(), password)){
            return true;
        }
        return false;
    }



    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":

                return true;
            case "b":

                return true;
            case "c":

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
