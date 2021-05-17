package ir.ac.kntu.ui;

import ir.ac.kntu.Agency;
import ir.ac.kntu.services.Restaurant;
import ir.ac.kntu.ui.Menu;
import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.delivery.*;
import ir.ac.kntu.time.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

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
        System.out.println("restaurants to work for : ");
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

    public LocalTime makeTime(){
        System.out.println("enter hour (0-23) : ");
        int hour = ScannerWrapper.getInstance().nextInt();
        System.out.println("enter minute (0-59) : ");
        int minute = ScannerWrapper.getInstance().nextInt();
        LocalTime time =  LocalTime.of(hour,minute);
        return time;
    }

    public Schedule getSchedule(){
        System.out.println("Number of workdays in a week : ");
        int daysInWeek = ScannerWrapper.getInstance().next() - '0';
        int numberOfshifts;
        int dayOfTheWeek;
        ArrayList <WorkDay> workDays = new ArrayList<>();
        for (int i = 0 ; i<daysInWeek ; i++){
            for (int d = 0 ; d< DayOfWeek.values().length ; d++){
                System.out.println((char)(d+'a')+". "+DayOfWeek.values()[d].name());
            }
            dayOfTheWeek = ScannerWrapper.getInstance().next()-'a';
            System.out.println("number of shifts : ");
            numberOfshifts = ScannerWrapper.getInstance().next()-'0';
            ArrayList <Shift> shifts = new ArrayList<>();
            for(int s  = 0 ; s < numberOfshifts ; s++){
                System.out.println("start time");
                LocalTime start = makeTime();
                System.out.println("end time");
                LocalTime end = makeTime();
                Shift shift = new Shift(start,end);
                shifts.add(shift);

            }
            WorkDay workDay = new WorkDay(DayOfWeek.values()[dayOfTheWeek],shifts);
            workDays.add(workDay);
        }
        return new Schedule(workDays);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        VehicleType vehicleType = getVehicleType();
        WageType wageType = getWageType();
        ArrayList <Restaurant> restaurants = getRestaurants(agency);
        Schedule schedule = getSchedule();
        Delivery delivery = new Delivery(vehicleType,wageType,restaurants,schedule);
        agency.getAllDeliveries().add(delivery);
        return false;
    }
}
