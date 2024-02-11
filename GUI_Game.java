import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * GUI_Game.java
 * This class is the main class for the GUI of the game. It will be responsible for
 * creating the GUI and handling the user input.
 */
public class GUI_Game {
    // --------------------------- Instance Variables ---------------------------
    private List<Word> wordsList;
    private List<Phrase> phrasesList;
    private List<Colour> coloursList;
    enum gameType {WORDS, PHRASES, COLOURS }
    gameType gameType;

    private int score;
    private int incorrectAnswers;

    JFrame frame = new JFrame("Te Reo Picture Game");
    JPanel panel = new JPanel();


    // ------------------------------- Constructor -------------------------------
    /**
     * Constructor for the GUI_Game class
     */
    public GUI_Game() {
        setupGame();
    }

    private void setupGame() {
        // ---- Initialise the lists and variables ----
        wordsList = new ArrayList<>();
        phrasesList = new ArrayList<>();
        coloursList = new ArrayList<>();
        score = 0;
        incorrectAnswers = 0;

        // ---- Setup the words, phrases and colours ----
        setupWords();
        setupPhrases();
        setupColours();

        // ---- Start the game ----
        startGame();
    }

    public void startGame() {
        // ---- Ask the user to select a game type ----
        gameType = getGameType();
        drawGrid();
        //runTurn(gameType);
    }

    private void runTurn(gameType gameType) {
        while (incorrectAnswers < 3) {
            if (gameType == gameType.WORDS) {
                runWordTurn();
            } else if (gameType == gameType.PHRASES) {
                runPhraseTurn();
            } else if (gameType == gameType.COLOURS) {
                runColourTurn();
            }
        }

        // ---- Game over ----
        JOptionPane.showMessageDialog(null, "Game Over! Your final score is: " + score);
        JOptionPane.showMessageDialog(null, "Thank you for playing the Te Reo Picture Game!");
        System.exit(0);
    }

    private void runColourTurn() {
    }

    private void runPhraseTurn() {
    }

    private void runWordTurn() {
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int numberOfCards = gameType == gameType.WORDS ? wordsList.size() : gameType == gameType.PHRASES ? phrasesList.size() : coloursList.size();
        for (int i = 0; i < numberOfCards; i++) {
            JButton button = new JButton("Card " + i);
            button.setAlignmentX(JButton.CENTER_ALIGNMENT);
            panel.add(button);
        }
        frame.add(panel);



    }
    
    private void redrawGrid() {
        panel.removeAll();
        int numberOfCards = gameType == gameType.WORDS ? wordsList.size() : gameType == gameType.PHRASES ? phrasesList.size() : coloursList.size();
        for (int i = 0; i < numberOfCards; i++) {
            JButton button = new JButton("Card " + i);
            button.setAlignmentX(JButton.CENTER_ALIGNMENT);
            panel.add(button);
        }
        frame.add(panel);
    }



}

