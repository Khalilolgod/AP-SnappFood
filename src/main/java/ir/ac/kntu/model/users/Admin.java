package ir.ac.kntu.model.users;

import ir.ac.kntu.ui.AdminMenu;

public class Admin extends User{

    private AdminMenu adminMenu;

    public Admin(String username, String password) {
        super(username, password);
        adminMenu = new AdminMenu();
    }

    public AdminMenu getAdminMenu() {
        return adminMenu;
    }

    public void setAdminMenu(AdminMenu adminMenu) {
        this.adminMenu = adminMenu;
    }
}
