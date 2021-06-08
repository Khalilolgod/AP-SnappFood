package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.ScannerWrapper;


public class EditProvider extends Menu {

    private Provider provider;

    public EditProvider() {
        super("EditProvider.txt");
    }

    public boolean execute(Agency agency) {
        this.provider = selectRestaurant(agency);
        showMenu();
        return inputProcessor(agency);
    }

    public void editName() {
        System.out.println(provider.getName());
        System.out.println("new name : ");
        String name = ScannerWrapper.getInstance().nextLine();
        provider.setName(name);
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
        System.out.println("current location : " + provider.getLocation());
        System.out.println("new location: ");
        Location location = getLocation();
        provider.setLocation(location);
    }

    public void editProviderType() {
        System.out.println("current Type : " + provider.getType().name());
        char i = 'a';
        for (ServiceType serviceType : ServiceType.values()) {
            System.out.println(i + ". " + serviceType.name());
            i++;
        }
        System.out.println("new provider type : ");
        int choice = ScannerWrapper.getInstance().next() - 'a';
        provider.setType(ServiceType.values()[choice]);
    }

    public void showOrders() {
        char i = 'a';
        System.out.println(provider.getOrders().get(0));
        for (Order order : provider.getOrders()) {
            System.out.println(i + ". " + order);
            i++;
        }
    }

    public void addOrder(Agency agency) {
        System.out.println("enter Costumer UserName");
        String userName = ScannerWrapper.getInstance().nextLine();
        Costumer costumer = agency.findCustumer(userName);
        provider.getProductMenu().execute(provider, costumer);
    }

    public void removeOrder() {
        showOrders();
        int choice = ScannerWrapper.getInstance().next() - 'a';
        if (choice < provider.getOrders().size()) {
            provider.getOrders().remove(choice);
        }
    }

    public void editOrder(Provider provider) {
        showOrders();
        int choice = ScannerWrapper.getInstance().next() - 'a';
        if (choice < provider.getOrders().size()) {
            provider.getOrders().get(choice).getEditOrder().execute(provider);
        }
    }

    public void editOrders(Agency agency) {
        System.out.println("a. Add         b. Remove         c. Edit");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                addOrder(agency);
                break;
            case "b":
                removeOrder();
                break;
            case "c":
                editOrder(provider);
                break;
            default:
                break;
        }

    }

    Provider selectRestaurant(Agency agency) {
        char i = 'a';
        for (Provider provider : agency.getProviders()) {
            System.out.println(i + ". " + provider);
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        System.out.println(agency.getProviders().get(choice).hashCode());
        return agency.getProviders().get(choice);
    }

    public void editRate() {
        System.out.println("current rate : " + provider.getRate());
        System.out.println("new rate : ");
        double rate = ScannerWrapper.getInstance().nextDouble();
        provider.setRate(rate);
    }


    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                editName();
                return true;
            case "b":
                editLocation();
                return true;
            case "c":
                editProviderType();
                return true;
            case "d":
                editOrders(agency);
                return true;
            case "e":
                return true;
            case "f":
                return true;
            case "g":
                return true;
            case "h":
                editRate();
                return true;
            case "i":
                return false;
            default:
                return false;
        }
    }
}
