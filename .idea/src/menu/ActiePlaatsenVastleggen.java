package menu;

import utils.*;
import menu.*;
import model.*;

import java.util.Scanner;

public class ActiePlaatsenVastleggen implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Van welke gemeente wil je de hoeveelheid aangeboden plaatsen zien?: ");
        String gemeente = sc.nextLine();
        System.out.println();

        for (Gemeente g : DataSeeder.getInstance().gemeentes) {
            if (g.getNaam().equalsIgnoreCase(gemeente)) {
                System.out.printf("%s, %d inwoners%n", g.getNaam(), g.getAantalInwoners());

                int totaalCapaciteit = 0;
                int teller = 0;
                int aantalVluchtelingen = 0;

                for (AZC a : g.azcs) {
                    totaalCapaciteit += a.getHoeveelheidPlaatsen();
                    aantalVluchtelingen += a.getVluchtelingen().size();
                    teller++;
                }
                System.out.printf("aantal AZC's: %d%n", teller);
                System.out.printf("Totale capaciteit: %d%n", totaalCapaciteit);
                System.out.printf("Aantal gevestigde vluchtelingen: %d%n", aantalVluchtelingen);
                System.out.println();
                return;
            }
            System.out.println("Deze gemeente is niet geregistreerd in de database...");
        }
    }
}
