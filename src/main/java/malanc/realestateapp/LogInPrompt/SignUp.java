package malanc.realestateapp.LogInPrompt;

import javax.swing.*;
import java.awt.*;
import malanc.realestateapp.UserType.AgentUser;
import malanc.realestateapp.UserType.CustomerUser;
import malanc.realestateapp.DataStore.DataStoreUser;
import malanc.realestateapp.UserType.OwnerUser;
import malanc.realestateapp.Models.User;

public class SignUp {

    public static void displaySignUpForm() {
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField cellphoneField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JComboBox<String> userTypeDropdown = new JComboBox<>(new String[]{"Owner", "Customer", "Agent"});

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Cellphone:"));
        panel.add(cellphoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("User Type:"));
        panel.add(userTypeDropdown);

        int result = JOptionPane.showConfirmDialog(null, panel, "Sign Up", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String cellphone = cellphoneField.getText().trim();
            String email = emailField.getText().trim();
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String userType = (String) userTypeDropdown.getSelectedItem();

            // Create a new user based on selected user type
            User newUser;
            switch (userType) {
                case "Owner" -> newUser = new OwnerUser(firstName, lastName, cellphone, username, password, email);
                case "Customer" -> newUser = new CustomerUser(firstName, lastName, cellphone, username, password, email);
                case "Agent" -> newUser = new AgentUser(firstName, lastName, cellphone, username, password, email);
                default -> throw new IllegalStateException("Unexpected value: " + userType);
            }

            DataStoreUser.addUser(newUser); // Add the new user to the data store
            JOptionPane.showMessageDialog(null, "Registration successful! You can now sign in.");
            LogIn.startLogin(); // Go back to the main login prompt
        } else {
            LogIn.startLogin(); // Go back to the main login prompt
        }
    }
}
