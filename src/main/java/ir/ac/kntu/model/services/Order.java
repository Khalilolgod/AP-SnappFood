package ir.ac.kntu.model.services;

import ir.ac.kntu.model.deliverySystem.Deliverer;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.ui.*;

import java.util.HashMap;

public class Order {
    private String id;
    private OrderStatus orderStatus;
    private int prepTime;
    private double finalPrice;
    private HashMap<Product, Integer> foods;
    private Costumer costumer;
    private Deliverer deliverer;

    private EditOrder editOrder;

    public Order(Costumer costumer) {
        this.costumer = costumer;
        this.id = getAlphaNumericString(10);
        setOrderStatus(OrderStatus.PROCESSING);
        setFinalPrice(0.0);
        setPrepTime(0);
        setFoods(new HashMap<>());
        this.editOrder = new EditOrder(this);
    }

    @Override
    public String toString() {
        String output =  "Order{" +
                "orderStatus=" + orderStatus +
                ", prepTime=" + prepTime +
                ", finalPrice=" + finalPrice +
                "}\n";
        for (Object food : foods.keySet().toArray()) {
            output+= food.toString() + "\n";
        }
        return output;
    }

    /**
     * if product doesn't exists it will add it to the hashMap
     * if it does exist , it will +1 the count of that product in the hashMap
     */
    public void addFood(Product product) {
        setOrderStatus(OrderStatus.PROCESSING);
        setPrepTime(getPrepTime() + product.getPrepTime());
        setFinalPrice(getFinalPrice() + product.getPrice());
        if (getFoods().containsKey(product)) {
            getFoods().put(product, getFoods().get(product) + 1);
        } else {
            getFoods().put(product, 1);
        }
    }

    public void removeFood(Product product) {
        if (foods.containsKey(product) && foods.get(product) > 0) {
            foods.put(product, foods.get(product) - 1);
        }
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public HashMap<Product, Integer> getFoods() {
        return foods;
    }

    public void setFoods(HashMap<Product, Integer> foods) {
        this.foods = foods;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Deliverer getDelivery() {
        return deliverer;
    }

    public void setDelivery(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public EditOrder getEditOrder() {
        return editOrder;
    }

    public void setEditOrder(EditOrder editOrder) {
        this.editOrder = editOrder;
    }
}
