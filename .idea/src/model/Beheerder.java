package model;

import menu.Menu;
import utils.DataSeeder;

public class Beheerder extends Gebruiker {

    public Beheerder(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}

