package model;

import utils.*;
import menu.*;
import model.*;

public class Vluchteling extends Gebruiker {

    private String naam;
    private Land landVanHerkomst;
    private boolean kanPaspoortTonen;
    private boolean verblijfsvergunning;
    private boolean rechter;
    private String rechterUitspraak;
    private String eigenWoning;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public void setKanPaspoortTonen(boolean kanPaspoortTonen) {
        this.kanPaspoortTonen = kanPaspoortTonen;
    }

    public void setVerblijfsvergunning(boolean verblijfsvergunning) {
        this.verblijfsvergunning = verblijfsvergunning;
    }

    public void setRechter(boolean rechter) {
        this.rechter = rechter;
    }

    public String getNaam() {
        return this.naam;
    }

    public Land getLandVanHerkomst() {
        return this.landVanHerkomst;
    }

    public boolean getKanPaspoortTonen() {
        return this.kanPaspoortTonen;
    }

    public boolean getVerblijfsvergunning() {
        return this.verblijfsvergunning;
    }

    public boolean getRechter() {
        return rechter;
    }

    public String getRechterUitspraak() {
        return rechterUitspraak;
    }

    public String getEigenWoning() {
        return eigenWoning;
    }

    public Vluchteling(String gebruikersnaam, String naam, Land landVanHerkomst) {
        super(gebruikersnaam);
        this.setNaam(naam);
        this.setLandVanHerkomst(landVanHerkomst);
        this.kanPaspoortTonen = false;
        this.verblijfsvergunning = false;
        this.rechter = false;
        this.rechterUitspraak = "Nee";
        this.eigenWoning = "Nee";
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getVluchtelingenMenu();
    }
}