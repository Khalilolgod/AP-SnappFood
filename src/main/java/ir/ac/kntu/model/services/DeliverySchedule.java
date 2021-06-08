package ir.ac.kntu.model.services;

import ir.ac.kntu.model.deliverySystem.DeliveryShift;

import java.time.LocalTime;
import java.util.ArrayList;

public class DeliverySchedule {

    private LocalTime start;
    private LocalTime end;
    private int numberOfShifts;
    private ArrayList<DeliveryShift> shifts;

    public DeliverySchedule(LocalTime start, LocalTime end, int numberOfShifts) {
        this.start = start;
        this.end = end;
        this.shifts = new ArrayList<>();
        this.numberOfShifts = numberOfShifts;
        makeShifts();
    }

    public DeliverySchedule() {
        this.shifts = new ArrayList<>();
    }


    private void makeShifts() {
        long minutes = start.until(end, ChronoUnit.MINUTES);
        long interval = minutes / numberOfShifts;
        for (int i = 0; i < numberOfShifts; i++) {
            this.shifts.add(new DeliveryShift(start.plusMinutes(interval * i), start.plusMinutes(interval * (i + 1)), 2));
        }
    }

    public DeliverySchedule getAvailableShifts() {
        DeliverySchedule deliverySchedule = new DeliverySchedule();
        for (DeliveryShift d : shifts) {
            if (d.getOrders().size() < d.getCapacity()) {
                deliverySchedule.shifts.add(d);
            }
        }
        return  deliverySchedule;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public int getNumberOfShifts() {
        return numberOfShifts;
    }

    public void setNumberOfShifts(int numberOfShifts) {
        this.numberOfShifts = numberOfShifts;
    }

    public ArrayList<DeliveryShift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<DeliveryShift> shifts) {
        this.shifts = shifts;
    }
}
