package ir.ac.kntu.services;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private String id;
    private OrderStatus orderStatus;
    private int prepTime;
    private double finalPrice;
    private HashMap<Food , Integer> foods;
    private Costumer costumer;

    public Order(Costumer costumer){
        this.costumer = costumer;
        this.id = getAlphaNumericString(10);
        setOrderStatus(OrderStatus.PROCESSING);
        setFinalPrice(0.0);
        setPrepTime(0);
        setFoods(new HashMap<>());
    }

    /**
     *
     * if food doesn't exists it will add it to the hashMap
     * if it does exist , it will +1 the count of that food in the hashMap
     */
    public void addFood(Food food){
        setOrderStatus(OrderStatus.PROCESSING);
        setPrepTime(getPrepTime() + food.getPrepTime());
        setFinalPrice(getFinalPrice() + food.getPrice());
        if(getFoods().containsKey(food))
        {
            getFoods().put(food,getFoods().get(food)+1);
        }else {
            getFoods().put(food,1);
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

    public HashMap<Food , Integer> getFoods() {
        return foods;
    }

    public void setFoods(HashMap<Food , Integer> foods) {
        this.foods = foods;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
