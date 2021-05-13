package ir.ac.kntu;

public class OperatorMenu extends Menu {

    OperatorMenu(){
        super("OperatorMenu.txt");
    }

    public void execute(Agency agency){
        showMenu();
        inputProcessor(agency);
    }

    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice){
            case "a":
                agency.getChooseRestaurant().execute(agency);
                return true;
            case "b":
                System.out.println("fuck you");
                break;
            default:
                System.out.println("fuck you");
                return false;
        }
        return false;
    }
}
