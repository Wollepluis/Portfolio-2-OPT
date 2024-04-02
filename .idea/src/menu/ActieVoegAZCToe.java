package menu;

import model.Gemeente;
import utils.DataSeeder;

import java.util.Scanner;

public class ActieVoegAZCToe implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vul de volgende gegevens van het AZC in.");
        System.out.print("Gemeente: ");
        String gemeente = sc.nextLine();

        for (Gemeente g : DataSeeder.getInstance().gemeentes) {

            if (g.getNaam().equalsIgnoreCase(gemeente)) {
                System.out.print("Postcode: ");
                String postcode = sc.nextLine();
                System.out.print("Straat: ");
                String straat = sc.nextLine();
                System.out.print("Nummer: ");
                int nummer = Integer.parseInt(sc.nextLine());
                System.out.println("Capaciteit: ");
                int hoeveelheidPlaatsen = Integer.parseInt(sc.nextLine());

                g.voegAZCToe(gemeente, postcode, straat, nummer, hoeveelheidPlaatsen);

                System.out.println("AZC succesvol toegevoegd.");
                return;
            }
        }
        System.out.println("Deze gemeente staat nog niet geregistreerd...");
        System.out.println("Voeg eerst " + gemeente + " toe vóór je een AZC hieraan toevoegt.");
    }
}
