package ir.ac.kntu;

import java.util.ArrayList;

public class Agency {
    private ArrayList <Restaurant> restaurants;
    private Operator operator;

    Agency()
    {
        this.setOperator(new Operator("admin" , "1234"));
        this.restaurants = new ArrayList<>();
    }

    public void operatorlogin(){
        while(true) {
            if(operator.verifyUser()){
                break;
            }
        }
        operator.operatorMenu.execute(this);
    }

    public void takeOrder(){
        showActiveRestaurants();
        int choice = ScannerWrapper.getInstance().nextInt();
        restaurants.get(choice - 1).getFoodMenu().showFoods();
    }

    void showActiveRestaurants(){
        int i= 1;
        for(Restaurant r :  getRestaurants()){
            //Todo different strategies
            if(r.isActive()){
                System.out.println(i +". " + r);
                i++;
            }
        }
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
