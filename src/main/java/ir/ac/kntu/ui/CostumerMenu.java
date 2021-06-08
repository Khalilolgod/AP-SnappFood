package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.services.Order;
import ir.ac.kntu.model.users.Costumer;
import ir.ac.kntu.model.utils.Review;
import ir.ac.kntu.model.utils.ScannerWrapper;

public class CostumerMenu extends Menu{

    private Costumer costumer ;
    private EditCostumersMenu editCostumersMenu;

    public CostumerMenu(Costumer costumer){
        this.costumer = costumer;
        this.editCostumersMenu = new EditCostumersMenu(costumer);
    }

    public boolean execute(Agency agency){
        do {
            showMenu();
        } while (inputProcessor(agency));
        return false;
    }

    @Override
    public void showMenu() {
        super.showMenu();
        System.out.println("a. order      b. show info       c. edit info \n\t\td. exit");
    }

    void showinfo(){
        System.out.println(costumer);
        System.out.println("reviews : ");
        for(Review r : costumer.getReviewHistory()){
            System.out.println(r);
        }
        System.out.println("purchases : ");
        for (Order o : costumer.getPurchaseHistory()){
            System.out.println(o);
        }
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":
                agency.getChooseProviderMenu().execute(agency, costumer);
                return true;
            case "b":
                showinfo();
                return true;
            case "c":
                this.editCostumersMenu.execute(agency);
                return true;
            default:
                return false;
        }
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public EditCostumersMenu getEditCostumersMenu() {
        return editCostumersMenu;
    }

    public void setEditCostumersMenu(EditCostumersMenu editCostumersMenu) {
        this.editCostumersMenu = editCostumersMenu;
    }
}
