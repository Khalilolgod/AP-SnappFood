package ir.ac.kntu.delivery;

import java.util.ArrayList;
import ir.ac.kntu.time.*;
import ir.ac.kntu.services.*;


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
