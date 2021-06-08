package ir.ac.kntu.model.users;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verifyUser(String username, String password) {
        if (!getUsername().equals(username)) {
            //System.out.println("user doesn't exist");
            //perhaps using some exeptions would be a good idea
            return false;
        }

        if (!getPassword().equals(password)) {
            //System.out.println("invalid password");
            //
            return false;
        }
        return true;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
