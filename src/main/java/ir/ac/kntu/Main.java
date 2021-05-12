package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        Agency agency = new Agency();
        Restaurant restaurant = new Restaurant("lak lak");
        agency.getRestaurants().add(restaurant);
        agency.operatorlogin();


    }
}