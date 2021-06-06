package ir.ac.kntu.model.deliverySystem;

import java.util.ArrayList;
import ir.ac.kntu.model.time.*;
import ir.ac.kntu.model.services.*;
import ir.ac.kntu.model.utils.Location;


public class Deliverer {

    private VehicleType vehicleType;
    private WageType wageType;
    private double paycheck;
    private Order activeOrder;
    private ArrayList <Order>   orderHistory;
    private Location location;


    public Deliverer(VehicleType vehicleType, WageType wageType, Location location) {
        this.vehicleType = vehicleType;
        this.wageType = wageType;
        this.location = location;
        this.paycheck = 0.0;
        activeOrder = null;
        orderHistory = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Deliverer{" +
                ", vehicleType=" + vehicleType.name().toLowerCase() +
                ", wageType=" + wageType.name().toLowerCase() +
                '}';
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public WageType getWageType() {
        return wageType;
    }

    public void setWageType(WageType wageType) {
        this.wageType = wageType;
    }

    public double getPaycheck() {
        return paycheck;
    }

    public void setPaycheck(double paycheck) {
        this.paycheck = paycheck;
    }

    public Order getActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(Order activeOrder) {
        this.activeOrder = activeOrder;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
