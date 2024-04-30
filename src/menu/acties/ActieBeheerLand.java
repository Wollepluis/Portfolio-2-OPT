package menu.acties;

import utils.*;
import menu.*;

public class ActieBeheerLand implements IActie{

    @Override
    public void voerActieUit() {
        Menu menu = DataSeeder.getInstance().getBeheerLandMenu();

        if (DataSeeder.getInstance().getLanden().isEmpty()) {
            System.out.println("Er zijn geen landen geregistreerd in de database.");
        }

        while (menu.getLaatsteMenukeuze() != 9 && (DataSeeder.getInstance().getLanden().size() > 0)) {
            menu.resetLaatsteMenukeuze();
            System.out.println("Wilt u een land Toevoegen of Wijzigen?");
            menu.toonMenu();
        }
        menu.resetLaatsteMenukeuze();
    }
}