package ir.ac.kntu.model.services;

import ir.ac.kntu.model.deliverySystem.DeliveryShift;
import ir.ac.kntu.model.deliverySystem.DeliverySystem;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.users.Costumer;

import java.util.HashMap;

public class ProductMenu {

    private HashMap<Product, Integer> products;

    public ProductMenu(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public ProductMenu() {
        this.products = new HashMap<>();
    }

    public void execute(Provider provider, Costumer costumer) {
        showMenu();
        inputProcessor(provider, costumer);
    }

    /**
     * shows product names and their price
     */
    public void showMenu() {
        char i = 'a';
        for (Product p : products.keySet()) {
            System.out.println(i + ". " + p.getName() + " : " + products.get(p));
            i++;
        }
        System.out.println(i + ". " + "done");
    }

    public void removeOne(Product product) {
        getProducts().put(product, getProducts().get(product) - 1);
    }

    public DeliveryShift selectDeliveryShift(Order order) {
        char i = 'a';
        for (DeliveryShift d : order.getProvider().getDeliverySchedule().getAvailableShifts().getShifts()) {
            System.out.println(i + ". " + d);
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        //todo what if its empty
        return order.getProvider().getDeliverySchedule().getAvailableShifts().getShifts().get(choice);
    }


    public void processOrder(Order order) {
        if (order.getOrderStatus() == OrderStatus.PROCESSING) {
            DeliveryShift deliveryShift = selectDeliveryShift(order);
            order.setDeliveryShift(deliveryShift);
            //todo remove the chosen shift from restaurants shifts
            order.setOrderStatus(OrderStatus.RESERVED);
        } else if (order.getOrderStatus() == OrderStatus.RESERVED) {
            // todo check if its time
            order.setDeliverer(DeliverySystem.findDeliverer(order.getCostumer(), order.getProvider(), order));
            order.setOrderStatus(OrderStatus.SENDING);
        } else if (order.getOrderStatus() == OrderStatus.SENDING) {
            //TODO check if its Delivered by ETA
            System.out.println("deliverd");
            order.setOrderStatus(OrderStatus.DELIVERED);
        }
    }

    public boolean inputProcessor(Provider provider, Costumer costumer) {
        int choice = ScannerWrapper.getInstance().next() - 'a';
        Order order = new Order(provider, costumer);
        costumer.getPurchaseHistory().add(order);
        while (choice < getProducts().size()) {
            if(products.get((Product)products.keySet().toArray()[choice]) > 0){
                order.addProduct((Product)products.keySet().toArray()[choice]);
                reduceProductCount((Product) products.keySet().toArray()[choice]);
                costumer.setWallet(costumer.getWallet()- ((Product) products.keySet().toArray()[choice]).getPrice());
                System.out.println("added " + ((Product) products.keySet().toArray()[choice]).getName());
            }else {
                System.out.println("out of this product");
            }

            System.out.println("next food: ");
            choice = ScannerWrapper.getInstance().next() - 'a';
        }
        System.out.println("Total : " + order.getFinalPrice());
        provider.getOrders().add(order);
        //System.out.println(provider.getOrders().get(0));
        processOrder(order);
        return false;
    }

    public void reduceProductCount(Product product){
        products.put(product,products.get(product)-1);
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }
}
