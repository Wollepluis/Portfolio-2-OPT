package menu;

import model.AZC;
import model.Gemeente;
import utils.DataSeeder;

public class ActieRapportageOpvragen implements IActie{
    @Override
    public void voerActieUit() {
        System.out.println();
        System.out.println("==== Rapportage Uitkering ====");
        System.out.println();

        for (Gemeente g : DataSeeder.getInstance().gemeentes) {
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

            int uitkering;
            if (totaalCapaciteit == 0) {
                uitkering = 0;
            } else if (totaalCapaciteit > (g.getAantalInwoners() * 0.005) + 100){
                uitkering = 2000 * aantalVluchtelingen;
            } else {
                uitkering = 1000 * aantalVluchtelingen;
            }
            System.out.printf("Uitkering: €%d,-%n",uitkering);
            System.out.println();
        }
        System.out.println("==============================");
    }
}
