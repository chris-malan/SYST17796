package malanc.realestateapp.UserPage;

import javax.swing.*;
import malanc.realestateapp.LogInPrompt.LogIn; // Import the LogIn class
import malanc.realestateapp.Action.Shared.AppointmentBooking;
import malanc.realestateapp.Action.Customer.Search;
import malanc.realestateapp.Action.Shared.DisplayProperties;
import malanc.realestateapp.Models.UserRole;

public class CustomerPage {

    public static void displayCustomerOptions(String currentUsername) {
        boolean keepRunning = true;

        while (keepRunning) {
            String[] options = {"Search Properties", "View All Properties", "Book Appointment", "Log Out"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Customer Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> Search.searchProperties(); // Search for properties
                case 1 -> DisplayProperties.displayAllProperties(UserRole.CUSTOMER); // View all properties with UserRole.CUSTOMER
                case 2 -> AppointmentBooking.bookAppointment(currentUsername); // Book an appointment with an agent
                case 3 -> keepRunning = false; // Log out
                default -> JOptionPane.showMessageDialog(null, "No valid option selected.");
            }
        }

        // After logging out, display the login screen again
        LogIn.startLogin();
    }
}
