package menu;

import model.Vluchteling;
import utils.DataSeeder;

import java.util.Scanner;

public class ActieVoegVluchtelingToe implements IActie {
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Voer de onderstaande gegevens in.");
        System.out.print("Volledige naam: ");
        String naam = sc.nextLine();
        System.out.print("Land van herkomst: ");
        String land = sc.nextLine();

        DataSeeder.getInstance().voegVluchtelingToe(naam, land);
        System.out.println("Vluchteling succesvol toegevoegd.");
    }
}