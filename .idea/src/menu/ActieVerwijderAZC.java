package menu;

import model.AZC;
import model.Gemeente;
import utils.DataSeeder;

import java.util.Scanner;

public class ActieVerwijderAZC implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Een AZC kan alleen verwijderd worden wanneer er géén vluchtelingen zijn gevestigd.");
        System.out.println("Uit welke gemeente wilt u een AZC verwijderen?: ");
        String gemeente = sc.nextLine();

        for (Gemeente g : DataSeeder.getInstance().gemeentes) {
            if (g.getNaam().equalsIgnoreCase(gemeente)) {
                System.out.println("Geef het adres van het AZC dat u wilt verwijderen.");
                System.out.print("Postcode: ");
                String postcode = sc.nextLine();
                System.out.print("Straat: ");
                String straat = sc.nextLine();
                System.out.print("nummer: ");
                int nummer = Integer.parseInt(sc.nextLine());

                for (AZC a : g.azcs) {
                    if (a.getPostcode().equals(postcode) && a.getStraat().equals(straat) && a.getNummer() == nummer) {
                        if (a.getVluchtelingen().isEmpty()) {
                            g.azcs.remove(a);
                            System.out.println("AZC succesvol verwijderd.");
                        } else {
                            System.out.println("In dit AZC zijn nog vluchtelingen gevestigd. Verwijderen geannuleerd");
                        }
                        return;
                    }
                }
                System.out.println("Een AZC met dit adres staat niet geregistreerd.");
                return;
            }
        }
        System.out.println(gemeente + " staat niet geregistreerd als een gemeente met een AZC.");
    }
}
