package ir.ac.kntu.model.deliverySystem;

import java.util.ArrayList;

public class DeliverySystem
{
    private ArrayList<Deliverer> deliverers;

    public DeliverySystem(ArrayList<Deliverer> deliverers) {
        this.deliverers = deliverers;
    }

    public DeliverySystem(){
        this.deliverers = new ArrayList<>();
    }

    public ArrayList<Deliverer> getDeliverers() {
        return deliverers;
    }

    public void setDeliverers(ArrayList<Deliverer> deliverers) {
        this.deliverers = deliverers;
    }
}
