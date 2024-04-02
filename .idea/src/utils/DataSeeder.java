package utils;

import utils.*;
import menu.*;
import model.*;

import java.util.ArrayList;

public class DataSeeder {

    private static DataSeeder instance = null;
    private ArrayList<Gebruiker> gebruikers;
    private ArrayList<Menu> menus;

    private ArrayList<Land> landen;
    public ArrayList<Gemeente> gemeentes;
    private ArrayList<Vluchteling> nieuweVluchtelingen;

    public void voegLandToe(String naam, boolean veilig) {
        Land land = new Land(naam, veilig);
        landen.add(land);
    }

    public void voegGemeenteToe(String naam, int aantalInwoners) {
        Gemeente gemeente = new Gemeente(naam, aantalInwoners);
        gemeentes.add(gemeente);
    }

    public void voegAZCToe(String gemeente, String postcode, String straat, int nummer, int hoeveelheidPlaatsen) {
        AZC azc = new AZC(gemeente, postcode, straat, nummer, hoeveelheidPlaatsen);

        for (Gemeente g : gemeentes) {
            if (g.getNaam().equalsIgnoreCase(gemeente)) {
                g.azcs.add(azc);
            }
        }
    }

    public void voegVluchtelingToe(String naam, String landVanHerkomst) {
        Vluchteling vluchteling = new Vluchteling(naam, naam, landVanHerkomst);
        voegGebruikerToe(vluchteling);
        nieuweVluchtelingen.add(vluchteling);
    }

    private void voegGebruikerToe(Gebruiker gebruiker) {

        for (Gebruiker g : gebruikers) {

            if (g.getGebruikersnaam().equals(gebruiker.getGebruikersnaam())) {
                return;
            }
        }
        gebruikers.add(gebruiker);
    }

