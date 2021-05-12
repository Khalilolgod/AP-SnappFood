package ir.ac.kntu;

public class Time {
    private int hour;
    private int minute;

    public Time() {
        this.setHour();
        this.setMinute();
    }



    public int getHour() {
        return hour;
    }

    public void setHour() {
        int hour;
        while(true) {
            System.out.println("enter an hour");
            hour = ScannerWrapper.getInstance().nextInt();
            if (hour > 23 || hour < 0) {
                System.out.println("invalid hour");
            } else {
                this.hour = hour;
                break;
            }
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute() {
        int minute;
        while(true) {
            System.out.println("enter a minute");
            minute = ScannerWrapper.getInstance().nextInt();
            if (minute > 59 || minute < 0) {
                System.out.println("invalid minute");
            } else {
                this.minute = minute;
                break;
            }
        }
    }
}
