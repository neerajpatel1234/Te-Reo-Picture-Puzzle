import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private final Game game;
    private JTextArea outputTextArea;
    private JTextField inputTextField;
    private JPanel startMenuPanel;
    private JPanel gamePanel;

    public GUI(Game game) {
        this.game = game;
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame("Te Reo Picture Game by Neeraj Patel");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create start menu panel
        startMenuPanel = createStartMenuPanel();
        frame.setContentPane(startMenuPanel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createStartMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToGamePanel();
            }
        });

        // Customize the start menu as needed
        panel.add(new JLabel("Welcome to Te Reo Māori Game"), BorderLayout.NORTH);
        panel.add(startButton, BorderLayout.CENTER);

        return panel;
    }

    private void switchToGamePanel() {
        // Create or update the game panel
        if (gamePanel == null) {
            gamePanel = createGamePanel();
        }

        // Switch to the game panel
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(startMenuPanel);
        frame.setContentPane(gamePanel);

        // Update layout manager to ensure proper sizing and positioning
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private JPanel createGamePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Add outputTextArea to the center with a JScrollPane
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add inputTextField and answerButton to the bottom with FlowLayout
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputTextField = new JTextField(20); // Set the preferred width
        inputPanel.add(inputTextField);

        JButton answerButton = new JButton("Submit Answer");
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAnswerSubmission();
            }
        });
        inputPanel.add(answerButton);

        // Add the inputPanel to the bottom of the mainPanel
        panel.add(inputPanel, BorderLayout.SOUTH);

        // Update layout manager to ensure proper sizing and positioning
        return panel;
    }

    private void handleAnswerSubmission() {
        String playerInput = inputTextField.getText();
        // Add logic to handle the player's input based on the current turn type
        // (color, word, or phrase). Use game.runTurn() or similar method.

        // Example:
        // game.runTurn();

        updateGameOutput();
    }

    private void updateGameOutput() {
        // Update the JTextArea with the current game state (score, incorrect answers, etc.)
        outputTextArea.setText(game.toString());
        // Add more logic to display the current question or other relevant information.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game currentGame = new Game();
                GUI gui = new GUI(currentGame);
            }
        });
    }
}
