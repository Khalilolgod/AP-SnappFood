package ir.ac.kntu.time;

import ir.ac.kntu.ScannerWrapper;

import java.time.LocalTime;

public class Shift {
    private LocalTime start;
    private LocalTime end;

    public Shift(LocalTime start ,LocalTime end) {
        this.start = start;
        this.end = end;
    }




    public boolean isShift(LocalTime time){
        return time.isAfter(start) && time.isBefore(end);
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
