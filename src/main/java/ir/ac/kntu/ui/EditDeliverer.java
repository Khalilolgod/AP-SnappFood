package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.deliverySystem.*;
import ir.ac.kntu.model.services.Order;
import ir.ac.kntu.model.services.Provider;
import ir.ac.kntu.model.time.WorkDay;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.ScannerWrapper;

import java.util.ArrayList;

public class EditDeliverer extends Menu {

    private Deliverer deliverer;

    public EditDeliverer() {
        super("EditDeliverer.txt");
    }

    public boolean execute(Agency agency, Deliverer deliverer) {
        do {
            showMenu();
            this.deliverer = deliverer;
        } while (inputProcessor(agency));
        return false;
    }

    public void editVehicleType() {
        System.out.println("current vehicle type " + deliverer.getVehicleType().name());
        char i = 'a';
        for (VehicleType vehicleType : VehicleType.values()) {
            System.out.println(i + ". " + vehicleType.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        deliverer.setVehicleType(VehicleType.values()[choice]);
        System.out.println("current vehicle type " + deliverer.getVehicleType().name());
    }

    public void editWageType() {
        System.out.println("current wage type " + deliverer.getWageType().name());
        char i = 'a';
        for (WageType wageType : WageType.values()) {
            System.out.println(i + ". " + wageType.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        deliverer.setWageType(WageType.values()[choice]);
        System.out.println("current wage type " + deliverer.getWageType().name());
    }

    public void editPaycheck() {
        System.out.println("current paycheck  " + deliverer.getPaycheck());
        System.out.println("new paycheck : ");
        double newpaycheck = Double.parseDouble(ScannerWrapper.getInstance().nextLine());
        deliverer.setPaycheck(newpaycheck);
        System.out.println("current paycheck  " + deliverer.getPaycheck());
    }

    /*
    public void showProviders(ArrayList<Provider> providers) {
        char i = 'a';
        for (Provider r : providers) {
            System.out.println(i + ". " + r);
            i++;
        }
    }*/

    /*
    public void editRestaurant(Agency agency) {
        showProviders(deliverer.getRestaurants());
        System.out.println("a. Add            b. Remove");
        String input = ScannerWrapper.getInstance().nextLine();
        switch (input) {
            case "a":
                showProviders(agency.getRestaurants());
                int choice1 = ScannerWrapper.getInstance().next() - 'a';
                agency.getRestaurants().get(choice1).addDelivery(deliverer);
                break;
            case "b":
                showProviders(deliverer.getRestaurants());
                int choice2 = ScannerWrapper.getInstance().next() - 'a';
                deliverer.getRestaurants().get(choice2).getDeliveries().remove(deliverer);
                deliverer.getRestaurants().remove(choice2);
                break;
            default:
                break;
        }

    }

     */

    /*
    public void showSchedule() {
        char i = 'a';
        //todo fix what ever the shit this is
        for (WorkDay workDay : deliverer.getSchedule().getWorkDays()) {
            System.out.println(i+". "+workDay);
            i++;
        }
    }
    */

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

    public void showOrders() {
        char i = 'i';
        for (Order o : deliverer.getOrderHistory()) {
            System.out.println(i + ". " + o);
        }
    }

    public void editLocation() {
        System.out.println("current location : " + deliverer.getLocation());
        System.out.println("new location: ");
        Location location = getLocation();
        deliverer.setLocation(location);
    }

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
                showOrders();
                break;
            case "f":
                editLocation();
                break;
            case "g":
                return false;
            default:
                return false;
        }
        return true;
    }
}
