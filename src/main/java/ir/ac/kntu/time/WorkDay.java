package ir.ac.kntu.time;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class WorkDay {

    private ArrayList<Shift> shifts;
    private DayOfWeek day;

    public WorkDay(DayOfWeek day , ArrayList<Shift> shifts) {
        this.shifts = shifts;
        this.day = day;
    }

    //Todo write a constructor using user input;


    public boolean isWorkDay(){
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        LocalTime time = LocalTime.now();
        if(!today.equals(getDay())){
            return false;
        }
        for(Shift shift : shifts){
            if(shift.isShift(time)){
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
