package model;

import utils.*;
import menu.*;
import model.*;

public class COAMedewerker extends Gebruiker {

    public COAMedewerker(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getCOAMedewerkerMenu();
    }
}
