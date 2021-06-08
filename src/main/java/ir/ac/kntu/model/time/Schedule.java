package ir.ac.kntu.model.time;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {

    private ArrayList<WorkDay> workDays;

    public Schedule(ArrayList<WorkDay> workDays) {
        this.workDays = workDays;
    }

    public Schedule(LocalTime start, LocalTime end, int numberOfWorkdays) {
        workDays = new ArrayList<>();
        for (int i = 0; i < numberOfWorkdays; i++) {
            WorkDay workDay = new WorkDay(DayOfWeek.values()[i], start, end);
            workDays.add(workDay);
        }

    }

    @Override
    public String toString() {
        String result = "";
        for (WorkDay workDay : workDays) {
            result += workDay.getDay().name();
            for (Shift shift : workDay.getShifts()) {
                result += (" " + shift);
            }
            result += ' ';
        }
        return result;
    }

    public boolean isTodayWorkDay() {
        for (WorkDay workDay : workDays) {
            if (workDay.isWorkDay()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<WorkDay> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(ArrayList<WorkDay> workDays) {
        this.workDays = workDays;
    }
}
