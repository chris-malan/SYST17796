package malanc.realestateapp.LogInPrompt;

import javax.swing.*;

public class LogIn {

    public static void startLogin() {
        String[] options = {"Sign In", "Sign Up", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Welcome to Real Estate App! Choose an option:", "Welcome",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // Sign In
            SignIn.displaySignInForm();
        } else if (choice == 1) { // Sign Up
            SignUp.displaySignUpForm();
        } else {
            System.exit(0); // Exit
        }
    }
}
