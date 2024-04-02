package model;

import menu.Menu;
import utils.DataSeeder;

public class COAMedewerker extends Gebruiker {

    public COAMedewerker(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getCOAMedewerkerMenu();
    }
}
