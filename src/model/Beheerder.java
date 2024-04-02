package model;

import utils.*;
import menu.*;
import model.*;

public class Beheerder extends Gebruiker {

    public Beheerder(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}

