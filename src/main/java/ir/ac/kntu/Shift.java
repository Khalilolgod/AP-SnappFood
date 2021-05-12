package ir.ac.kntu;

import java.util.Timer;

public class Shift {
    private Time start;
    private Time end;

    public Shift() {
        setStart();
        setEnd();
    }

    public Time getStart() {
        return start;
    }

    public void setStart() {
        System.out.println("set a time for Start");
        this.start = new Time();
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd() {
        System.out.println("set a time for End");
        this.end = new Time();
    }
}
