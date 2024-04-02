package model;

import utils.*;
import menu.*;
import model.*;

import java.util.ArrayList;

public class Gemeente {

    private String naam;
    private int aantalInwoners;

    public ArrayList<AZC> azcs;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantalInwoners(int aantalInwoners) {
        this.aantalInwoners = aantalInwoners;
    }

    public String getNaam() {
        return this.naam;
    }

    public int getAantalInwoners() {
        return this.aantalInwoners;
    }

    public ArrayList<AZC> getAzcs() {
        return this.azcs;
    }

    public Gemeente(String naam, int aantalInwoners) {
        this.setNaam(naam);
        this.setAantalInwoners(aantalInwoners);
        this.azcs = new ArrayList<>();
    }

    public void voegAZCToe(String gemeente, String postcode, String straat, int nummer, int hoeveelheidPlaatsen) {
        AZC azc = new AZC(gemeente, postcode, straat, nummer, hoeveelheidPlaatsen);
        azcs.add(azc);
    }
}

