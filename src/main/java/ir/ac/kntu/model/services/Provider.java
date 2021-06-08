package ir.ac.kntu.model.services;

import ir.ac.kntu.model.time.*;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.model.utils.FariFoodObject;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.Review;
import ir.ac.kntu.ui.OperatorMenu;

import java.util.ArrayList;

public class Provider extends FariFoodObject {
    private String name;
    private ProductMenu productMenu;
    private ArrayList<Order> orders;
    private ArrayList<Order> deliveredOrders;//todo
    private double rate;
    private Schedule schedule;
    private Location location;
    private ServiceType type;
    private DeliverySchedule deliverySchedule;
    private Operator operator;
    private ProviderType providerType;

    private OperatorMenu operatorMenu;

    public Provider(String name, Location location, ServiceType type, Operator operator) {
        super();
        this.name = name;
        this.location = location;
        this.type = type;
        this.operator = operator;
        operator.setProvider(this);
        orders = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
        rate = 5;
        operatorMenu = new OperatorMenu(this);

    }

    public double calculateRate(){
        double rate = 5;
        if(getReviews().size() > 0){
            for(Review r : getReviews()){
                rate += r.getRate();
            }
            rate/=(getReviews().size()+1);
        }
        setRate(rate);
        return rate;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", serviceType=" + type.name().toLowerCase() +
                ", providerType=" + providerType.name().toLowerCase() +
                ", orders=" + orders.size() +
                ", rate=" + calculateRate() +
                ", schedule=" + schedule +
                '}';
    }

    public boolean isActive() {
        return getSchedule().isTodayWorkDay();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductMenu getProductMenu() {
        return productMenu;
    }

    public void setProductMenu(ProductMenu productMenu) {
        this.productMenu = productMenu;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getDeliveredOrders() {
        return deliveredOrders;
    }

    public void setDeliveredOrders(ArrayList<Order> deliveredOrders) {
        this.deliveredOrders = deliveredOrders;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public DeliverySchedule getDeliverySchedule() {
        return deliverySchedule;
    }

    public void setDeliverySchedule(DeliverySchedule deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public OperatorMenu getOperatorMenu() {
        return operatorMenu;
    }

    public void setOperatorMenu(OperatorMenu operatorMenu) {
        this.operatorMenu = operatorMenu;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public void setProviderType(ProviderType providerType) {
        this.providerType = providerType;
    }
}


