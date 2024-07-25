import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import classes.*;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private static String ingredientsText;
    private static String dietaryRestrictionsValue;
    private static int timeFrameValue;

    public MainFrame() {
        setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        setTitle("Meal Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 1080);

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

        initMainMenu();
    }

    private void initMainMenu() {
        contentPane.removeAll();
        contentPane.setLayout(null);
    
        // Set border color
        Color borderColor = Color.BLACK;
        Color backgroundColor = Color.WHITE;
    
        JLabel titleLabel = new JLabel("Welcome to Meal Maker");
        titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        titleLabel.setBounds(150, 50, 1000, 100);
        titleLabel.setBackground(backgroundColor);
        contentPane.add(titleLabel);
    
        JButton findButton = new JButton("Find Meals");
        findButton.setFont(new Font("Bahnschrift", Font.BOLD, 21));
        findButton.setBounds(150, 300, 300, 100);
        findButton.setBorder(new LineBorder(borderColor, 1));
        findButton.setOpaque(true);
        findButton.setBackground(backgroundColor);
        contentPane.add(findButton);
    
        JButton configButton = new JButton("Configure Ingredients");
        configButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        configButton.setBounds(500, 300, 300, 100);
        configButton.setBorder(new LineBorder(borderColor, 1));
        configButton.setOpaque(true);
        configButton.setBackground(backgroundColor);
        contentPane.add(configButton);
    
        JButton settingsButton = new JButton("User Settings");
        settingsButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        settingsButton.setBounds(150, 450, 300, 100);
        settingsButton.setBorder(new LineBorder(borderColor, 1));
        settingsButton.setOpaque(true);
        settingsButton.setBackground(backgroundColor);
        contentPane.add(settingsButton);
    
        JButton instructButton = new JButton("Instructions");
        instructButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        instructButton.setBounds(500, 450, 300, 100);
        instructButton.setBorder(new LineBorder(borderColor, 1));
        instructButton.setOpaque(true);
        instructButton.setBackground(backgroundColor);
        contentPane.add(instructButton);
    
        JButton exitButton = new JButton("Exit Application");
        exitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        exitButton.setBounds(325, 600, 300, 100);
        exitButton.setBorder(new LineBorder(borderColor, 1));
        exitButton.setOpaque(true);
        exitButton.setBackground(backgroundColor);
        exitButton.addActionListener(e -> System.exit(0));
        contentPane.add(exitButton);
    
        configButton.addActionListener(e -> configureIngredients());
        settingsButton.addActionListener(e -> userSettings());
        instructButton.addActionListener(e -> showInstructions());

        contentPane.revalidate();
        contentPane.repaint();
    }

    private void configureIngredients() {
        contentPane.removeAll();
        contentPane.setLayout(null);
    
        // Set border color
        Color borderColor = Color.BLACK;
        Color backgroundColor = Color.WHITE;
    
        JLabel enterIngredientsLabel = new JLabel("Enter Ingredients:");
        enterIngredientsLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        enterIngredientsLabel.setBounds(150, 100, 300, 50);
        contentPane.add(enterIngredientsLabel);
    
        JTextArea ingredientsTextArea = new JTextArea();
        ingredientsTextArea.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        ingredientsTextArea.setLineWrap(true);
        ingredientsTextArea.setWrapStyleWord(true);
        ingredientsTextArea.setBorder(new LineBorder(borderColor, 1));
        ingredientsTextArea.setOpaque(true);
        ingredientsTextArea.setBackground(backgroundColor);
    
        JScrollPane scrollPane = new JScrollPane(ingredientsTextArea);
        scrollPane.setBounds(450, 100, 700, 300);
        scrollPane.setBorder(new LineBorder(borderColor, 1));
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(true);
        scrollPane.setBackground(backgroundColor);
        contentPane.add(scrollPane);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        saveButton.setBounds(600, 450, 300, 100);
        saveButton.setBorder(new LineBorder(borderColor, 1));
        saveButton.setOpaque(true);
        saveButton.setBackground(backgroundColor);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientsText = ingredientsTextArea.getText();
                System.out.println(ingredientsText);
            }
        });
        contentPane.add(saveButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        backButton.setBounds(600, 600, 300, 100);
        backButton.setBorder(new LineBorder(borderColor, 1));
        backButton.setOpaque(true);
        backButton.setBackground(backgroundColor);
        backButton.addActionListener(e -> initMainMenu());
        contentPane.add(backButton);
    
        contentPane.revalidate();
        contentPane.repaint();
    }

    private void userSettings() {
        contentPane.removeAll();
        contentPane.setLayout(null);

        // Set border color
        Color borderColor = Color.BLACK;
        Color backgroundColor = Color.WHITE;

        JLabel dietaryRestrictionsLabel = new JLabel("Dietary Restrictions:");
        dietaryRestrictionsLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        dietaryRestrictionsLabel.setBounds(150, 100, 600, 50);
        contentPane.add(dietaryRestrictionsLabel);

        JComboBox<String> dietaryRestrictionsDropdown = new JComboBox<>();
        dietaryRestrictionsDropdown.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        dietaryRestrictionsDropdown.setBounds(500, 100, 300, 50);
        dietaryRestrictionsDropdown.setBorder(new LineBorder(borderColor, 1));
        dietaryRestrictionsDropdown.setOpaque(true);
        dietaryRestrictionsDropdown.setBackground(backgroundColor);
        contentPane.add(dietaryRestrictionsDropdown);

        JLabel timeframeLabel = new JLabel("Timeframe (Minutes):");
        timeframeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        timeframeLabel.setBounds(150, 200, 600, 50);
        contentPane.add(timeframeLabel);

        JTextField timeframeTextField = new JTextField();
        timeframeTextField.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        timeframeTextField.setBounds(500, 200, 300, 50);
        timeframeTextField.setBorder(new LineBorder(borderColor, 1));
        timeframeTextField.setOpaque(true);
        timeframeTextField.setBackground(backgroundColor);
        contentPane.add(timeframeTextField);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        saveButton.setBounds(600, 450, 300, 100);
        saveButton.setBorder(new LineBorder(borderColor, 1));
        saveButton.setOpaque(true);
        saveButton.setBackground(backgroundColor);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dietaryRestrictionsValue = (String) dietaryRestrictionsDropdown.getSelectedItem();
                timeFrameValue = Integer.parseInt(timeframeTextField.getText());
                System.out.println(timeFrameValue);
            }
        });
        contentPane.add(saveButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        backButton.setBounds(600, 600, 300, 100);
        backButton.setBorder(new LineBorder(borderColor, 1));
        backButton.setOpaque(true);
        backButton.setBackground(backgroundColor);
        backButton.addActionListener(e -> initMainMenu());
        contentPane.add(backButton);

        contentPane.revalidate();
        contentPane.repaint();
    }

    private void showInstructions() {
        contentPane.removeAll();
        contentPane.setLayout(null);
        Color borderColor = Color.BLACK;
        Color backgroundColor = Color.WHITE;
    
        JLabel instructionsLabel = new JLabel("<html>" +
                                            "<div style='width: 1000px;'>" +
                                            "1. Go into the User Settings and set the dietary restrictions and the timeframe available in minutes to make the meal, then save the settings.<br><br>" +
                                            "2. Type in the ingredients separated by commas with no spaces between the comma and the name of the ingredient, then click Save for the ingredients.<br><br>" +
                                            "3. Finally, click Find Meals for your results." +
                                            "</div>" +
                                            "</html>");
        instructionsLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 21));

        JScrollPane scrollPane = new JScrollPane(instructionsLabel);
        scrollPane.setBounds(150, 100, 1200, 400); // Adjust bounds to fit in the content pane
        scrollPane.setBorder(new LineBorder(borderColor, 1));

        contentPane.add(scrollPane);
    
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
        backButton.setBounds(600, 600, 300, 100);
        backButton.setBorder(new LineBorder(borderColor, 1));
        backButton.setOpaque(true);
        backButton.setBackground(backgroundColor);
        backButton.addActionListener(e -> initMainMenu());
        contentPane.add(backButton);
    
        contentPane.revalidate();
        contentPane.repaint();
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
}
