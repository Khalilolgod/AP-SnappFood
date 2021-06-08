package ir.ac.kntu.model.services;

import ir.ac.kntu.model.time.Schedule;
import ir.ac.kntu.model.users.Operator;
import ir.ac.kntu.model.utils.Location;

import java.time.LocalTime;

public class SuperMarket extends Provider{

    public SuperMarket(String name, Location location, ServiceType type, Operator operator) {
        super(name, location, type, operator);
        setSchedule(new Schedule(LocalTime.of(6,0),LocalTime.of(23,30),7));
        setDeliverySchedule(new DeliverySchedule(LocalTime.of(6,0),LocalTime.of(23,30),12));
        setProviderType(ProviderType.SUPERMARKET);

    }
}
