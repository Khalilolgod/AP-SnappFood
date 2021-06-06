package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.deliverySystem.Deliverer;
import ir.ac.kntu.model.services.Product;
import ir.ac.kntu.model.services.Order;
import ir.ac.kntu.model.services.OrderStatus;
import ir.ac.kntu.model.services.Provider;
import ir.ac.kntu.model.utils.ScannerWrapper;

import java.util.ArrayList;

public class EditOrder extends Menu {

    private Order order;

    public EditOrder(Order order) {
        super("EditOrder.txt");
        this.order = order;
    }

    public boolean execute(Provider provider) {
        showMenu();
        return inputProcessor(provider);
    }

    public void editStatus(Order order) {
        char i = 'a';
        for (OrderStatus orderStatus : OrderStatus.values()) {
            System.out.println(i + ". " + orderStatus.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next() - 'a';
        order.setOrderStatus(OrderStatus.values()[choice]);
    }

    public void editFinalPrice(Order order) {
        System.out.println("current Total  : " + order.getFinalPrice());
        System.out.println("new Total : ");
        double finalPrice = ScannerWrapper.getInstance().nextDouble();
        order.setFinalPrice(finalPrice);
    }

    public void editPrepTime(Order order) {
        System.out.println("current prep time  : " + order.getPrepTime());
        System.out.println("new prep time : ");
        int prepTime = ScannerWrapper.getInstance().nextInt();
        order.setPrepTime(prepTime);
    }

    public void editFoods(Provider provider, Order order) {
        System.out.println("a. Add       b. Remove");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                provider.getFoodMenu().execute(provider, order.getCostumer());
                break;
            case "b":
                char i = 'a';
                ArrayList<Product> products = new ArrayList<>();
                products.addAll(order.getProducts().keySet());
                for (Product product : products) {
                    System.out.println(i + ". " + product + ": " + order.getProducts().get(product));
                    i++;
                }
                int chois = ScannerWrapper.getInstance().next() - 'a';
                order.removeFood(products.get(chois));
                break;
            default:
                break;
        }
    }

    public void editDelivery(Provider provider, Order order) {
        System.out.println("a. Replace       b. Remove");
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                char i = 'a';
                for (Deliverer deliverer : provider.getDeliveries()) {
                    System.out.println(i + ". " + deliverer);
                    i++;
                }
                int chois = ScannerWrapper.getInstance().next() - 'a';
                order.setDeliverer(provider.getDeliveries().get(chois));
                break;
            case "b":
                order.setDeliverer(null);
                break;
            default:
                break;
        }
    }

    public boolean inputProcessor(Provider provider) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                editStatus(order);
                break;
            case "b":
                editFinalPrice(order);
                break;
            case "c":
                editPrepTime(order);
                break;
            case "d":
                editFoods(provider, order);
                break;
            case "e":
                editDelivery(provider, order);
                break;
            case "f":
                return false;
            default:
                return false;

        }
        return true;
    }


    //any good suggestion to avoid this type of problems? TODO
    @Override
    public boolean inputProcessor(Agency agency) {
        return false;
    }
}
