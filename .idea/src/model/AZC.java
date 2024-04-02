package model;

import java.util.ArrayList;

public class AZC {

    private String gemeente;
    private String postcode;
    private String straat;
    private int nummer;
    private int hoeveelheidPlaatsen;

    private ArrayList<Vluchteling> vluchtelingen;

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setHoeveelheidPlaatsen(int hoeveelheidPlaatsen) {
        this.hoeveelheidPlaatsen = hoeveelheidPlaatsen;
    }

    public String getGemeente() {
        return this.gemeente;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getStraat() {
        return this.straat;
    }

    public int getNummer() {
        return this.nummer;
    }

    public int getHoeveelheidPlaatsen() {
        return this.hoeveelheidPlaatsen;
    }

    public ArrayList<Vluchteling> getVluchtelingen() {
        return this.vluchtelingen;
    }

    public AZC(String gemeente, String postcode, String straat, int nummer, int hoeveelheidPlaatsen) {
        this.setGemeente(gemeente);
        this.setPostcode(postcode);
        this.setStraat(straat);
        this.setNummer(nummer);
        this.setHoeveelheidPlaatsen(hoeveelheidPlaatsen);
        this.vluchtelingen = new ArrayList<>();
    }

}
