package ir.ac.kntu.model.services;

import ir.ac.kntu.model.time.*;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.model.utils.FariFoodObject;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.Review;

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

    public Provider(String name, ProductMenu productMenu, Schedule schedule, Location location, ServiceType type, Operator operator) {
        this.name = name;
        this.productMenu = productMenu;
        this.schedule = schedule;
        this.location = location;
        this.type = type;
        this.operator = operator;
        orders = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
        rate = 5;
    }

    public Provider(String name, Schedule schedule, Location location, ServiceType type, Operator operator) {
        this.name = name;
        this.schedule = schedule;
        this.location = location;
        this.type = type;
        this.operator = operator;
        orders = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
        rate = 5;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", serviceType=" + type.name() +
                ", orders=" + orders.size() +
                ", rate=" + rate +
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
}


