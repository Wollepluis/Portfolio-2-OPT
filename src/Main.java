import utils.*;
import menu.*;
import model.*;

public class Main {
    public static void main(String[] args) {

        DataSeeder seeder = DataSeeder.getInstance();


        while(true) {
            Menu menu = seeder.getMenu();
            menu.toonMenu();
        }
    }
}
