
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
  private JPanel contentPane;

  public MainFrame() {
    setFont(new Font("Bahnschrift", Font.PLAIN, 40));
    setTitle("Meal Maker");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100,1920, 1080);

    try {
      final Image backgroundImage = ImageIO.read(new File("src/Images/background.jpg"));
      contentPane = new JPanel(new BorderLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
      };
    } catch (IOException e) {
      throw new RuntimeException("Image not found: src/Images/background.jpg", e);
    }


    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    // Add buttons
    JButton findButton = new JButton("Find Meals");
    findButton.setFont(new Font("Bahnschrift", Font.BOLD, 21));
    findButton.setBounds(150, 300, 300, 100);
    contentPane.add(findButton);

    JButton configButton = new JButton("Configure Ingredients");
    configButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
    configButton.setBounds(500, 300, 300, 100);
    contentPane.add(configButton);

    JButton settingsButton = new JButton("User Settings");
    settingsButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
    settingsButton.setBounds(150, 450, 300, 100);
    contentPane.add(settingsButton);

    JButton instructButton = new JButton("Instructions");
    instructButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
    instructButton.setBounds(500, 450, 300, 100);
    contentPane.add(instructButton);

    JButton exitButton = new JButton("Exit Application");
    exitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
    exitButton.setBounds(325, 600, 300, 100);
    contentPane.add(exitButton);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }


        // JRadioButton create_rb = new JRadioButton("Create Tables");
        // create_rb.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        // create_rb.setBounds(288, 139, 111, 23);
        // contentPane.add(create_rb);

        // JRadioButton query_rb = new JRadioButton("Query Tables");
        // query_rb.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        // query_rb.setBounds(288, 184, 111, 23);
        // contentPane.add(query_rb);

        // JButton ok_bt = new JButton("OK");
        // ok_bt.setFont(new Font("Tahoma", Font.PLAIN, 17));

}
