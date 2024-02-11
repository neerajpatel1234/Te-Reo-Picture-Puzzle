import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * GUI_Game.java
 *
 * This class is the main class for the GUI of the game. It will be responsible for
 * creating the GUI and handling the user input.
 */
public class GUI_Game {
    // --------------------------- Instance Variables ---------------------------
    private List<Word> wordsList;
    private List<Phrase> phrasesList;
    private List<Colour> coloursList;
    private int score;
    private int incorrectAnswers;





    // ------------------------------- Constructor -------------------------------
    public GUI_Game() {
        setupGame();
    }



    public void startGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    private void setupGame() {
        wordsList = new ArrayList<>();
        phrasesList = new ArrayList<>();
        coloursList = new ArrayList<>();
        score = 0;
        incorrectAnswers = 0;
        setupWords();
        setupPhrases();
        setupColours();
    }

    private void setupPhrases() {
        phrasesList = new ArrayList<>();
        phrasesList.add(new Phrase("Kia ora", "Hello"));
        phrasesList.add(new Phrase("Kei te pēhea koe?", "How are you?"));
        phrasesList.add(new Phrase("Ko wai tō ingoa?", "What is your name?"));
        phrasesList.add(new Phrase("Kei te pai", "Good"));
        phrasesList.add(new Phrase("Kei te kino", "Bad"));
        phrasesList.add(new Phrase("Kei te mahi", "Work"));
        phrasesList.add(new Phrase("Kei te kai", "Eat"));
        phrasesList.add(new Phrase("Kei te moe", "Sleep"));
        phrasesList.add(new Phrase("Kei te haere", "Go"));
        phrasesList.add(new Phrase("Kei te noho", "Sit"));
        phrasesList.add(new Phrase("Kei te tū", "Stand"));
    }

    public void setupWords() {
        wordsList = new ArrayList<>();
        wordsList.add(new Word("Tahi", "One"));
        wordsList.add(new Word("Rua" , "Two"));
        wordsList.add(new Word("Toru", "Three"));
        wordsList.add(new Word("Wha", "Four"));
        wordsList.add(new Word("Rima", "Five"));
        wordsList.add(new Word("Ono", "Six"));
        wordsList.add(new Word("Whitu", "Seven"));
        wordsList.add(new Word("Waru", "Eight"));
        wordsList.add(new Word("Iwa", "Nine"));
        wordsList.add(new Word("Tekau", "Ten"));
    }

    public void setupColours() {
        coloursList = new ArrayList<>();
        coloursList.add(new Colour("Mā", "White"));
        coloursList.add(new Colour("Mangu", "Black"));
        coloursList.add(new Colour("Whero", "Red"));
        coloursList.add(new Colour("Karaka", "Orange"));
        coloursList.add(new Colour("Kākāriki", "Green"));
        coloursList.add(new Colour("Kikorangi", "Blue"));
    }

    private void drawGrid() {
        throw new UnsupportedOperationException("Not supported yet.");
    }




}

