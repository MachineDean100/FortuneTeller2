import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private Random random;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredFrameSize());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initializeFortunes();
        random = new Random();

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();
    }

    private Dimension getPreferredFrameSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height * 3 / 4;
        return new Dimension(width, height);
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will find a bushel of money.");
        fortunes.add("Today is a good day to learn something new.");
        fortunes.add("Your smile will tell you what makes you feel good.");
        fortunes.add("A dream you have will come true.");
        fortunes.add("You will meet someone special soon.");
        fortunes.add("Adventure can be real happiness.");
        fortunes.add("The early bird gets the worm, but the second mouse gets the cheese.");
        fortunes.add("Hard work pays off in the future, laziness pays off now.");
        fortunes.add("If you look back, you’ll soon be going that way.");
        fortunes.add("You will become great if you believe in yourself.");
        fortunes.add("Your ability for accomplishment will follow with success.");
        fortunes.add("Nothing astonishes men so much as common sense and plain dealing.");
    }

    private void createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("fortune_teller2.png");
        Image image = icon.getImage();
        int imgWidth = getPreferredFrameSize().width / 4;
        int imgHeight = imgWidth * icon.getIconHeight() / icon.getIconWidth();
        Image scaledImage = image.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        titleLabel = new JLabel("Fortune Teller", scaledIcon, JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.setPreferredSize(new Dimension(getPreferredFrameSize().width, imgHeight + 80));
        add(topPanel, BorderLayout.NORTH);
    }

    private void createMiddlePanel() {
        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
        fortuneArea.setLineWrap(true);
        fortuneArea.setWrapStyleWord(true);
        fortuneArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout());

        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        readFortuneButton.addActionListener((ActionEvent e) -> displayFortune());

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        bottomPanel.setPreferredSize(new Dimension(getPreferredFrameSize().width, 80));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void displayFortune() {
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex && fortunes.size() > 1);

        String fortune = fortunes.get(index);
        fortuneArea.append(fortune + "\n");
        lastFortuneIndex = index;
    }
}
