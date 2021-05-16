package ir.ac.kntu.services;

import ir.ac.kntu.*;

public class EditOrder extends Menu {

    private Order order;

    public EditOrder(Order order){
        super("EditOrder.txt");
        this.order = order;
    }

    public boolean execute(Restaurant restaurant){
        showMenu();
        return inputProcessor(restaurant);
    }

    public void editStatus(Order order){
        char i = 'a';
        for(OrderStatus orderStatus : OrderStatus.values()){
            System.out.println(i+". "+orderStatus.name());
            i++;
        }
        int choice = ScannerWrapper.getInstance().next()-'a';
        order.setOrderStatus(OrderStatus.values()[choice]);
    }

    public void editFinalPrice(Order order){
        System.out.println("current Total  : " + order.getFinalPrice());
        System.out.println("new Total : ");
        double finalPrice = ScannerWrapper.getInstance().nextDouble();
        order.setFinalPrice(finalPrice);
    }

    public void editPrepTime(Order order){
        System.out.println("current prep time  : " + order.getPrepTime());
        System.out.println("new prep time : ");
        int prepTime = ScannerWrapper.getInstance().nextInt();
        order.setPrepTime(prepTime);
    }


    public boolean inputProcessor(Restaurant restaurant) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
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
                break;
            case "e":
                break;
            case "f":
                break;
            default:
                break;

        }
        return true;
    }


    //any good suggestion to avoid this type of problems? TODO
    @Override
    public boolean inputProcessor(Agency agency) {
        return false;
    }
}
