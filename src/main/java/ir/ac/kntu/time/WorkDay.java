package ir.ac.kntu.time;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class WorkDay {

    private ArrayList<Shift> shifts;
    private DayOfWeek day;

    public WorkDay(DayOfWeek day, ArrayList<Shift> shifts) {
        this.shifts = shifts;
        this.day = day;
    }

    @Override
    public String toString() {
        String output = "day=" + day.name();
        for (int i = 0; i < shifts.size(); i++) {
            output += ("   " + (i + 1) + ". " + shifts.get(i));
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkDay)) {
            return false;
        }
        WorkDay workDay = (WorkDay) o;
        return Objects.equals(getShifts(), workDay.getShifts()) && getDay() == workDay.getDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShifts(), getDay());
    }

    public boolean isWorkDay() {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        LocalTime time = LocalTime.now();
        if (!today.equals(getDay())) {
            return false;
        }
        for (Shift shift : shifts) {
            if (shift.isShift(time)) {
                return true;
            }
        }
        return false;

    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

}