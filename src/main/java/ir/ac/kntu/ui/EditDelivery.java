package ir.ac.kntu.ui;

import ir.ac.kntu.*;
import ir.ac.kntu.delivery.*;
import ir.ac.kntu.services.Restaurant;
import ir.ac.kntu.time.WorkDay;
import ir.ac.kntu.ui.Menu;

import java.util.ArrayList;

public class EditDelivery extends Menu {

    private Delivery delivery;

    public EditDelivery() {
        super("EditDelivery.txt");
    }

    public boolean execute(Agency agency, Delivery delivery) {
        showMenu();
        this.delivery = delivery;
        return inputProcessor(agency);
    }

    public void editVehicleType() {
        System.out.println("current vehicle type " + delivery.getVehicleType().name());
        char i = 'a';
        for (VehicleType vehicleType : VehicleType.values()) {
            System.out.println(i + ". " + vehicleType.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        delivery.setVehicleType(VehicleType.values()[choice]);
        System.out.println("current vehicle type " + delivery.getVehicleType().name());
    }

    public void editWageType() {
        System.out.println("current wage type " + delivery.getWageType().name());
        char i = 'a';
        for (WageType wageType : WageType.values()) {
            System.out.println(i + ". " + wageType.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        delivery.setWageType(WageType.values()[choice]);
        System.out.println("current wage type " + delivery.getWageType().name());
    }

    public void editPaycheck() {
        System.out.println("current paycheck  " + delivery.getPaycheck());
        System.out.println("new paycheck : ");
        double newpaycheck = Double.parseDouble(ScannerWrapper.getInstance().nextLine());
        delivery.setPaycheck(newpaycheck);
        System.out.println("current paycheck  " + delivery.getPaycheck());
    }

    public void showRestaurants(ArrayList<Restaurant> restaurants) {
        char i = 'a';
        for (Restaurant r : restaurants) {
            System.out.println(i + ". " + r);
            i++;
        }
    }

    public void editRestaurant(Agency agency) {
        showRestaurants(delivery.getRestaurants());
        System.out.println("a. Add            b. Remove");
        String input = ScannerWrapper.getInstance().nextLine();
        switch (input) {
            case "a":
                showRestaurants(agency.getRestaurants());
                int choice1 = ScannerWrapper.getInstance().next() - 'a';
                agency.getRestaurants().get(choice1).addDelivery(delivery);
                break;
            case "b":
                showRestaurants(delivery.getRestaurants());
                int choice2 = ScannerWrapper.getInstance().next() - 'a';
                delivery.getRestaurants().get(choice2).getDeliveries().remove(delivery);
                delivery.getRestaurants().remove(choice2);
                break;
            default:
                break;
        }

    }

    public void showSchedule() {
        char i = 'a';
        for (WorkDay workDay : delivery.getSchedule().getWorkDays()) {
            System.out.println(i+". "+workDay);
            i++;
        }
    }


/*
    public void editSchedule() {
        //todo make shifts editable
        System.out.println("a. Add workday    b. Remove workday ");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":
                showSchedule();

            case "b":
                showSchedule();
            default:
                break;
        }
        showSchedule();
        System.out.println("todo");

    }
*/
    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                editVehicleType();
                return true;
            case "b":
                editWageType();
                return true;
            case "c":
                editPaycheck();
                return true;
            case "d":
                //todo
                break;
            case "e":
                editRestaurant(agency);
                break;
            case "f":
                //editSchedule();
                break;
            case "g":
                return false;
            default:
                return false;
        }
        return true;
    }
}
