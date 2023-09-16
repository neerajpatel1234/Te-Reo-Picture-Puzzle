import javax.lang.model.element.NestingKind;
import java.util.*;

/**
 * Game.java
 * This class is the main class for the game. It will start the game.
 * @version 1.0
 */
public class Game {
    // ---------------------------------------------- CONSTANTS ---------------------------------------------- //
    static boolean gameRunning = true;
    static int score = 0;
    static int incorrectAnswers = 0;

    static ArrayList<Phrase> phrasesList = new ArrayList<>();
    static ArrayList<Word> wordsList = new ArrayList<>();
    static HashMap<String, Colour> coloursList = new HashMap<>();

    static HashSet<String> used = new HashSet<>();

    // ---------------------------------------------- MAIN METHOD ---------------------------------------------- //
    /**
     * This method will start the game text version.
     */
    public static void main(String[] args) {
        gameRunning = true;
        setupPhrases();
        setupWords();
        setupColours();
        startGame();
    }

    // ---------------------------------------------- METHODS ---------------------------------------------- //
    /**
     * This method will start the game.
     */
    public static void startGame() {
        System.out.println("--------- Welcome to the Te Reo Māori game! ---------");
        incorrectAnswers = 0;
        score = 0;
        while (gameRunning) {
            runTurn();
        }

    }

    /**
     * This method will run a turn for the game.
     */
    public static void runTurn() {
        int randomNum = (int) (Math.random() * 3);
        switch (randomNum) {
            case 0 -> runColourTurn();
            //case 1 -> runWordTurn();
            //case 2 -> runPhraseTurn();
            default -> throw new IllegalArgumentException("Invalid random number generated");
        }
    }

    /**
     * This method will run the colour turn for the game.
     */
    private static void runColourTurn() {
        // ----- Print Te Reo Colour ----- //
        System.out.println("What is the English translation of: ");
        String colourName = getNameFromList(new ArrayList<>(coloursList.values()));
        System.out.print(colourName + "\n");

        // ----- Validate user input ----- //
        String userInput = getPlayerInput();
        userInput = userInput.toUpperCase();
        colourName = colourName.toUpperCase();

        if (userInput.equals(colourName)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
            System.out.println("The correct answer was: " + colourName);
            incorrectAnswers++;
        }

        // ----- Print score ----- //
        System.out.println("    Score: " + score + "\nIncorrect Answers: " + incorrectAnswers);
        System.out.println("----------------------------------------------------");
    }


    /**
     * This method will get a random name from a list.
     * @param list The list to get the name from.
     * @return The name from the list.

    private static String getNameFromList(ArrayList<?> list) {
        if (list.get(0) instanceof Phrase) {
            while (true) {
                int randNum = getRandNum(list.size());
                Phrase phrase = (Phrase) list.get(randNum);
                String phraseName = phrase.phrase().toUpperCase();
                if (!used.contains(phraseName)) {
                    used.add(phraseName);
                    return phraseName;
                }
            }
        } else if (list.get(0) instanceof Word) {
            while (true) {
                int randNum = getRandNum(list.size());
                Word word = (Word) list.get(randNum);
                String wordName = word.name().toUpperCase();
                if (!used.contains(wordName)) {
                    used.add(wordName);
                    return wordName;
                }
            }
        } else if (list.get(0) instanceof Colour) {
            while (true) {
                int randNum = getRandNum(list.size());
                Colour colour = (Colour) list.get(randNum);
                String colourName = colour.name().toUpperCase();
                if (!used.contains(colourName)) {
                    used.add(colourName);
                    return colourName;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid list type");
        }
    }
     */


    /**
     * This method will get the player input.
     * @return The player input via the console.
     */
    public static String getPlayerInput() {
        String input = "";
        while (input.isEmpty()) {
            if (System.console() != null) {
                input = System.console().readLine();
            } else {
                System.out.println("No console available. Please provide input:");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
            }
        }
        return input.toUpperCase();
    }

