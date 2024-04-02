package menu;

import model.AZC;
import model.Gemeente;
import model.Vluchteling;
import utils.DataSeeder;

import java.util.Scanner;

public class ActieOverplaatsen implements IActie {
    private void voorgesteldeGemeente() {
        int totaalCapaciteit = 0;
        int aantalVluchtelingen = 0;
        int aantalPlekken;
        String print = null;
        int nieuwAantalPlekken = 1000000000;
        for (Gemeente g : DataSeeder.getInstance().gemeentes) {

            for (AZC a : g.azcs) {
                totaalCapaciteit += a.getHoeveelheidPlaatsen();
                aantalVluchtelingen += a.getVluchtelingen().size();
            }
            aantalPlekken = totaalCapaciteit - aantalVluchtelingen;

            if (aantalPlekken < nieuwAantalPlekken) {
                print = g.getNaam();
                nieuwAantalPlekken = aantalPlekken;
            }
        }
        System.out.println();
        System.out.println("==== Voorgesteld gemeente ====");
        System.out.println();
        System.out.printf("%s, ", print);
        System.out.printf("aantal plekken: %d%n", nieuwAantalPlekken);
        System.out.println();
        System.out.println("==============================");
    }

    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wie wilt u in een AZC plaatsen?: ");
        String naam = sc.nextLine();

        for (Vluchteling v : DataSeeder.getInstance().getNieuweVluchtelingen()) {

            if (v.getNaam().equals(naam)) {
                voorgesteldeGemeente();
                System.out.println("In welk AZC wilt u " + naam + " plaatsen?");
                System.out.print("Gemeente: ");
                String gemeente = sc.nextLine();

                for (Gemeente g : DataSeeder.getInstance().gemeentes) {
                    if (g.getNaam().equalsIgnoreCase(gemeente)) {
                        System.out.print("Postcode: ");
                        String postcode = sc.nextLine();
                        System.out.print("Straat: ");
                        String straat = sc.nextLine();
                        System.out.print("nummer: ");
                        int nummer = Integer.parseInt(sc.nextLine());

                        for (AZC a : g.azcs) {

                            if (a.getPostcode().equals(postcode) && a.getStraat().equals(straat) && a.getNummer() == nummer) {
                                a.getVluchtelingen().add(v);
                                DataSeeder.getInstance().getNieuweVluchtelingen().remove(v);
                                System.out.println(naam + " toegevoegd aan AZC.");
                                return;
                            }
                        }
                        System.out.println("Een AZC met dit adres staat niet geregistreerd.");
                        return;
                    }
                }
                System.out.println(gemeente + " staat niet geregistreerd als een gemeente met een AZC.");
                return;
            }
        }
        for (Gemeente g : DataSeeder.getInstance().gemeentes){
            for (AZC a : g.azcs) {
                for (Vluchteling v : a.getVluchtelingen()) {
                    if (v.getNaam().equals(naam)) {
                        voorgesteldeGemeente();
                        System.out.println("Naar welk AZC wilt u " + naam + " overplaatsen?");
                        System.out.print("Gemeente: ");
                        String gemeente = sc.nextLine();

                        for (Gemeente g2 : DataSeeder.getInstance().gemeentes) {
                            if (g2.getNaam().equalsIgnoreCase(gemeente)) {
                                System.out.print("Postcode: ");
                                String postcode = sc.nextLine();
                                System.out.print("Straat: ");
                                String straat = sc.nextLine();
                                System.out.print("nummer: ");
                                int nummer = Integer.parseInt(sc.nextLine());

                                for (AZC a2 : g2.azcs) {

                                    if (a2.getPostcode().equals(postcode) && a2.getStraat().equals(straat) && a2.getNummer() == nummer) {
                                        a2.getVluchtelingen().add(v);
                                        a.getVluchtelingen().remove(v);
                                        System.out.println(naam + " overgeplaatst.");
                                        return;
                                    }
                                }
                                System.out.println("Een AZC met dit adres staat niet geregistreerd.");
                                return;
                            }
                        }
                        System.out.println(gemeente + " staat niet geregistreerd als een gemeente met een AZC.");
                        return;
                    }
                }
            }
        }
        System.out.println(naam + " staat niet geregistreerd in de database...");
    }
}
