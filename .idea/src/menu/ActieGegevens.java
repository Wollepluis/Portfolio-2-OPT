package menu;

import model.AZC;
import model.Gemeente;
import model.Vluchteling;
import utils.DataSeeder;
import utils.Security;

public class ActieGegevens implements IActie {
    public void printGegevens(Vluchteling v, boolean asiel, AZC a) {

        System.out.println();
        System.out.println("==============================");
        System.out.println();
        System.out.printf("Naam: %s%n", v.getNaam());
        System.out.printf("Land v Herkomst: %s%n", v.getLandVanHerkomst());

        if (asiel){
            System.out.printf("AZC %s%n", a.getGemeente());
            System.out.printf("%s, %s, %d%n",a.getPostcode(), a.getStraat(), a.getNummer());
        } else {
            System.out.println("AZC? nee");
        }

        System.out.print("Verbijfsvergunning: ");
        if (v.getVerblijfsvergunning()) {
            System.out.printf("%s%n", "Ja");
        } else {
            System.out.printf("%s%n", "Nee");
        }

        System.out.println();
        System.out.println("==============================");
        System.out.println();
    }
    @Override
    public void voerActieUit() {
        String naam = String.valueOf(Security.getInstance().getActieveGebruiker().getGebruikersnaam());
        System.out.println(naam);

        if (!DataSeeder.getInstance().getNieuweVluchtelingen().isEmpty()) {
            for (Vluchteling v : DataSeeder.getInstance().getNieuweVluchtelingen()) {
                if (v.getNaam().equals(naam)) {
                    printGegevens(v, false, null);
                    return;
                }
            }
        }
        for (Gemeente g : DataSeeder.getInstance().gemeentes) {
            for (AZC a : g.azcs) {
                for (Vluchteling v : a.getVluchtelingen()) {
                    if (v.getNaam().equals(naam)) {
                        printGegevens(v, true, a);
                        return;
                    }
                }
            }
        }
    }
}
