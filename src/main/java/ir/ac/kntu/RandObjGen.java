package ir.ac.kntu;

import ir.ac.kntu.delivery.*;
import ir.ac.kntu.services.*;
import ir.ac.kntu.time.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;

import java.util.ArrayList;

public class RandObjGen {


    private final Random rand;
    private final String[] restaurentNames = {"alborz", "orkide", "lak lak", "mahan", "pars", "shandiz", "hani", "asil", "narenjestan", "morshed"};
    private final String[] foodNames = {"my own fucking flesh"};//todo write some names


    RandObjGen() {
        this.rand = new Random();
    }

    /**
     * @return a random Delivery object
     */
    public Delivery deliveryGen() {
        VehicleType vehicleType = VehicleType.values()[rand.nextInt(VehicleType.values().length)];
        WageType wageType = WageType.values()[rand.nextInt(WageType.values().length)];
        ArrayList<Restaurant> restaurants = new ArrayList<>();//todo make sure it meets with the restaurant schedule
        Schedule schedule = scheduleGen();
        return new Delivery(vehicleType, wageType, restaurants, schedule);
    }

    /**
     * @return a random Shift object
     */
    public Shift shiftGen() {
        int hour1 = rand.nextInt(24);
        int minute1 = rand.nextInt(60);
        int deltaHour = rand.nextInt(2);
        int deltaMinute = rand.nextInt(59) + 1;
        int hour2 = Math.min(hour1 + deltaHour, 23);
        int minute2 = Math.min(minute1 + deltaMinute, 59);
        LocalTime start = LocalTime.of(hour1, minute1);
        LocalTime end = LocalTime.of(hour2, minute2);
        return new Shift(start, end);
    }

    /**
     * @return a random Schedule object
     */
    public Schedule scheduleGen() {
        int daysInWeek = rand.nextInt(7) + 1;
        int numberOfshifts;
        DayOfWeek dayOfTheWeek;
        ArrayList<WorkDay> workDays = new ArrayList<>();
        for (int i = 0; i < daysInWeek; i++) {
            dayOfTheWeek = DayOfWeek.values()[rand.nextInt(DayOfWeek.values().length)];
            numberOfshifts = rand.nextInt(2) + 1;
            ArrayList<Shift> shifts = new ArrayList<>();
            for (int s = 0; s < numberOfshifts; s++) {
                Shift shift = shiftGen();
                shifts.add(shift);
            }
            WorkDay workDay = new WorkDay(dayOfTheWeek, shifts);
            workDays.add(workDay);
        }
        return new Schedule(workDays);
    }

    public String stringGen(int n) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public Restaurant restaurentGen(String name) {
        String address = stringGen(20);
        RestaurantType restaurantType = RestaurantType.values()[rand.nextInt(RestaurantType.values().length)];
        FoodMenu foodMenu = foodmenuGen();
        ArrayList<Delivery> deliveries = new ArrayList<>();
        Schedule schedule  = scheduleGen();
        return new Restaurant(name,address,restaurantType,foodMenu,deliveries,schedule);
    }

    public FoodMenu foodmenuGen() {
        ArrayList<Food> foods  = new ArrayList<>();
        int numberOfFoods = rand.nextInt();
        for (int i = 0; i < numberOfFoods; i++) {
            foods.add(foodGen(foodNames[i]));
        }
        return new FoodMenu(foods);
    }

    public Food foodGen(String name){
        double price = rand.nextDouble();
        int prepTime = rand.nextInt(49)+10;
        return new Food(name,price,prepTime);
    }

    public Costumer costumerGen() {

    }


    public void generate(Agency agency) {
        for (int i = 0; i < 15; i++) {
            agency.getAllDeliveries().add(deliveryGen());
        }
        for (int i = 0; i < 5; i++) {
            agency.getRestaurants().add(restaurentGen(restaurentNames[i]));
        }
    }


}