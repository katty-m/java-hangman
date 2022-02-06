package main.java.pl.edu.agh.hangman;

import java.util.Locale;
import java.util.Scanner;

public class GuessClass {

    public static String quess() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give one letter");
        String guess = sc.next();
        return (guess.toLowerCase());
    }
    public static void gameResult(boolean isWinner) {
        if (isWinner){
            System.out.println("Wygrałeś");
            return;
        }
        System.out.println("Przegrałeś");
        }
}


