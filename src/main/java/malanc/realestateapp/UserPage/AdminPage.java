package malanc.realestateapp.UserPage;

import javax.swing.*;
import java.awt.*;
import malanc.realestateapp.Action.Admin.AddProperty;
import malanc.realestateapp.Action.Admin.ApprovePendingProperties;
import malanc.realestateapp.Action.Shared.DisplayProperties;
import malanc.realestateapp.Action.Admin.DisplayUsers;
import malanc.realestateapp.Action.Admin.EditProperty;
import malanc.realestateapp.Action.Admin.RemoveProperty;
import malanc.realestateapp.Action.Shared.ViewAppointments;
import malanc.realestateapp.LogInPrompt.LogIn;
import malanc.realestateapp.Models.UserRole;

public class AdminPage {

    public static void displayAdminOptions() {
        JFrame frame = new JFrame("Admin Menu");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Title label
        JLabel titleLabel = new JLabel("Admin Options", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel to hold buttons in grid format
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10)); // 3x3 grid layout

        // Create buttons with actions
        String[] buttonLabels = {
            "View All Properties", "Approve Pending Properties", "View All Users",
            "View All Appointments", "Add Property", "Edit Property",
            "Remove Property", "Log Out"
        };

        Runnable[] actions = {
            () -> DisplayProperties.displayAllProperties(UserRole.ADMIN),
            ApprovePendingProperties::displayPendingProperties,
            DisplayUsers::displayAllUsers,
            ViewAppointments::displayAllAppointments,
            AddProperty::addProperty,
            EditProperty::editProperty,
            RemoveProperty::removeProperty,
            () -> {
                frame.dispose(); // Close the AdminPage window
                LogIn.startLogin(); // Show login screen again
            }
        };

        // Add all buttons except "Log Out" to the main grid
        for (int i = 0; i < 7; i++) {
            JButton button = new JButton(buttonLabels[i]);
            int index = i;  // Create a new final variable for each iteration
            button.addActionListener(e -> actions[index].run());
            buttonPanel.add(button);
        }

        // Add button panel to frame center
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Separate panel for "Log Out" button at the bottom
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton logOutButton = new JButton(buttonLabels[7]);
        logOutButton.addActionListener(e -> actions[7].run());
        bottomPanel.add(logOutButton);

        // Add bottom panel to frame
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
