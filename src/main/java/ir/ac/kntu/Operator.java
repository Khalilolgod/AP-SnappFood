package ir.ac.kntu;

import ir.ac.kntu.ui.OperatorMenu;

public class Operator {

    private String username;
    private String password;
    private OperatorMenu operatorMenu;

    public Operator(String username, String password) {
        this.username = username;
        this.password = password;
        this.operatorMenu = new OperatorMenu();
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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OperatorMenu getOperatorMenu() {
        return operatorMenu;
    }

    public void setOperatorMenu(OperatorMenu operatorMenu) {
        this.operatorMenu = operatorMenu;
    }
}
