package ir.ac.kntu.model.utils;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.deliverySystem.*;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.users.CostumerType;
import ir.ac.kntu.model.users.Operator;

import java.util.HashMap;
import java.util.Random;


public class RandObjGen {


    private final Random rand;
    private final String[] restaurentNames = {"alborz", "orkide", "lak lak", "mahan", "pars", "shandiz", "hani", "asil", "narenjestan", "morshed"};
    private final String[] foodNames = {"pizza", "hamburger", "kabab", "jooje", "ghorme sabzi", "makaroni", "zereshk polo", "lazania"};


    public RandObjGen() {
        this.rand = new Random();
    }

    /**
     * @return a random Deliverer object
     */

    public Deliverer deliveryGen() {
        VehicleType vehicleType = VehicleType.values()[rand.nextInt(VehicleType.values().length)];
        WageType wageType = WageType.values()[rand.nextInt(WageType.values().length)];
        Location location = new Location(rand.nextDouble(), rand.nextDouble(), stringGen(20));
        return new Deliverer(vehicleType, wageType, location);
    }


    /**
     * @return a random Shift object
     */
   /* public Shift shiftGen() {

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
    */

    /**
     * @return a random Schedule object
     */
    /*public Schedule scheduleGen() {
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
    }*/
    public String getAlphaNumericString(int n) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * @param n length of the generated string
     * @return a random alphabetic string
     */
    public String stringGen(int n) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /*
    public void assignRandomDeliveris(Agency agency, Provider provider) {
        int numberOfDeliveries = rand.nextInt(2) + 1;
        for (int i = 0; i < numberOfDeliveries; i++) {
            provider.addDelivery(agency.getAddableDeliveries().get(i));
            //not safe change this later
        }
    }
*/
    public Location locationGen() {
        double lat = rand.nextInt(300);
        double lon = rand.nextInt(300);
        String address = stringGen(20);
        return new Location(lat, lon, address);
    }

    public Operator operatorGen() {
        return new Operator(stringGen(6), getAlphaNumericString(4));
    }

    public Restaurant restaurantGen(Agency agency) {
        String name = stringGen(10);
        Location location = locationGen();
        ServiceType serviceType = ServiceType.values()[rand.nextInt(ServiceType.values().length)];
        Operator operator = operatorGen();
        Restaurant restaurant = new Restaurant(name, location, serviceType, operator);
        ProductMenu productMenu = productMenuGen(restaurant);
        restaurant.setProductMenu(productMenu);
        return restaurant;
    }

    public TareBar tareBargen(Agency agency) {
        String name = stringGen(10);
        Location location = locationGen();
        ServiceType serviceType = ServiceType.values()[rand.nextInt(ServiceType.values().length)];
        Operator operator = operatorGen();
        TareBar tareBar = new TareBar(name, location, serviceType, operator);
        ProductMenu productMenu = productMenuGen(tareBar);
        tareBar.setProductMenu(productMenu);
        return tareBar;
    }

    public SuperMarket superMarketgen(Agency agency) {
        String name = stringGen(10);
        Location location = locationGen();
        ServiceType serviceType = ServiceType.values()[rand.nextInt(ServiceType.values().length)];
        Operator operator = operatorGen();
        SuperMarket superMarket = new SuperMarket(name, location, serviceType, operator);
        ProductMenu productMenu = productMenuGen(superMarket);
        superMarket.setProductMenu(productMenu);
        return superMarket;
    }

    public ProductMenu productMenuGen(Provider provider) {
        HashMap<Product, Integer> products = new HashMap<>();
        int numberOfFoods = rand.nextInt(foodNames.length) + 1;
        for (int i = 0; i < numberOfFoods; i++) {
            products.put(productGen(foodNames[i], provider), rand.nextInt(5) + 1);
        }
        return new ProductMenu(products);
    }

    //todo make food , vegetable , ... names and enums

    public Product productGen(String name, Provider provider) {
        double price = rand.nextDouble() * 100;
        int prepTime = rand.nextInt(120) + 10;
        return new Product(name, price, prepTime, provider);
    }

    public Costumer costumerGen() {
        return new Costumer(stringGen(6), getAlphaNumericString(4),
                CostumerType.values()[rand.nextInt(CostumerType.values().length)], locationGen(), stringGen(11));
    }

    public void generate(Agency agency) {
        /*
        for (int i = 0; i < 15; i++) {
            agency.getAllDeliveries().add(deliveryGen());
        }
        */

        for (int i = 0; i < 4; i++) {
            agency.getProviders().add(restaurantGen(agency));
            agency.getProviders().add(tareBargen(agency));
            agency.getProviders().add(superMarketgen(agency));
        }

        for (int i = 0; i < 10; i++) {
            agency.getCostumers().add(costumerGen());
        }

    }


}
