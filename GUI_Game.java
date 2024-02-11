import javax.swing.*;
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
    enum gameType {WORDS, PHRASES, COLOURS }

    private int score;
    private int incorrectAnswers;


    // ------------------------------- Constructor -------------------------------
    /**
     * Constructor for the GUI_Game class
     */
    public GUI_Game() {
        setupGame();
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
        startGame();
    }

    public void startGame() {
        // ---- Ask the user to select a game type ----
        gameType gameType = getGameType();

        // ---- Create the GUI ----
        JFrame frame = new JFrame("Te Reo Picture Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // ---- Create the buttons ----
        JButton button1 = new JButton("Start Game");
        JButton button2 = new JButton("Exit Game");
        button1.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button2.setAlignmentX(JButton.CENTER_ALIGNMENT);

        // ---- Add action listeners to the buttons ----
        button1.addActionListener(e -> startGame());
        button2.addActionListener(e -> System.exit(0));

        frame.add(button1);
        frame.add(button2);

        // ---- Set the frame size and location ------
        frame.setSize(250, 90);
        frame.setLocationRelativeTo(null);



    }

    private gameType getGameType() {
        String[] options = {"Words", "Phrases", "Colours"};
        int choice = JOptionPane.showOptionDialog(null, "Please select a game type", "Game Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      return switch (choice) {
        case 0 -> gameType.WORDS;
        case 1 -> gameType.PHRASES;
        case 2 -> gameType.COLOURS;
        default -> throw new IllegalArgumentException("Invalid game type selected");
      };
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

    }



}

