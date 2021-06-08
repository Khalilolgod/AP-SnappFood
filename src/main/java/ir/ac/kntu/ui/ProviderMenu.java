package ir.ac.kntu.ui;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.utils.ScannerWrapper;
import ir.ac.kntu.model.services.*;


public class ProviderMenu extends Menu {

    private EditProvider editProvider;

    private NewProvider newProvider;

    public ProviderMenu() {
        super("ProvidersMenu.txt");
        this.editProvider = new EditProvider();
        this.newProvider = new NewProvider();
    }

    public boolean execute(Agency agency) {
        do {
            showMenu();
        } while (inputProcessor(agency));
        return false;
    }

    public void showProviders(Agency agency) {
        char i = 'a';
        for (Provider r : agency.getProviders()) {
            System.out.println(i + ". " + r);
            i++;
        }
    }



    @Override
    public boolean inputProcessor(Agency agency) {
        String choice = ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case "a":
                showProviders(agency);
                return true;
            case "b":
                editProvider.execute(agency);
                return true;
            case "c":
                newProvider.execute(agency);
                return true;
            case "d":
                return false;
            default:
                return false;
        }
    }
}
