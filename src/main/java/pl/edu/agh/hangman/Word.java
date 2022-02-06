package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Word {

    private final ArrayList<String> listOfWords = new ArrayList<>();
    private String word = "";
    private List<String> letters = new ArrayList<>();
    private List<String> lettersToPrint = new ArrayList<>();
    private String wordPrint = "";
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
        this.word = listOfWords.get(rand.nextInt(listOfWords.size())).toLowerCase();
        this.wordPrint = word.replaceAll("\\S", "_");
        for(int i=0; i < word.length(); i++){
            letters.add(String.valueOf(word.charAt(i)));
            lettersToPrint.add(String.valueOf(wordPrint.charAt(i)));
        }
    }

    public boolean checkIfLetterIsInWord(String letter) {
        //String letterLower = letter.toLowerCase();




        for(int i=0; i < letters.size(); i++){
            if(letters.get(i).equals(letter)){
                letters.remove(i);
                lettersToPrint.set(i,letter);
            }
        }

//        if (word.contains(letter)) {
//            word = word.replaceAll(letter, "_");
//            //wordPrint = wordPrint.replaceAll("_", letter);
//            this.printWord();
//            return true;
//        }
        this.printWord();
        return false;
    }

    public void printWord() {
        for (int i = 0; i < lettersToPrint.size(); i++) {
            System.out.print(lettersToPrint.get(i));
        }
        System.out.println();
    }

    public boolean isComplete(){
        return letters.isEmpty();
    }
}
