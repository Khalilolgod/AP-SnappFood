package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.Provider;
import ir.ac.kntu.model.users.CostumerType;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.users.Costumer;

public class AdminMenu extends Menu {

    public AdminMenu(){
        super("AdminMenu.txt");
    }

    public void execute(Agency agency){
        while (true) {
            showMenu();
            if(!inputProcessor(agency)){
                break;
            }
        }
    }

    public String getUsername(Agency agency) {
        System.out.println("enter new username : ");
        String username = ScannerWrapper.getInstance().nextLine();
        if (agency.findCustumer(username) == null) {
            return username;
        } else {
            System.out.println("this username already exists");
            return getUsername(agency);
        }
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

    public String getPhoneNumber() {
        System.out.println("enter new phone number : ");
        String phoneNumeber = ScannerWrapper.getInstance().nextLine();
        return phoneNumeber;
    }

    public CostumerType getCostumerType() {
        char i = 'a';
        for (CostumerType ct : CostumerType.values()) {
            System.out.println(i + ". " + ct.name().toLowerCase());
            i++;
        }
        char choice = ScannerWrapper.getInstance().next();
        return CostumerType.values()[choice - 'a'];
    }

    public Costumer getCostumer(Agency agency){
        String username = getUsername(agency);
        System.out.println("enter password : ");
        String password = ScannerWrapper.getInstance().nextLine();
        Location location = getLocation();
        String phoneNumber = getPhoneNumber();
        CostumerType costumerType = getCostumerType();
        return  new Costumer(username,password,costumerType,location,phoneNumber);

    }

    public Operator chooseOperator(Agency agency){
        char i ='a';
        for(Provider p : agency.getProviders()){
            System.out.println(i+". "+p.getOperator());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next()-'a';
        return agency.getProviders().get(choice).getOperator();
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":
                System.out.println("enter Costumer UserName");
                String userName = ScannerWrapper.getInstance().nextLine();
                Costumer costumer = agency.findCustumer(userName);
                agency.getChooseProviderMenu().execute(agency,costumer);
                return true;
            case "b":
                agency.getDeliverySystemMenu().execute(agency);
                return true;
            case "c":
                agency.getProviderMenu().execute(agency);
                return true;
            case "d":
                //todo sperate newing and editing
                System.out.println("a. New     b. Edit");
                String choise  = ScannerWrapper.getInstance().nextLine();
                if(choise.equals("b")) {
                    agency.getEditCostumersMenu().execute(agency);
                }else if(choise.equals("a")){
                    agency.getCostumers().add(getCostumer(agency));
                }
                return true;
            case "e":
                //agency.getOperatorsMenu().execute(agency);
                return true;
            case "f":
                //seting menu
                return true;
            case "g":
                System.out.println("aight then imma exit");
                return false;
            default:
                System.out.println("Bad input");
                return true;
        }
    }
}
