package ir.ac.kntu.services;

import ir.ac.kntu.Agency;
import ir.ac.kntu.Menu;
import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.delivery.VehicleType;
import ir.ac.kntu.delivery.WageType;
import ir.ac.kntu.time.Schedule;

import java.util.ArrayList;
import java.util.Locale;

public class NewDelivery extends Menu {

    public boolean execute(Agency agency){
        return inputProcessor(agency);
    }

    public VehicleType getVehicleType(){
        System.out.println("VehicleType ?");
        char i = 'a';
        for (VehicleType vehicleType : VehicleType.values()){
            System.out.printf("%c. %s\t",i,vehicleType.name().toLowerCase());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next()-'a';
        return VehicleType.values()[choice];
    }

    public WageType getWageType(){
        System.out.println("WageType ?");
        char i = 'a';
        for (WageType wageType : WageType.values()){
            System.out.printf("%c. %s\t",i,wageType.name().toLowerCase());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next()-'a';
        return WageType.values()[choice];
    }

    public ArrayList<Restaurant> getRestaurants(Agency agency){

        ArrayList <Restaurant> restaurants = new ArrayList<>();
        ArrayList <Restaurant> allrestaurants = new ArrayList<>(agency.getRestaurants());

        for(int i = 0; i < 2; i++){
            showRestaurants(allrestaurants);
            int choice = ScannerWrapper.getInstance().next()-'a';
            if(choice < allrestaurants.size()){
                restaurants.add(allrestaurants.get(choice));
                allrestaurants.remove(choice);
            }else {
                break;
            }
        }
        return restaurants;
    }

    void showRestaurants(ArrayList <Restaurant> restaurants){
        char i = 'a';
        for (Restaurant restaurant : restaurants){
            System.out.println(i+". "+restaurant);
            i++;
        }
        System.out.println(i+". Done");
    }

    //TODO write schedule input

    //public Delivery(VehicleType vehicleType, WageType wageType, Restaurant restaurant1, Restaurant restaurant2, Schedule schedule)

    @Override
    public boolean inputProcessor(Agency agency) {
        return false;
    }
}
