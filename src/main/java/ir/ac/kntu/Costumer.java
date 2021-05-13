package ir.ac.kntu;

import java.util.Objects;

public class Costumer {

    private String address;
    private String phoneNumber;

    public Costumer(String phoneNumber, String address) {
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }

    public Costumer() {
        System.out.println("enter phone number");
        String phonenumber = ScannerWrapper.getInstance().nextLine();
        System.out.println("enter address");
        String address = ScannerWrapper.getInstance().nextLine();
        this.phoneNumber = phonenumber;
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Costumer)) return false;
        Costumer costumer = (Costumer) o;
        return Objects.equals(getAddress(), costumer.getAddress()) && Objects.equals(getPhoneNumber(), costumer.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPhoneNumber());
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
