package menu;

import utils.*;
import menu.*;
import model.*;

import java.util.Scanner;

public class ActieWijzigAZC implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Een AZC kan alleen verwijderd worden wanneer er géén vluchtelingen zijn gevestigd.");
        System.out.println("Uit welke gemeente wilt u een AZC verwijderen?: ");
        String gemeente = sc.nextLine();

        for (Gemeente g : DataSeeder.getInstance().gemeentes) {
            if (g.getNaam().equalsIgnoreCase(gemeente)) {
                System.out.println("Geef het adres van het AZC dat u wilt wijzigen.");
                System.out.print("Postcode: ");
                String postcode = sc.nextLine();
                System.out.print("Straat: ");
                String straat = sc.nextLine();
                System.out.print("nummer: ");
                int nummer = Integer.parseInt(sc.nextLine());

                for (AZC a : g.azcs) {
                    if (a.getPostcode().equals(postcode) && a.getStraat().equals(straat) && a.getNummer() == nummer) {
                        System.out.print("Geef de nieuwe postcode op: ");
                        a.setPostcode(sc.nextLine());
                        System.out.print("Geef de nieuwe straatnaam op: ");
                        a.setStraat(sc.nextLine());
                        System.out.print("Geef het nieuwe nummer op: ");
                        a.setNummer(Integer.parseInt(sc.nextLine()));
                        System.out.print("Geef de capaciteit van het AZC: ");
                        a.setHoeveelheidPlaatsen(Integer.parseInt(sc.nextLine()));
                        System.out.println("AZC succesvol gewijzigd.");
                        return;
                    }
                }
                System.out.println("Een AZC met dit adres staat niet geregistreerd.");
            }
        }
        System.out.println(gemeente + " staat niet geregistreerd als een gemeente met een AZC.");
    }
}
