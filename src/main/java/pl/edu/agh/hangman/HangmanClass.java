package pl.edu.agh.hangman;

import static pl.edu.agh.hangman.Hangman.HANGMANPICS;

public class HangmanClass {

    public int i = 0;

    public void printHangman(){
        System.out.println(HANGMANPICS[i]);
        i++;
    }

}
