package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.utils.ScannerWrapper;


public class EditRestaurant extends Menu {

    private Provider provider;

    public EditRestaurant() {
        super("EditRestaurant.txt");
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

    public void editAddress() {
        System.out.println(provider.getAddress());
        System.out.println("new address : ");
        String address = ScannerWrapper.getInstance().nextLine();
        provider.setAddress(address);
    }

    public void editRestaurantType() {
        System.out.println("current Type : " + provider.getRestaurantType().name());
        char i = 'a';
        for (ServiceType serviceType : ServiceType.values()) {
            System.out.println(i + ". " + serviceType.name());
            i++;
        }
        System.out.println("new provider type : ");
        int choice = ScannerWrapper.getInstance().next() - 'a';
        provider.setRestaurantType(ServiceType.values()[choice]);
    }

    public void showOrders() {
        char i = 'a';
        System.out.println(provider.getOrders().get(0));
        for (Order order : provider.getOrders()) {
            System.out.println(i + ". " + order);
            i++;
        }
    }

    public void addOrder() {
        System.out.println("enter phone number");
        String phonenumber = ScannerWrapper.getInstance().nextLine();
        System.out.println("enter address");
        String address = ScannerWrapper.getInstance().nextLine();
        Costumer costumer = new Costumer(phonenumber, address);
        provider.getFoodMenu().execute(provider, costumer);
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

    public void editOrders() {
        System.out.println("a. Add         b. Remove         c. Edit");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                addOrder();
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
        for (Provider provider : agency.getRestaurants()) {
            System.out.println(i + ". " + provider);
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        System.out.println(agency.getRestaurants().get(choice).hashCode());
        return agency.getRestaurants().get(choice);
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
                editAddress();
                return true;
            case "c":
                editRestaurantType();
                return true;
            case "d":
                editOrders();
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
