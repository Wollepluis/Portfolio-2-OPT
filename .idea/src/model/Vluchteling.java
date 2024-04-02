package model;

import menu.Menu;
import utils.DataSeeder;

public class Vluchteling extends Gebruiker {

    private String naam;
    private String landVanHerkomst;
    private boolean kanPaspoortTonen;
    private boolean verblijfsvergunning;
    private boolean rechter;
    private String rechterUitspraak;
    private String eigenWoning;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setLandVanHerkomst(String landVanHerkomst) {
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

    public String getLandVanHerkomst() {
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

    public Vluchteling(String gebruikersnaam, String naam, String landVanHerkomst) {
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