package menu;

import utils.*;
import menu.*;
import model.*;

import java.util.Scanner;

public class ActieVoegVluchtelingToe implements IActie {
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);
        DataSeeder seeder = DataSeeder.getInstance();

        System.out.println("Voer de onderstaande gegevens in.");
        System.out.print("Volledige naam: ");
        String naam = sc.nextLine();
        System.out.print("Land van herkomst: ");
        String land = sc.nextLine();

        Land landnaam = null;
        while (landnaam == null) {
            for (Land l : seeder.getLanden()) {
                if (l.getNaam().equalsIgnoreCase(land)) {
                    landnaam = l;
                    break;
                }
            }
            if (landnaam == null) {
                seeder.voegLandToe(land, false);
            }
        }


        DataSeeder.getInstance().voegVluchtelingToe(naam, landnaam);
        System.out.println("Vluchteling succesvol toegevoegd.");
    }
}