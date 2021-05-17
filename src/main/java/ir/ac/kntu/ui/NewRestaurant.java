package ir.ac.kntu.ui;

import ir.ac.kntu.Agency;
import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.services.Food;
import ir.ac.kntu.services.FoodMenu;
import ir.ac.kntu.services.Restaurant;
import ir.ac.kntu.services.RestaurantType;
import ir.ac.kntu.time.Schedule;
import ir.ac.kntu.time.Shift;
import ir.ac.kntu.time.WorkDay;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class NewRestaurant extends Menu {


    public NewRestaurant() {
        super("RestaurantsMenu.txt");
    }

    public boolean execute(Agency agency) {
        showRestaurants(agency);
        return inputProcessor(agency);
    }

    public void showRestaurants(Agency agency) {
        char i = 'a';
        for (Restaurant r : agency.getRestaurants()) {
            System.out.println(i + ". " + r);
            i++;
        }
    }

    public String getRestaurantName() {
        System.out.println("Restaurant name : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getRestaurantAddress() {
        System.out.println("Restaurant address : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public RestaurantType getRestaurantType() {
        char i = 'a';
        for (RestaurantType restaurantType : RestaurantType.values()) {
            System.out.println(i + ". " + restaurantType.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        return RestaurantType.values()[choice];
    }

    public FoodMenu getFoodMenu() {

        ArrayList<Food> foods = new ArrayList<>();
        int choice;
        System.out.println("food menu: ");
        while (true) {
            System.out.println("a. Add Food       b. Done");
            choice = ScannerWrapper.getInstance().next();
            if (choice == 'a') {
                System.out.println("food name : ");
                String name = ScannerWrapper.getInstance().nextLine();
                System.out.println("Price : ");
                double price = Double.parseDouble(ScannerWrapper.getInstance().nextLine());
                System.out.println("preptime : ");
                int preptime = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
                Food food = new Food(name, price, preptime);
                foods.add(food);
            } else {
                break;
            }
        }
        return new FoodMenu(foods);
    }

    public ArrayList<Delivery> getDeliveries(Agency agency) {
        ArrayList<Delivery> deliveries = new ArrayList<>();
        char i = 'a';
        for (Delivery delivery : agency.getAllDeliveries()) {
            System.out.println(i + ". " + delivery);
            i++;
        }
        System.out.println(i + ". Done");
        while (true) {
            System.out.println("delivery : ");
            int choice = ScannerWrapper.getInstance().next() - 'a';
            if (choice < agency.getAllDeliveries().size()) {
                deliveries.add(agency.getAllDeliveries().get(choice));
                /*todo when adding a delivery to a restaurant the delivery should
                 1. have less than 2 restaurants
                 2. add the restaurant to the delivery.restaurants "issue : we dont have the restaurant beforehand"
                 SOLUTION : have a checker to only show availble deliveries
                            make a Restaurant constructor
                 agency.getAllDeliveries().get(choice).getRestaurants().add(restaurant);
                */
            } else {
                break;
            }
        }
        return deliveries;
    }

    public LocalTime makeTime() {
        System.out.println("enter hour (0-23) : ");
        int hour = ScannerWrapper.getInstance().nextInt();
        System.out.println("enter minute (0-59) : ");
        int minute = ScannerWrapper.getInstance().nextInt();
        LocalTime time = LocalTime.of(hour, minute);
        return time;
    }

    public Schedule getSchedule() {
        //change it so (a.add b.done)
        System.out.println("Number of workdays in a week : ");
        int daysInWeek = ScannerWrapper.getInstance().next() - '0';
        int numberOfshifts;
        int dayOfTheWeek;
        ArrayList<WorkDay> workDays = new ArrayList<>();
        for (int i = 0; i < daysInWeek; i++) {
            for (int d = 0; d < DayOfWeek.values().length; d++) {
                System.out.println((char) (d + 'a') + ". " + DayOfWeek.values()[d].name());
            }
            dayOfTheWeek = ScannerWrapper.getInstance().next() - 'a';
            System.out.println("number of shifts : ");
            numberOfshifts = ScannerWrapper.getInstance().next() - '0';
            ArrayList<Shift> shifts = new ArrayList<>();
            for (int s = 0; s < numberOfshifts; s++) {
                System.out.println("start time");
                LocalTime start = makeTime();
                System.out.println("end time");
                LocalTime end = makeTime();
                Shift shift = new Shift(start, end);
                shifts.add(shift);

            }
            WorkDay workDay = new WorkDay(DayOfWeek.values()[dayOfTheWeek], shifts);
            workDays.add(workDay);
        }
        return new Schedule(workDays);
    }

    public void newRestaurant(Agency agency) {
        String name = getRestaurantName();
        String address = getRestaurantAddress();
        RestaurantType restaurantType = getRestaurantType();
        FoodMenu foodMenu = getFoodMenu();
        ArrayList<Delivery> deliveries = getDeliveries(agency);
        Schedule schedule = getSchedule();
        Restaurant restaurant = new Restaurant(name, address, restaurantType, foodMenu, deliveries, schedule);
        agency.getRestaurants().add(restaurant);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        newRestaurant(agency);
        return false;
    }
}
