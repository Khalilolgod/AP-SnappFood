package ir.ac.kntu.model.services;

import ir.ac.kntu.model.time.Schedule;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.model.utils.Location;

public class Restaurant extends Provider{

    public Restaurant(String name, ProductMenu productMenu, Schedule schedule, Location location, ServiceType type, Operator operator) {
        super(name, productMenu, schedule, location, type, operator);
    }
}
