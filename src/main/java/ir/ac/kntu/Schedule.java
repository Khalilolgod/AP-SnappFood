package ir.ac.kntu;

import java.util.ArrayList;

public class Schedule {

    private ArrayList <WorkDay> workDays;

    public Schedule(ArrayList<WorkDay> workDays) {
        this.workDays = workDays;
    }

    public boolean isTodayWorkDay(){
        for(WorkDay workDay : workDays){
            if(workDay.isWorkDay()){
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
