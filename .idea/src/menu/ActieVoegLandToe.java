package menu;

import utils.*;
import menu.*;
import model.*;

import java.util.Scanner;

public class ActieVoegLandToe implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        String naam;
        boolean veilig;

        System.out.print("Geef de naam van het land: ");
        naam = sc.nextLine();

        if (JaNeeVraag.vraag("Is het land veilig? J/N: ")) {
            veilig = true;
        } else {
            veilig = false;
        }
        System.out.println("Land succesvol toegevoegd.");
        DataSeeder.getInstance().voegLandToe(naam, veilig);
    }
}
