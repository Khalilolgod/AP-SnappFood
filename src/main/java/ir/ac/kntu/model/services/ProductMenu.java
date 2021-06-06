package ir.ac.kntu.model.services;

import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.users.Costumer;

import java.util.ArrayList;

public class ProductMenu {

    private ArrayList <Product> products;

    public ProductMenu(ArrayList<Product> products) {
        this.products = products;
    }

    public void execute(Provider provider, Costumer costumer){
        showMenu();
        inputProcessor(provider,costumer);
    }

    /**
     * shows food names and their price
     */
    public void showMenu(){
        char i = 'a';
        for(Product product : getFoods()){
            System.out.println(i+". "+ product);
            i++;
        }
        System.out.println(i+". " +"done");
    }

    public boolean inputProcessor(Provider provider, Costumer costumer) {
        int choice = ScannerWrapper.getInstance().next()-'a';
        Order order = new Order(costumer);
        while (choice < getFoods().size()) {
            order.addFood(products.get(choice));
            System.out.println("added "+ products.get(choice).getName());
            System.out.println("next food: ");
            choice = ScannerWrapper.getInstance().next()-'a';
        }
        System.out.println("Total : "+order.getFinalPrice());
        provider.getOrders().add(order);
        System.out.println(provider.getOrders().get(0));
        provider.processOrder(order);
        return false;
    }


    public ArrayList<Product> getFoods() {
        return products;
    }

    public void setFoods(ArrayList<Product> products) {
        this.products = products;
    }
}
