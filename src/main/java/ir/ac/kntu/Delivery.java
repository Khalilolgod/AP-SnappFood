package ir.ac.kntu;

import java.util.ArrayList;

public class Delivery {
    String id;
    VehicleType vehicleType;
    WageType wageType;
    double paycheck;
    // i guess rating Delivery is quite absurd so fuck it
    Order activeOrder;
    ArrayList <Restaurant> restaurants;
    ArrayList <Order> orderHistory;
    Schedule workdays;

}