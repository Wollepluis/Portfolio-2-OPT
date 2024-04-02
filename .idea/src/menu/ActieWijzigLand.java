package menu;

import model.Land;
import utils.DataSeeder;
import utils.JaNeeVraag;

import java.util.Scanner;

public class ActieWijzigLand implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Welk land wilt u wijzigen?: ");
        String naam = sc.nextLine();

        for (Land land : DataSeeder.getInstance().getLanden()) {

            if (naam.equalsIgnoreCase(land.getNaam())) {
                boolean veilig;

                if (JaNeeVraag.vraag("Is het land veilig? J/N: ")) {
                    veilig = true;
                } else {
                    veilig = false;
                }
                System.out.println("Land succesvol gewijzigd.");
                land.setVeilig(veilig);
                return;
            }
        }
        System.out.println("Dit land staat niet in de database...");
    }
}
