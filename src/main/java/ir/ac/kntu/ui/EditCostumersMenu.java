package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.Order;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.users.CostumerType;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.Review;
import ir.ac.kntu.model.utils.ScannerWrapper;

import java.util.ArrayList;

public class EditCostumersMenu extends Menu {

    private Costumer costumer;

    public EditCostumersMenu() {
        super("EditCostumersMenu.txt");
    }

    public boolean execute(Agency agency) {
        showCostumers(agency);
        costumer = chooseCostumer(agency.getCostumers());
        do {
            showMenu();
        } while (inputProcessor(agency));
        return false;
    }

    public void showCostumers(Agency agency) {
        char i = 'a';
        for (Costumer c : agency.getCostumers()) {
            System.out.println(i + ". " + c);
            i++;
        }
    }

    public Costumer chooseCostumer(ArrayList<Costumer> costumers) {
        int choice = ScannerWrapper.getInstance().next() - 'a';
        return costumers.get(choice);
    }

    public void editUsername(Agency agency) {
        System.out.println("enter new username : ");
        String username = ScannerWrapper.getInstance().nextLine();
        if (agency.findCustumer(username) == null) {
            costumer.setUsername(username);
            System.out.println("username changed");
        } else {
            System.out.println("this username already exists");
        }
    }

    public void editPassword() {
        System.out.println("enter old password : ");
        String oldpass = ScannerWrapper.getInstance().nextLine();
        if (oldpass.equals(costumer.getPassword())) {
            System.out.println("enter new password");
            String newpass = ScannerWrapper.getInstance().nextLine();
            costumer.setPassword(newpass);
        } else {
            System.out.println("wrong password!");
        }
    }

    public Location getLocation() {
        System.out.println("enter location longtitude : ");
        double longtitude = ScannerWrapper.getInstance().nextDouble();
        System.out.println("enter location latitutde : ");
        double latitude = ScannerWrapper.getInstance().nextDouble();
        System.out.println("enter address : ");
        String address = ScannerWrapper.getInstance().nextLine();
        Location location = new Location(latitude, longtitude, address);
        return location;
    }

    public void editLocation() {
        System.out.println("new location: ");
        Location location = getLocation();
        costumer.setLocation(location);
    }

    public void editPhoneNumber() {
        System.out.println("enter new phone number : ");
        String phoneNumeber = ScannerWrapper.getInstance().nextLine();
        costumer.setPhoneNumber(phoneNumeber);
    }

    public void editCostumerType() {
        char i = 'a';
        for (CostumerType ct : CostumerType.values()) {
            System.out.println(i + ". " + ct.name().toLowerCase());
            i++;
        }
        char choice = ScannerWrapper.getInstance().next();
        costumer.setCostumerType(CostumerType.values()[choice - 'a']);
    }

    public Review chooseReview() {
        char i = 'a';
        for (Review r : costumer.getReviewHistory()) {
            System.out.println(i + ". " + r);
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        return costumer.getReviewHistory().get(choice);
    }

    public void editReview(Review review) {
        System.out.println("new comment : ");
        String comment = ScannerWrapper.getInstance().nextLine();
        review.setComment(comment);
        System.out.println("new rate : ");
        double rate = ScannerWrapper.getInstance().nextDouble();
        review.setRate(rate);
    }

    public void editReviewHistory() {

        Review review = chooseReview();
        System.out.println(" a. Edit   b. remove ");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                editReview(review);
                return;
            case "b":
                costumer.getReviewHistory().remove(review);
                return;
            default:
        }

    }

    public void editPurchaseHistory(){
        char i ='a';
        for(Order o : costumer.getPurchaseHistory()){
            System.out.println(i+". "+o);
            i++;
        }
        System.out.println(i+". Exit");
        System.out.println("delete : ");
        int choice = ScannerWrapper.getInstance().next()-'a';
        if(choice < costumer.getPurchaseHistory().size()){
            costumer.getPurchaseHistory().remove(choice);
        }
    }

    @Override
    public boolean inputProcessor(Agency agency) {

        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                editUsername(agency);
                return true;
            case "b":
                editPassword();
                return true;
            case "c":
                editLocation();
                return true;
            case "d":
                editPhoneNumber();
                return true;
            case "e":
                editCostumerType();
                return true;
            case "f":
                editReviewHistory();
                return true;
            case "g":
                editPurchaseHistory();
                return true;
            case "h":
                return false;
            default:
                return false;//TODO make all defaults return true
        }
    }
}
