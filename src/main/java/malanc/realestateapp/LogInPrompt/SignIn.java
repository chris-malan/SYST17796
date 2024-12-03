package malanc.realestateapp.LogInPrompt;

import javax.swing.*;
import malanc.realestateapp.DataStore.DataStoreUser;
import malanc.realestateapp.Models.User;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.UserPage.AgentPage;
import malanc.realestateapp.UserPage.AdminPage;
import malanc.realestateapp.Action.Agent.ApproveBooking;

public class SignIn {

    public static void displaySignInForm() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Sign In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            User user = DataStoreUser.authenticate(username, password); // Assuming an authentication method
            if (user != null) {
                switch (user.getRole()) {
                    case AGENT:
                        // Set the logged-in agent's name and display the agent's page
                        ApproveBooking.loginAsAgent(user.getFullName());
                        AgentPage.displayAgentOptions();
                        break;
                    case ADMIN:
                        AdminPage.displayAdminOptions();
                        break;
                    default:
                        // Redirect to a page for other user roles, if applicable
                        user.displayUserOptions(); // Example method, depending on implementation
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                displaySignInForm(); // Retry on failure
            }
        } else {
            LogIn.startLogin(); // Go back to the main login prompt
        }
    }
}
