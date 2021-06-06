package ir.ac.kntu.model.deliverySystem;

import ir.ac.kntu.model.services.Provider;
import ir.ac.kntu.model.users.Costumer;

import java.util.ArrayList;

public class DeliverySystem
{
    private static ArrayList<Deliverer> deliverers;

    public DeliverySystem(ArrayList<Deliverer> deliverers) {
        DeliverySystem.deliverers = deliverers;
    }

    public DeliverySystem(){
        deliverers = new ArrayList<>();
    }

    public static Deliverer findDeliverer(Costumer costumer , Provider provider){
        double minDist = Double.MAX_VALUE;
        double dist = 0;
        Deliverer deliverer =  null;
        for(Deliverer d : getDeliverers()){
            dist = d.getLocation().distanceFrom(costumer.getLocation()) + d.getLocation().distanceFrom(provider.getLocation());
            if (dist<minDist){
                minDist = dist;
                deliverer = d;
            }
        }
        return deliverer;
    }

    private static ArrayList<Deliverer> getDeliverers() {
        return deliverers;
    }

    public void setDeliverers(ArrayList<Deliverer> deliverers) {
        DeliverySystem.deliverers = deliverers;
    }
}
