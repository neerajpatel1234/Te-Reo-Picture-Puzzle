import java.util.*;

/**
 * Game.java
 * This class is the main class for the game. It will start the game.
 * @version 1.0
 */
public class Game {
    // ---------------------------------------------- CONSTANTS ---------------------------------------------- //
    static int score = 0;
    static int incorrectAnswers = 0;
    static boolean gameRunning = true;

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

    /**
     * This method will start the game.
     */
    public static void startGame() {
        System.out.println("--------- Welcome to the Te Reo Māori game! --------- \n");
        incorrectAnswers = 0;
        score = 0;

        while (gameRunning) {
            runTurn();
            if (incorrectAnswers >= 3) {
                gameRunning = false;
            }
        }

        System.out.println("-------------------- !GAME OVER! --------------------");
        System.out.println("          Final Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
    }

    // ---------------------------------------------- RUN TURN METHOD ---------------------------------------------- //
    /**
     * This method will run a turn for the game.
     */
    public static void runTurn() {
        int randomNum = (int) (Math.random() * 3);
        switch (randomNum) {
            case 0 -> runColourTurn();
            case 1 -> runWordTurn();
            case 2 -> runPhraseTurn();
            default -> throw new IllegalArgumentException("Invalid random number generated");
        }
    }

    // ---------------------------------------------- RUN COLOUR METHOD ---------------------------------------------- //
    /**
     * This method will run the colour turn for the game.
     */
    private static void runColourTurn() {
        // ----- Print Te Reo Colour ----- //
        Colour ansColour = null;
        while (ansColour == null) {
            int randNum = getRandNum(coloursList.size());
            ansColour = coloursList.get(coloursList.keySet().toArray()[randNum]);
            if (used.contains(ansColour.name())) {
                ansColour = null;
            }
        }
        used.add(ansColour.name());
        System.out.println("What is the English translation of: " + ansColour.name() + "? ");

        // ----- Get & Check player input ----- //
        String playerInput = getPlayerInput();

        if (playerInput.equals(ansColour.englishName().toUpperCase())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + ansColour.englishName());
            incorrectAnswers++;
        }

        // ----- Print score ----- //
        System.out.println("    Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
        System.out.println("---------------------------------------------------- \n");
    }

    // ---------------------------------------------- RUN WORD METHOD ---------------------------------------------- //
    /**
     * This method will run the word turn for the game.
     */
    private static void runWordTurn() {
        // ----- Print Te Reo Word ----- //
        Word ansWord = null;
        while (ansWord == null) {
            int randNum = getRandNum(wordsList.size());
            ansWord = wordsList.get(randNum);
            if (used.contains(ansWord.name())) {
                ansWord = null;
            }
        }
        used.add(ansWord.name());
        System.out.println("What is the English translation of: " + ansWord.name() + "? ");

        // ----- Get & Check player input ----- //
        String playerInput = getPlayerInput();

        if (playerInput.equals(ansWord.definition().toUpperCase())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + ansWord.definition());
            incorrectAnswers++;
        }

        // ----- Print score ----- //
        System.out.println("    Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
        System.out.println("---------------------------------------------------- \n");
    }

    // ---------------------------------------------- RUN PHRASE METHOD ---------------------------------------------- //
    /**
     * This method will run the phrase turn for the game.
     */
    private static void runPhraseTurn() {
        // ----- Print Te Reo Phrase ----- //
        Phrase ansPhrase = null;
        while (ansPhrase == null) {
            int randNum = getRandNum(phrasesList.size());
            ansPhrase = phrasesList.get(randNum);
            if (used.contains(ansPhrase.phrase())) {
                ansPhrase = null;
            }
        }
        used.add(ansPhrase.phrase());
        System.out.println("What is the English translation of: " + ansPhrase.phrase() + "? ");

        // ----- Get & Check player input ----- //
        String playerInput = getPlayerInput();

        if (playerInput.equals(ansPhrase.englishPhrase().toUpperCase())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + ansPhrase.englishPhrase());
            incorrectAnswers++;
        }

        // ----- Print score ----- //
        System.out.println("    Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
        System.out.println("---------------------------------------------------- \n");
    }



    // ---------------------------------------------- HELPER METHODS ---------------------------------------------- //

    /**
     * This method will get a random number.
     * @param size The size of the list.
     * @return The random number.
     */
    static int getRandNum(int size) {
        return (int) (Math.random() * size);
    }


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


    // ---------------------------------------------- GETTERS ---------------------------------------------- //

    public String toString() {
        return "Score: " + score + "\nIncorrect Answers: " + incorrectAnswers;
    }

}

