package ir.ac.kntu.model.users;

import ir.ac.kntu.model.services.Order;
import ir.ac.kntu.model.utils.Location;
import ir.ac.kntu.model.utils.Review;
import ir.ac.kntu.ui.CostumerMenu;

import java.util.ArrayList;
import java.util.Objects;

public class Costumer extends User {

    private Location location;
    private String phoneNumber;
    private ArrayList<Order> purchaseHistory;
    private ArrayList<Review> reviewHistory;
    private CostumerType costumerType;
    private double wallet;
    private CostumerMenu costumerMenu;

    public Costumer(String username, String password, CostumerType costumerType, Location location, String phoneNumber) {
        super(username, password);
        this.costumerType = costumerType;
        this.location = location;
        this.phoneNumber = phoneNumber;
        purchaseHistory = new ArrayList<>();
        reviewHistory = new ArrayList<>();
        costumerMenu = new CostumerMenu(this);
        this.wallet = 10000;

    }

    @Override
    public String toString() {
        return "Costumer{" +
                super.toString()+
                ", wallet='" + getWallet() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", costumerType=" + costumerType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Costumer)) {
            return false;
        }
        Costumer costumer = (Costumer) o;
        return Objects.equals(getPhoneNumber(), costumer.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Order> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<Order> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public ArrayList<Review> getReviewHistory() {
        return reviewHistory;
    }

    public void setReviewHistory(ArrayList<Review> reviewHistory) {
        this.reviewHistory = reviewHistory;
    }

    public CostumerType getCostumerType() {
        return costumerType;
    }

    public void setCostumerType(CostumerType costumerType) {
        this.costumerType = costumerType;
    }

    public CostumerMenu getCostumerMenu() {
        return costumerMenu;
    }

    public void setCostumerMenu(CostumerMenu costumerMenu) {
        this.costumerMenu = costumerMenu;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
