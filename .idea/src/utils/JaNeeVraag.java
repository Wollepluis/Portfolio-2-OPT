package utils;

import utils.*;
import menu.*;
import model.*;

import java.util.Scanner;

public class JaNeeVraag {
    public static boolean vraag(String vraag) {
        Scanner sc = new Scanner(System.in);

        String answer = "JN";
        String choice;

        choice = "<><><><><><>";
        while (!answer.contains(choice.toUpperCase())) {
            if (!choice.equals("<><><><><><>")) {
                System.out.println("Vul een antwoord op het scherm in...");
            }
            System.out.println(vraag);
            choice = sc.nextLine();
            System.out.println();
        }
        return choice.equalsIgnoreCase("J");
    }
}
