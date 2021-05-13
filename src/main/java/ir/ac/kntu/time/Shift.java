package ir.ac.kntu.time;

import ir.ac.kntu.ScannerWrapper;

import java.time.LocalTime;

public class Shift {
    private LocalTime start;
    private LocalTime end;

    public Shift() {
        setStart();
        setEnd();
    }

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

    public void setStart() {
        System.out.println("set a time for Start");
        System.out.println("enter hour (0-23) : ");
        int hour = ScannerWrapper.getInstance().nextInt();
        System.out.println("enter minute (0-59) : ");
        int minute = ScannerWrapper.getInstance().nextInt();
        this.start = LocalTime.of(hour, minute);
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd() {
        System.out.println("set a time for End");
        System.out.println("enter hour (0-23) : ");
        int hour = ScannerWrapper.getInstance().nextInt();
        System.out.println("enter minute (0-59) : ");
        int minute = ScannerWrapper.getInstance().nextInt();
        this.end =  LocalTime.of(hour,minute);
    }
}
