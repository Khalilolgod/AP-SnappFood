package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.deliverySystem.*;

public class DeliverySystemMenu extends Menu {

    private EditDeliverer editDeliverer;
    private NewDeliverer newDeliverer;

    public DeliverySystemMenu() {
        super("DeliverySystemMenu.txt");
        this.editDeliverer = new EditDeliverer();
        this.newDeliverer = new NewDeliverer();
    }

    public boolean execute(Agency agency) {
        do {
            showMenu();
        } while (inputProcessor(agency));
        return false;
    }

    public void showAllDeliveries(Agency agency) {
        char i = 'a';
        for (Deliverer deliverer : DeliverySystem.getDeliverers()) {
            System.out.println(i + ". " + deliverer);
            i++;
        }
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                showAllDeliveries(agency);
                return true;
            case "b":
                showAllDeliveries(agency);
                int index = ScannerWrapper.getInstance().next() - 'a';
                editDeliverer.execute(agency, DeliverySystem.getDeliverers().get(index));
                return true;
            case "c":
                newDeliverer.execute(agency);
                return true;
            case "d":
                return false;
            default:
                return false;//TODO make all defaults return true
        }
    }
}
