package malanc.realestateapp.UserPage;

import javax.swing.*;
import java.awt.*;
import malanc.realestateapp.LogInPrompt.LogIn;
import malanc.realestateapp.Action.Shared.DisplayProperties;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.Action.Shared.ViewAppointments;
import malanc.realestateapp.Action.Agent.ApproveBooking; // Import your ApproveBooking class

public class AgentPage {

    public static void displayAgentOptions() {
        JFrame frame = new JFrame("Agent Menu");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        String[] buttonLabels = {
            "View Appointments", 
            "Approve Bookings", 
            "View All Properties", 
            "Log Out",  // New Log Out button
            "Exit"
        };

        Runnable[] actions = {
            () -> ViewAppointments.displayAllAppointments(), // View appointments
            () -> approveBookings(), // Now calls the actual booking approval
            () -> DisplayProperties.displayAllProperties(UserRole.AGENT), // View all properties for agent
            () -> { // Log Out action
                frame.dispose(); // Close the AgentPage window
                LogIn.startLogin(); // Show the login page
            },
            () -> frame.dispose() // Exit action
        };

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        for (int i = 0; i < buttonLabels.length; i++) {
            int index = i;
            JButton button = new JButton(buttonLabels[i]);
            button.setPreferredSize(new Dimension(150, 40)); // Adjust button size
            button.addActionListener(e -> actions[index].run());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void approveBookings() {
        ApproveBooking.displayApproveBookings(); // Use the logged-in agent's name
    }
}