    private void initialize() {

        voegGebruikerToe(new Beheerder("Beheerder"));
        voegGebruikerToe(new COAMedewerker("COA"));

        voegLandToe("Syrië", true);
        voegLandToe("Afghanistan", true);
        voegLandToe("Oekraïne", false);

        voegGemeenteToe("Amsterdam", 918000);
        voegGemeenteToe("Rotterdam", 663000);
        voegGemeenteToe("Den Haag", 562000);

        voegAZCToe("Amsterdam", "1067SL", "Willinklaan", 3, 700);
        voegAZCToe("Den Haag", "2517AS", "Laan van Meerdervoort", 108, 600);

        voegVluchtelingToe("Mark Wilbrink", "Nederland");

        //Menu 0
        Menu uitgelogd = new Menu ("U bent nog niet ingelogd");
        Menukeuze inloggen = new Menukeuze ("Login", new ActieLogin ());
        Menukeuze exit = new Menukeuze (9, "Exit", true, new ActieExit ());
        uitgelogd.voegMenukeuzeToe (inloggen);
        uitgelogd.voegMenukeuzeToe (exit);
        menus.add (uitgelogd);

        //Menu 1
        Menu beheerderMenu = new Menu ("U bent ingelogd als beheerder");
        beheerderMenu.voegMenukeuzeToe(new Menukeuze ("Landen Beheren", new ActieBeheerLand()));
        beheerderMenu.voegMenukeuzeToe (new Menukeuze ("Voeg Gemeente Toe", new ActieVoegGemeenteToe()));
        beheerderMenu.voegMenukeuzeToe (new Menukeuze ("AZC's Beheren", new ActieBeheerAZC()));
        beheerderMenu.voegMenukeuzeToe (new Menukeuze ("Uitkering Rapportage Opvragen", new ActieRapportageOpvragen()));
        beheerderMenu.voegMenukeuzeToe (new Menukeuze ("Aantal Plaatsen Vastleggen", new ActiePlaatsenVastleggen()));
        Menukeuze logout = new Menukeuze ("Logout", new ActieLogout());
        beheerderMenu.voegMenukeuzeToe (logout);
        beheerderMenu.voegMenukeuzeToe (exit);
        menus.add(beheerderMenu);

        //Menu 2
        Menu beheerLandMenu = new Menu("Beheer Land");
        beheerLandMenu.voegMenukeuzeToe(new Menukeuze("Toevoegen", new ActieVoegLandToe()));
        beheerLandMenu.voegMenukeuzeToe(new Menukeuze("Wijzigen", new ActieWijzigLand()));
        Menukeuze terug = new Menukeuze(9,"Terug", true, new ActieTerug());
        beheerLandMenu.voegMenukeuzeToe(terug);
        menus.add(beheerLandMenu);

        //Menu 3
        Menu beheerAZCMenu = new Menu("Beheer AZC's");
        beheerAZCMenu.voegMenukeuzeToe(new Menukeuze("Toevoegen", new ActieVoegAZCToe()));
        beheerAZCMenu.voegMenukeuzeToe(new Menukeuze("Wijzigen", new ActieWijzigAZC()));
        beheerAZCMenu.voegMenukeuzeToe(new Menukeuze("Verwijderen", new ActieVerwijderAZC()));
        beheerAZCMenu.voegMenukeuzeToe(terug);
        menus.add(beheerAZCMenu);

        //Menu 4
        Menu coaMenu = new Menu("U bent ingelogd als COA-Medewerker");
        coaMenu.voegMenukeuzeToe(new Menukeuze("Registreer vluchteling", new ActieVoegVluchtelingToe()));
        coaMenu.voegMenukeuzeToe(new Menukeuze("Asielzoeker (over)plaatsen in AZC", new ActieOverplaatsen()));
        Menukeuze dossier = new Menukeuze("Dossier", new ActieDossierOpvragen());
        coaMenu.voegMenukeuzeToe(dossier);
        coaMenu.voegMenukeuzeToe(logout);
        menus.add(coaMenu);

        //Menu 5
        Menu vluchtelingenMenu = new Menu("U bent ingelogd als vluchteling");
        vluchtelingenMenu.voegMenukeuzeToe(new Menukeuze("Gegevens", new ActieGegevens()));
//        vluchtelingenMenu.voegMenukeuzeToe(new Menukeuze("Registreer Woning", new ActieRegistreerWoning()));
        vluchtelingenMenu.voegMenukeuzeToe(dossier);
        menus.add(vluchtelingenMenu);
    }

    private DataSeeder() {
        this.gebruikers = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.landen = new ArrayList<>();
        this.gemeentes = new ArrayList<>();
        this.nieuweVluchtelingen = new ArrayList<>();
        initialize();
    }

    public static DataSeeder getInstance() {

        if (instance == null) {
            instance = new DataSeeder();
        }
        return instance;
    }

    public Gebruiker getGebruiker(String gebruikersnaam) {

        for (Gebruiker gebruiker : gebruikers) {

            if (gebruiker.login(gebruikersnaam)) {
                return gebruiker;
            }
        }
        return null;
    }
    public Menu getVluchtelingenMenu() {
        return menus.get(5);
    }

    public Menu getCOAMedewerkerMenu() {
        return menus.get(4);
    }

    public Menu getBeheerAZCMenu() {
        return menus.get(3);
    }

    public Menu getBeheerLandMenu() {
        return menus.get(2);
    }

    public Menu getBeheerderMenu() {
        return menus.get(1);
    }

    public Menu getMenu() {

        Security security = Security.getInstance();

        if (!security.isIngelogd()) {
            return menus.get(0);
        } else {
            Gebruiker gebruiker = security.getActieveGebruiker();
            return gebruiker.getMenu();
        }
    }

    public ArrayList<Land> getLanden() {
        return this.landen;
    }

    public ArrayList<Gemeente> getGemeentes() {
        return this.gemeentes;
    }

    public ArrayList<Vluchteling> getNieuweVluchtelingen() {
        return this.nieuweVluchtelingen;
    }
}
