package model;

import utils.*;
import menu.*;
import model.*;

public class Land {

    private String naam;
    private boolean veilig;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVeilig(boolean veilig) {
        this.veilig = veilig;
    }

    public String getNaam() {
        return this.naam;
    }

    public boolean getVeilig() {
        return this.veilig;
    }

    public Land(String naam, boolean veilig) {
        this.setNaam(naam);
        this.setVeilig(veilig);
    }
}
