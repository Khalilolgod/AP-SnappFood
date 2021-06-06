package ir.ac.kntu.model.deliverySystem;

import ir.ac.kntu.model.services.Order;
import ir.ac.kntu.model.time.Shift;

import java.time.LocalTime;
import java.util.ArrayList;

public class DeliveryShift extends Shift {

    private ArrayList<Order> orders;
    private int capacity;

    public DeliveryShift(LocalTime start , LocalTime end, int capacity) {
        super(start, end);
        this.capacity = capacity;
        this.orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
