import javax.swing.*;

public class GUI {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Game game = new Game();
      createAndShowGUI(game);
    });
  }

  private static void createAndShowGUI(Game game) {
    JFrame frame = new JFrame("Te Reo Picture Game by Neeraj Patel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton button = new JButton("Start Game");
    button.addActionListener(e ->  game.startGame());

    button.setHorizontalAlignment(SwingConstants.CENTER);

    frame.add(button);
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }


}
