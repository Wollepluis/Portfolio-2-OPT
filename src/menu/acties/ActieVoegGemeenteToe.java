package menu.acties;

import utils.*;

import java.util.Scanner;

public class ActieVoegGemeenteToe implements IActie{
    @Override
    public void voerActieUit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welke gemeente wil je toevoegen?: ");
        String naam = sc.nextLine();
        System.out.print("Hoeveel inwoners heeft " + naam + "?: ");
        int aantalInwoners = Integer.parseInt(sc.nextLine());
        DataSeeder.getInstance().voegGemeenteToe(naam, aantalInwoners);
        System.out.println("Gemeente succesvol toegevoegd.");
    }
}
