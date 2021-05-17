package ir.ac.kntu.ui;

import ir.ac.kntu.Agency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Menu {

    private String filePath;

    private File file;

    public Menu(String filePath) {
        this.filePath = "src/main/java/ir/ac/kntu/ui/menus/"+filePath;
        this.file = new File(this.filePath);
    }

    public Menu() {
        this.filePath = null;
        this.file = null;
    }

    public void showMenu(){
        try {
            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public abstract boolean inputProcessor(Agency agency);

}
