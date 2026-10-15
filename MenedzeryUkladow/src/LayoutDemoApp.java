import javax.swing.*;
import java.awt.*;

public class LayoutDemoApp extends JFrame {

    public LayoutDemoApp() {
        super("Menedżery Układów Swing - Panel Główny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 360);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel(new GridLayout(6, 1, 8, 8));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnFlow = new JButton("1. FlowLayout Demo");
        JButton btnBorder = new JButton("2. BorderLayout Demo");
        JButton btnGrid = new JButton("3. GridLayout Demo");
        JButton btnBox = new JButton("4. BoxLayout Demo");
        JButton btnCard = new JButton("5. CardLayout Demo");
        JButton btnGridBag = new JButton("6. GridBagLayout Demo");

        btnFlow.addActionListener(e -> showFlowDemo());
        btnBorder.addActionListener(e -> showBorderDemo());
        btnGrid.addActionListener(e -> showGridDemo());
        btnBox.addActionListener(e -> showBoxDemo());
        btnCard.addActionListener(e -> showCardDemo());
        btnGridBag.addActionListener(e -> showGridBagDemo());

        mainPanel.add(btnFlow);
        mainPanel.add(btnBorder);
        mainPanel.add(btnGrid);
        mainPanel.add(btnBox);
        mainPanel.add(btnCard);
        mainPanel.add(btnGridBag);

        add(mainPanel);
    }

    private JFrame createChildFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(this);
        return frame;
    }

    private void showFlowDemo() {
        JFrame frame = createChildFrame("Demo: FlowLayout", 450, 160);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));

        for (int i = 1; i <= 6; i++) {
            panel.add(new JButton("Przycisk " + i));
        }

        frame.add(new JLabel("Zmieniaj szerokość okna myszką, aby zobaczyć zawijanie wierszy:", SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void showBorderDemo() {
        JFrame frame = createChildFrame("Demo: BorderLayout", 500, 300);
        frame.setLayout(new BorderLayout(8, 8));

        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void showGridDemo() {
        JFrame frame = createChildFrame("Demo: GridLayout", 320, 350);
        JPanel gridPanel = new JPanel(new GridLayout(4, 3, 6, 6));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
                "1", "2", "3",
                "4", "5", "6",
                "7", "8", "9",
                "*", "0", "#"
        };

        for (String text : buttons) {
            gridPanel.add(new JButton(text));
        }

        frame.add(gridPanel);
        frame.setVisible(true);
    }

    private void showBoxDemo() {
        JFrame frame = createChildFrame("Demo: BoxLayout", 300, 320);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel info = new JLabel("Pionowa kolumna z odstępami:");
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(info);

        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton btn1 = new JButton("Pierwsza Akcja");
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn1);

        panel.add(Box.createVerticalGlue());

        JButton btn2 = new JButton("Druga Akcja");
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn2);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showCardDemo() {
        JFrame frame = createChildFrame("Demo: CardLayout", 420, 220);
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel step1 = new JPanel(new BorderLayout());
        step1.add(new JLabel("Krok 1: Wprowadź dane początkowe", SwingConstants.CENTER), BorderLayout.CENTER);

        JPanel step2 = new JPanel(new BorderLayout());
        step2.add(new JLabel("Krok 2: Potwierdź konfigurację", SwingConstants.CENTER), BorderLayout.CENTER);

        JPanel step3 = new JPanel(new BorderLayout());
        step3.add(new JLabel("Krok 3: Gotowe! Pomyślnie ukończono.", SwingConstants.CENTER), BorderLayout.CENTER);

        cardPanel.add(step1, "Krok 1");
        cardPanel.add(step2, "Krok 2");
        cardPanel.add(step3, "Krok 3");

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnPrev = new JButton("<< Wstecz");
        JButton btnNext = new JButton("Dalej >>");

        btnPrev.addActionListener(e -> cardLayout.previous(cardPanel));
        btnNext.addActionListener(e -> cardLayout.next(cardPanel));

        navPanel.add(btnPrev);
        navPanel.add(btnNext);

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(navPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void showGridBagDemo() {
        JFrame frame = createChildFrame("Demo: GridBagLayout", 420, 240);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Login:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        panel.add(new JTextField(15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Hasło:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        panel.add(new JPasswordField(15), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        JButton btnLogin = new JButton("Zaloguj");
        panel.add(btnLogin, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        JButton btnCancel = new JButton("Anuluj");
        btnCancel.addActionListener(e -> frame.dispose());
        panel.add(btnCancel, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LayoutDemoApp app = new LayoutDemoApp();
            app.setVisible(true);
        });
    }
}
//Różnica jest taka, że FlowLayout zmienia ułożenie przycisków, a GridLayout zmienia ich wielkość.