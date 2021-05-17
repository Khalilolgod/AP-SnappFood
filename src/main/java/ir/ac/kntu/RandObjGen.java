package ir.ac.kntu;

import ir.ac.kntu.delivery.*;
import ir.ac.kntu.services.*;
import ir.ac.kntu.time.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;

import java.util.ArrayList;

public class RandObjGen {


    private final Random rand;
    private final String[] restaurentNames = {"alborz", "orkide", "lak lak", "mahan", "pars", "shandiz", "hani", "asil", "narenjestan", "morshed"};
    private final String[] foodNames = {"my own fucking flesh"};//todo write some names


    RandObjGen() {
        this.rand = new Random();
    }

    /**
     * @return a random Delivery object
     */
    public Delivery deliveryGen() {
        VehicleType vehicleType = VehicleType.values()[rand.nextInt(VehicleType.values().length)];
        WageType wageType = WageType.values()[rand.nextInt(WageType.values().length)];
        ArrayList<Restaurant> restaurants = new ArrayList<>();//todo make sure it meets with the restaurant schedule
        Schedule schedule = scheduleGen();
        return new Delivery(vehicleType, wageType, restaurants, schedule);
    }



}
