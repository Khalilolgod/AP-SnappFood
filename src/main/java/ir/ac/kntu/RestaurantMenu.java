package ir.ac.kntu;

import ir.ac.kntu.delivery.*;
import ir.ac.kntu.services.*;
import ir.ac.kntu.time.*;
import java.time.*;
import java.util.ArrayList;


public class RestaurantMenu extends Menu {

    private EditRestaurant editRestaurant;

    public RestaurantMenu(){
        super("RestaurantsMenu.txt");
    }

    public boolean execute(Agency agency){
        showMenu();
        return inputProcessor(agency);
    }

    public void showRestaurants(Agency agency){
        char i = 'a';
        for(Restaurant r : agency.getRestaurants()){
            System.out.println(i+". "+r);
            i++;
        }
    }

    private String name;
    private String address;//could be a class too
    private RestaurantType restaurantType;
    private FoodMenu foodMenu;
    private ArrayList<Delivery> deliveries;

    public String getRestaurantName(){
        System.out.println("Restaurant name : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getRestaurantAddress(){
        System.out.println("Restaurant address : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public RestaurantType getRestaurantType(){
        char i = 'a';
        for(RestaurantType restaurantType :  RestaurantType.values()){
            System.out.println(i + ". " + restaurantType.name());
        }
        int choice = ScannerWrapper.getInstance().next()-'a';
        return RestaurantType.values()[choice];
    }

    public FoodMenu getFoodMenu() {

        ArrayList<Food> foods = new ArrayList<>();
        int choice;
        while(true) {
            System.out.println("a. Add        b. Done");
            choice = ScannerWrapper.getInstance().next();
            if(choice == 'a') {
                System.out.println("name : ");
                String name = ScannerWrapper.getInstance().nextLine();
                System.out.println("Price : ");
                double price = Double.parseDouble(ScannerWrapper.getInstance().nextLine());
                System.out.println("preptime : ");
                int preptime = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
                Food food = new Food(name,price,preptime);
                foods.add(food);
            }else{
                break;
            }
        }
        return new FoodMenu(foods);
    }

    public ArrayList<Delivery> getDeliveries (Agency agency){
        ArrayList<Delivery> deliveries = new ArrayList<>();
        char i = 'a';
        for(Delivery delivery : agency.getAllDeliveries()){
            System.out.println(i+". "+delivery);
            i++;
        }
        System.out.println(i+". Done");
        while(true) {
            int choice = ScannerWrapper.getInstance().next() - 'a';
            if (choice < agency.getAllDeliveries().size()) {
                deliveries.add(agency.getAllDeliveries().get(choice));
            } else {
                break;
            }
        }
        return deliveries;
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
        //change it so (a.add b.done)
        System.out.println("Number of workdays in a week : ");
        int daysInWeek = ScannerWrapper.getInstance().next() - '0';
        int numberOfshifts;
        int dayOfTheWeek;
        ArrayList <WorkDay> workDays = new ArrayList<>();
        for (int i = 0 ; i<daysInWeek ; i++){
            for (int d = 0; d< DayOfWeek.values().length ; d++){
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

    public void newRestaurant(Agency agency){
        String name = getRestaurantName();
        String address = getRestaurantAddress();
        RestaurantType restaurantType = getRestaurantType();
        FoodMenu foodMenu = getFoodMenu();
        ArrayList<Delivery> deliveries = getDeliveries(agency);
        Schedule schedule = getSchedule();
    }

    public void editRestaurant(Agency agency){

    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":
                showRestaurants(agency);
                return true;
            case "b":
                editRestaurant.execute(agency);
                return true;
            case "c":
                newRestaurant(agency);
                return true;
            case "d":
                return false;
            default:
                return false;
        }
    }
}
