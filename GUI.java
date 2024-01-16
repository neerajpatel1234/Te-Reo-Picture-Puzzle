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
    private JLabel centerLabel;

    /**
     * Create a new GUI for the given game
     * @param game - the game to create a GUI
     */
    public GUI(Game game) {
        this.game = game;
        initialize();
    }

    /**
     * Initialize the GUI
     */
    private void initialize() {
        JFrame frame = new JFrame("Te Reo Picture Game by Neeraj Patel");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create start menu panel
        startMenuPanel = createStartMenuPanel();
        frame.setContentPane(startMenuPanel);

        // Create central JLabel for displaying text in the center
        centerLabel = new JLabel();
        centerLabel.setHorizontalAlignment(JLabel.CENTER); // Center-align the text


        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    /**
     * Create the start menu panel
     * @return the start menu panel
     */
    private JPanel createStartMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Add GUI button to the left --------------------
        JButton guiButton = new JButton("Start GUI Game");
        guiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToGamePanel();
            }
        });
        guiButton.setPreferredSize(new Dimension(200, 50));
        guiButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        guiButton.setForeground(Color.decode("#315FF5"));

        // Add text button to the right ------------------
        JButton textButton = new JButton("Start CMD Game");
        textButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame(game);
            }
        });

        textButton.setPreferredSize(new Dimension(200, 50));
        textButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textButton.setForeground(Color.decode("#4231F5"));



        panel.add(guiButton, BorderLayout.WEST);
        panel.add(textButton, BorderLayout.EAST);
        return panel;
    }

    /**
     * Switch to the game panel
     */
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
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Handle the player's answer submission
     */
    private void handleAnswerSubmission() {
        String playerInput = inputTextField.getText();
        // Process the player input as needed


        // Update the game output after processing the answer
        updateGameOutput();
    }

    /**
     * Update the game output
     */
    private void updateGameOutput() {
        outputTextArea.setText(game.toString());

        // Add more logic to display the current question or other relevant information.

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

        return panel;
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
