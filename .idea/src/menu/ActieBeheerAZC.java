package menu;

import model.AZC;
import model.Gemeente;
import utils.DataSeeder;

public class ActieBeheerAZC implements IActie{


    @Override
    public void voerActieUit() {
        Menu menu = DataSeeder.getInstance().getBeheerAZCMenu();

        while (menu.getLaatsteMenukeuze() != 9 && (DataSeeder.getInstance().getGemeentes().size() > 0)) {
            menu.resetLaatsteMenukeuze();
            System.out.println("Wat wilt u doen?");
            menu.toonMenu();
        }
        menu.resetLaatsteMenukeuze();
    }
}
