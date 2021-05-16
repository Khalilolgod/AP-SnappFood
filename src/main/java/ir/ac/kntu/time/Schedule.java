package ir.ac.kntu.time;

import java.util.ArrayList;

public class Schedule {

    private ArrayList <WorkDay> workDays;

    public Schedule(ArrayList<WorkDay> workDays) {
        this.workDays = workDays;
    }

    @Override
    public String toString() {
        String result = "";
        for(WorkDay workDay : workDays){
            result += workDay.getDay().name();
            for(Shift shift : workDay.getShifts()){
                result += (" "+shift);
            }
            result+= '\n';
        }
        return result;
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
