package menu.acties;

import utils.*;
import model.*;

import java.util.Scanner;

public class ActieDossierOpvragen implements IActie {
    public void printRapportage(Vluchteling vluchteling, boolean asiel) {

        System.out.println();
        System.out.println("========= Rapportage =========");
        System.out.println();

        System.out.print("Paspoort getoond: ");
        if (vluchteling.getKanPaspoortTonen()) {
            System.out.printf("%s%n", "Ja");
        } else {
            System.out.printf("%s%n", "Nee");
        }

        System.out.print("Asielaanvraag compleet: ");
        if (asiel) {
            System.out.printf("%s%n", "Ja");
        } else {
            System.out.printf("%s%n", "Nee");
        }

        System.out.print("Rechter toegewezen: ");
        if (vluchteling.getRechter()) {
            System.out.printf("%s%n", "Ja");
        } else {
            System.out.printf("%s%n", "Nee");
        }

        System.out.printf("Rechter uitspraak: %s%n", vluchteling.getRechterUitspraak());
        System.out.printf("Plaatsing in eigen woning: %s%n", vluchteling.getEigenWoning());
        System.out.println();
        System.out.println("==============================");
        System.out.println();
    }

    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        if (Security.getInstance().getActieveGebruiker().getGebruikersnaam().equals("COA")) {
            System.out.print("Van wie wil je een rapportage opvragen?: ");
            String naam = sc.nextLine();

            if (!DataSeeder.getInstance().getNieuweVluchtelingen().isEmpty()) {
                for (Vluchteling v : DataSeeder.getInstance().getNieuweVluchtelingen()) {
                    if (v.getNaam().equals(naam)) {
                        printRapportage(v, false);
                        return;
                    }
                }
            }
            for (Gemeente g : DataSeeder.getInstance().gemeentes) {
                for (AZC a : g.azcs) {
                    for (Vluchteling v : a.getVluchtelingen()) {
                        if (v.getNaam().equals(naam)) {
                            printRapportage(v, true);
                            return;
                        }
                    }
                }
            }
            System.out.println(naam + " is niet geregistreerd in de database...");
        } else {
            String naam = String.valueOf(Security.getInstance().getActieveGebruiker().getGebruikersnaam());
            System.out.println(naam);

            if (!DataSeeder.getInstance().getNieuweVluchtelingen().isEmpty()) {
                for (Vluchteling v : DataSeeder.getInstance().getNieuweVluchtelingen()) {
                    if (v.getNaam().equals(naam)) {
                        printRapportage(v, false);
                        return;
                    }
                }
            }
            for (Gemeente g : DataSeeder.getInstance().gemeentes) {
                for (AZC a : g.azcs) {
                    for (Vluchteling v : a.getVluchtelingen()) {
                        if (v.getNaam().equals(naam)) {
                            printRapportage(v, true);
                            return;
                        }
                    }
                }
            }
        }
    }
}
