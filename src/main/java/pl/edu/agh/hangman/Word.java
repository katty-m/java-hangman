package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Word {

    private final ArrayList<String> listOfWords = new ArrayList<>();
    private String word = "";

    public void start() {
        this.readWordList();
        this.drawWord();
    }

    private void readWordList() {
        BufferedReader bufReader;

        {
            try {
                bufReader = new BufferedReader(new FileReader("src/main/resources/slowa.txt"));
                String word = bufReader.readLine();
                while (word != null) {
                    listOfWords.add(word);
                    word = bufReader.readLine();
                }
                bufReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawWord() {
        Random rand = new Random();
        this.word = listOfWords.get(rand.nextInt(listOfWords.size()));
    }

    public boolean checkIfLetterIsInWord(String word, String letter) {
        if (word.contains(letter)) {

        }
        return false;
    }

}
