package ir.ac.kntu.model.agency;

import ir.ac.kntu.model.deliverySystem.DeliverySystem;
import ir.ac.kntu.model.users.Admin;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.ui.*;

import java.util.ArrayList;


public class Agency {

    private Admin admin;
    private ArrayList<Provider> providers;
    //private ArrayList<Deliverer> allDeliveries;
    private DeliverySystem deliverySystem;
    private ArrayList<Costumer> costumers;

    private ArrayList<Order> pendingOrders;

    private ChooseProviderMenu chooseProviderMenu;
    private DeliverySystemMenu deliverySystemMenu;
    private EditCostumersMenu editCostumersMenu;
    private MainMenu mainMenu;
    private ProviderMenu providerMenu;


    public Agency() {
        this.setAdmin(new Admin("admin", "1234"));
        this.providers = new ArrayList<>();
        this.chooseProviderMenu = new ChooseProviderMenu();
        this.deliverySystemMenu = new DeliverySystemMenu();
        this.providerMenu = new ProviderMenu();
        this.deliverySystem = new DeliverySystem();
        this.pendingOrders = new ArrayList<>();
        this.mainMenu = new MainMenu();
        this.editCostumersMenu = new EditCostumersMenu();
    }

    public Costumer findCustumer(String username){
        for(Costumer c : costumers){
            if(c.getUsername().equals(username)){
                return c;
            }
        }
        return null;
    }

    public Operator findOperator(String username){
        for(Provider p : getProviders()){
            if(p.getOperator().getUsername().equals(username)){
                return p.getOperator();
            }
        }
        return null;
    }


    public void start() {
        getMainMenu().execute(this);
    }


    public ArrayList<Provider> activeProviders() {
        ArrayList<Provider> activeOnes = new ArrayList<>();
        for (Provider r : getProviders()) {
            if (r.isActive()) {
                activeOnes.add(r);
            }
        }
        return activeOnes;
    }


    public ArrayList<Provider> getProviders() {
        return providers;
    }

    public void setProviders(ArrayList<Provider> providers) {
        this.providers = providers;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ChooseProviderMenu getChooseProviderMenu() {
        return chooseProviderMenu;
    }

    public void setChooseProviderMenu(ChooseProviderMenu chooseProviderMenu) {
        this.chooseProviderMenu = chooseProviderMenu;
    }

    public DeliverySystemMenu getDeliverySystemMenu() {
        return deliverySystemMenu;
    }

    public void setDeliverySystemMenu(DeliverySystemMenu deliverySystemMenu) {
        this.deliverySystemMenu = deliverySystemMenu;
    }

    public ProviderMenu getProviderMenu() {
        return providerMenu;
    }

    public void setProviderMenu(ProviderMenu providerMenu) {
        this.providerMenu = providerMenu;
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;
    }

    public ArrayList<Order> getPendingOrders() {
        return pendingOrders;
    }

    public void setPendingOrders(ArrayList<Order> pendingOrders) {
        this.pendingOrders = pendingOrders;
    }

    public DeliverySystem getDeliverySystem() {
        return deliverySystem;
    }

    public void setDeliverySystem(DeliverySystem deliverySystem) {
        this.deliverySystem = deliverySystem;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public EditCostumersMenu getEditCostumersMenu() {
        return editCostumersMenu;
    }

    public void setEditCostumersMenu(EditCostumersMenu editCostumersMenu) {
        this.editCostumersMenu = editCostumersMenu;
    }
}
