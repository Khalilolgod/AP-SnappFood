package ir.ac.kntu;

import ir.ac.kntu.services.*;
import ir.ac.kntu.delivery.*;

public class DeliveryMenu extends Menu {
    
    private EditDelivery editDelivery;
    private NewDelivery newDelivery;
    
    public DeliveryMenu(){
        super("DeliveryMenu.txt");
    }

    public boolean execute(Agency agency){
        showMenu();
        return inputProcessor(agency);
    }

    public void showAllDeliveries(Agency agency){
        char i = 'a';
        for (Delivery delivery : agency.getAllDeliveries()){
            System.out.println(i+". "+delivery);
            i++;
        }
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice)
        {
            case "a":
                showAllDeliveries(agency);
                break;
            case "b":
                showAllDeliveries(agency);
                int index = ScannerWrapper.getInstance().next()-'a' ;
                editDelivery.execute(agency,agency.getAllDeliveries().get(index));
                break;
            case "c":
                newDelivery.execute(agency);
                break;
            case "d":
                return false;
            default:
                return false;//TODO make all defaults return true
        }
        return true;
    }
}
