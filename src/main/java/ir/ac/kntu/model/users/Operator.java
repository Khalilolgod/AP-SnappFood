package ir.ac.kntu.model.users;

import ir.ac.kntu.model.services.Provider;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.ui.AdminMenu;

public class Operator extends User{

    private Provider provider;
    private AdminMenu adminMenu;

    public Operator(String username, String password) {
        super(username, password);
        this.adminMenu = new AdminMenu();
    }


    public boolean verifyUser() {
        System.out.println("please enter your username");
        String username = ScannerWrapper.getInstance().nextLine();
        if(!getUsername().equals(username)){
            System.out.println("user doesn't exist");
            return false;
        }
        System.out.println("please enter your password");
        String password = ScannerWrapper.getInstance().nextLine();
        if(!getPassword().equals(password)){
            System.out.println("invalid password");
            return false;
        }
        return true;
    }


    public AdminMenu getOperatorMenu() {
        return adminMenu;
    }

    public void setOperatorMenu(AdminMenu adminMenu) {
        this.adminMenu = adminMenu;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