    // ---------------------------------------------- SETUP TE REO OBJECTS ---------------------------------------------- //
    /**
     * This method will set up the phrases for the game.
     */
    public static void setupPhrases() {
        phrasesList = new ArrayList<>();
        phrasesList.add(new Phrase("Kia ora", "Hello"));
        phrasesList.add(new Phrase("Kei te pēhea koe?", "How are you?"));
        phrasesList.add(new Phrase("Kei te pai ahau", "I am good"));
        phrasesList.add(new Phrase("Nō hea koe?", "Where are you from?"));
        phrasesList.add(new Phrase("Nō Ingarangi ahau", "I am from England"));
        phrasesList.add(new Phrase("Ko wai tō ingoa?", "What is your name?"));
        phrasesList.add(new Phrase("Ko Jack tōku ingoa", "My name is Jack"));
        phrasesList.add(new Phrase("Ka kite anō", "See you later"));
        phrasesList.add(new Phrase("Ka kite", "Goodbye"));
        phrasesList.add(new Phrase("Ka kite anō", "See you later"));
    }

    /**
     * This method will set up the words for the game.
     */
    public static void setupWords(){
        wordsList = new ArrayList<>();
        wordsList.add(new Word("Tahi" , "One"));
        wordsList.add(new Word("Rua" , "Two"));
        wordsList.add(new Word("Toru" , "Three"));
        wordsList.add(new Word("Whā" , "Four"));
        wordsList.add(new Word("Rima" , "Five"));
        wordsList.add(new Word("Ono" , "Six"));
        wordsList.add(new Word("Whitu" , "Seven"));
        wordsList.add(new Word("Waru" , "Eight"));
        wordsList.add(new Word("Iwa" , "Nine"));
        wordsList.add(new Word("Tekau" , "Ten"));
        wordsList.add(new Word("Kotahi tekau" , "Eleven"));
        wordsList.add(new Word("Rua tekau" , "Twenty"));
        wordsList.add(new Word("Tahi rau" , "One hundred"));
    }

    /**
     * This method will set up the colours for the game.
     */
    public static void setupColours() {
        coloursList = new HashMap<>();
        coloursList.put("Whero", new Colour("Whero", "Red"));
        coloursList.put("Karaka", new Colour("Karaka", "Orange"));
        coloursList.put("Kākāriki", new Colour("Kākāriki", "Green"));
        coloursList.put("Kikorangi", new Colour("Kikorangi", "Blue"));
        coloursList.put("Tūāuri", new Colour("Tūāuri", "Brown"));
        coloursList.put("Mā", new Colour("Mā", "White"));
        coloursList.put("Mangu", new Colour("Mangu", "Black"));
        coloursList.put("Pango", new Colour("Pango", "Black"));
        coloursList.put("Parauri", new Colour("Parauri", "Grey"));
        coloursList.put("Kōwhai", new Colour("Kōwhai", "Yellow"));
    }

    // ---------------------------------------------- SETTERS ---------------------------------------------- //
    public void setScore(int score) {
        this.score = score;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setPhrasesList(ArrayList<Phrase> phrasesList) {
        this.phrasesList = phrasesList;
    }

    public void setWordsList(ArrayList<Word> wordsList) {
        this.wordsList = wordsList;
    }

    public void setColoursList(HashMap<String, Colour> coloursList) {
        this.coloursList = coloursList;
    }


    // ---------------------------------------------- GETTERS ---------------------------------------------- //

    public int getScore() {
        return score;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public String toString() {
        return "Score: " + score + "\nIncorrect Answers: " + incorrectAnswers;
    }

    public ArrayList<Phrase> getPhrasesList() {
        return phrasesList;
    }

    public ArrayList<Word> getWordsList() {
        return wordsList;
    }

    public HashMap<String, Colour> getColoursList() {
        return coloursList;
    }

    public static int getRandNum(int max) {
        return (int) (Math.random() * max);
    }


}
