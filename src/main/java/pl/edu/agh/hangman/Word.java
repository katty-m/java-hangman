package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {

    private final ArrayList<String> listOfWords = new ArrayList<>();
    private List<String> letters = new ArrayList<>();
    private List<String> lettersToPrint = new ArrayList<>();
    int counter = 0;

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
        String word = listOfWords.get(rand.nextInt(listOfWords.size())).toLowerCase();
        String wordPrint = word.replaceAll("\\S", "_");
        for (int i = 0; i < word.length(); i++) {
            letters.add(String.valueOf(word.charAt(i)));
            lettersToPrint.add(String.valueOf(wordPrint.charAt(i)));
        }
    }

    public boolean checkIfLetterIsInWord(String letter) {

        if (letters.contains(letter)) {
            for (int i = 0; i < lettersToPrint.size(); i++) {
                if (letters.get(i).equals(letter)) {
                    lettersToPrint.set(i, letter);
                    counter++;
                }
            }
            return true;
        }
        return false;
    }

    public void printWord() {
        for (String s : lettersToPrint) {
            System.out.print(s);
        }
        System.out.println();
    }

    public void printFinalWord() {
        for (String s : letters) {
            System.out.print(s);
        }
        System.out.println();
    }

    public boolean isComplete() {
        return counter == letters.stream().filter(l -> !l.isBlank()).count();
    }
}
