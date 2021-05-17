package ir.ac.kntu.time;

import ir.ac.kntu.ScannerWrapper;

import java.time.LocalTime;
import java.util.Objects;

public class Shift {
    private LocalTime start;
    private LocalTime end;

    public Shift(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
        //not sure if LocalTime has the right toString() method
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shift)) {
            return false;
        }
        Shift shift = (Shift) o;
        return Objects.equals(getStart(), shift.getStart()) && Objects.equals(getEnd(), shift.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }

    public boolean isShift(LocalTime time) {
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
