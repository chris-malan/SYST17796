package malanc.realestateapp.UserPage;

import javax.swing.*;
import java.awt.*;
import malanc.realestateapp.LogInPrompt.LogIn;
import malanc.realestateapp.Action.Owner.AddPendingProperty;
import malanc.realestateapp.Action.Shared.DisplayProperties;
import malanc.realestateapp.Models.User;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.Action.Shared.AppointmentBooking;

public class OwnerPage {

    public static void displayOwnerOptions(User currentUser) {
        // Create main frame
        JFrame frame = new JFrame("Owner Menu");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Owner Options");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titlePanel.add(titleLabel);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns with spacing
        buttonPanel.setBackground(new Color(240, 240, 240)); // Light gray background

        // Buttons
        JButton addPropertyButton = createGradientButton("Add Property");
        JButton viewAllPropertiesButton = createGradientButton("View All Properties");
        JButton bookAppointmentButton = createGradientButton("Book Appointment");
        JButton logOutButton = createGradientButton("Log Out");
        JButton exitButton = createGradientButton("Exit");

        // Action Listeners
        addPropertyButton.addActionListener(e -> AddPendingProperty.addPendingProperty(currentUser));
        viewAllPropertiesButton.addActionListener(e -> DisplayProperties.displayAllProperties(UserRole.OWNER));
        bookAppointmentButton.addActionListener(e -> AppointmentBooking.bookAppointment(currentUser.getUsername()));
        logOutButton.addActionListener(e -> {
            frame.dispose(); // Close the OwnerPage window
            LogIn.startLogin(); // Show login screen
        });
        exitButton.addActionListener(e -> System.exit(0));

        // Add buttons to panel
        buttonPanel.add(addPropertyButton);
        buttonPanel.add(viewAllPropertiesButton);
        buttonPanel.add(bookAppointmentButton);
        buttonPanel.add(logOutButton);
        buttonPanel.add(exitButton);

        // Add panels to frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Adjust frame settings
        frame.setSize(500, 300); // Width, Height
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }

    private static JButton createGradientButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (isOpaque()) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    // Gradient paint for the button background
                    GradientPaint gradient = new GradientPaint(0, 0, new Color(225, 225, 225),
                            0, getHeight(), new Color(200, 200, 200));
                    g2.setPaint(gradient);
                    g2.fillRect(0, 0, getWidth(), getHeight());
                }
                super.paintComponent(g);
            }
        };

        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        button.setPreferredSize(new Dimension(200, 40));
        return button;
    }
}
