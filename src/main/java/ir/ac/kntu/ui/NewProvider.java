package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.time.Schedule;
import ir.ac.kntu.model.time.Shift;
import ir.ac.kntu.model.time.WorkDay;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NewProvider extends Menu {


    public NewProvider() {
        super("ProvidersMenu.txt");
    }

    public boolean execute(Agency agency) {
        showRestaurants(agency);
        return inputProcessor(agency);
    }

    public void showRestaurants(Agency agency) {
        char i = 'a';
        for (Provider r : agency.getProviders()) {
            System.out.println(i + ". " + r);
            i++;
        }
    }

    public String getRestaurantName() {
        System.out.println("Provider name : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public String getRestaurantAddress() {
        System.out.println("Provider address : ");
        return ScannerWrapper.getInstance().nextLine();
    }

    public ServiceType getRestaurantType() {
        char i = 'a';
        for (ServiceType serviceType : ServiceType.values()) {
            System.out.println(i + ". " + serviceType.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        return ServiceType.values()[choice];
    }

    public ProductMenu getProductMenu(Provider provider) {

        HashMap<Product, Integer> products = new HashMap<>();
        int choice;
        System.out.println("product menu: ");
        while (true) {
            System.out.println("a. Add Product       b. Done");
            choice = ScannerWrapper.getInstance().next();
            if (choice == 'a') {
                System.out.println("product name : ");
                String name = ScannerWrapper.getInstance().nextLine();
                System.out.println("Price : ");
                double price = Double.parseDouble(ScannerWrapper.getInstance().nextLine());
                System.out.println("preptime : ");
                int preptime = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
                Product product = new Product(name, price, preptime, provider);
                products.put(product, 10);
            } else {
                break;
            }
        }
        return new ProductMenu(products);
    }

    /*
    public ArrayList<Deliverer> getDeliveries(Agency agency, Provider provider) {
        ArrayList<Deliverer> deliveries = new ArrayList<>();
        ArrayList<Deliverer> validDeliveries =  agency.getAddableDeliveries();
        char i = 'a';
        for (Deliverer deliverer : validDeliveries) {
            System.out.println(i + ". " + deliverer);
            i++;
        }
        System.out.println(i + ". Done");
        while (true) {
            System.out.println("delivery : ");
            int choice = ScannerWrapper.getInstance().next() - 'a';
            if (choice <  validDeliveries.size()) {
                deliveries.add( validDeliveries.get(choice));
                validDeliveries.get(choice).addRestaurant(provider);
            } else {
                break;
            }
        }
        return deliveries;
    }
*/
    public LocalTime makeTime() {
        System.out.println("enter hour (0-23) : ");
        int hour = ScannerWrapper.getInstance().nextInt();
        System.out.println("enter minute (0-59) : ");
        int minute = ScannerWrapper.getInstance().nextInt();
        return LocalTime.of(hour, minute);
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

    public Location getLocation() {
        System.out.println("enter location longtitude : ");
        double longtitude = ScannerWrapper.getInstance().nextDouble();
        System.out.println("enter location latitutde : ");
        double latitude = ScannerWrapper.getInstance().nextDouble();
        System.out.println("enter address : ");
        String address = ScannerWrapper.getInstance().nextLine();
        return new Location(latitude, longtitude, address);
    }

    public ProviderType getProviderType(){
        char i = 'a';
        for(ProviderType pt : ProviderType.values()){
            System.out.println(i+". "+pt.name().toLowerCase());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next()-'a';
        return ProviderType.values()[choice];
    }

    public Operator getOperator(Agency agency) {
        System.out.println("enter Operator username : ");
        String username = ScannerWrapper.getInstance().nextLine();
        System.out.println("enter Operator password : ");
        String password = ScannerWrapper.getInstance().nextLine();
        return new Operator(username, password);
    }

    public void newProvider(Agency agency) {
        String name = getRestaurantName();
        ProviderType providerType = getProviderType();
        Location location = getLocation();
        ServiceType serviceType = getRestaurantType();
        Operator operator = getOperator(agency);
        Provider provider;
        switch (providerType){
            case RESTAURANT:
                provider = new Restaurant(name, location, serviceType, operator);
                break;
            case TAREBAR:
                provider = new TareBar(name, location, serviceType, operator);
                break;
            case SUPERMARKET:
                provider = new SuperMarket(name, location, serviceType, operator);
                break;
            default:
                provider = new Provider(name, location, serviceType, operator);
                break;
        }
        ProductMenu productMenu = getProductMenu(provider);
        provider.setProductMenu(productMenu);
        agency.getProviders().add(provider);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        newProvider(agency);
        return false;
    }
}
