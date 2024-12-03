package malanc.realestateapp.Action.Admin;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import malanc.realestateapp.DataStore.DataStoreUser;
import malanc.realestateapp.Models.User;

public class DisplayUsers {

    public static void displayAllUsers() {
        List<User> users = DataStoreUser.getAllUsers(); // Get the list of all users

        // Build HTML table for displaying users
        StringBuilder htmlContent = new StringBuilder("<html><body><h2>All Users:</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
        
        // Set header color and titles
        htmlContent.append("<tr style='background-color: #87CEEB; color: black;'>")
                   .append("<th>First Name</th>")
                   .append("<th>Last Name</th>")
                   .append("<th>Cellphone</th>")
                   .append("<th>Username</th>")
                   .append("<th>Email</th>")
                   .append("<th>Role</th>")
                   .append("</tr>");
        
        // Add each user as a row in the table
        for (User user : users) {
            htmlContent.append("<tr>")
                       .append("<td>").append(user.getFirstName()).append("</td>")
                       .append("<td>").append(user.getLastName()).append("</td>")
                       .append("<td>").append(user.getCellphone()).append("</td>")
                       .append("<td>").append(user.getUsername()).append("</td>")
                       .append("<td>").append(user.getEmail()).append("</td>")
                       .append("<td>").append(user.getRole()).append("</td>")
                       .append("</tr>");
        }
        
        htmlContent.append("</table></body></html>");

        // Create a JTextPane to display the HTML content
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(htmlContent.toString());
        textPane.setEditable(false); // Make the text pane read-only

        // Create a JScrollPane to allow scrolling if content is too long
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 400)); // Set scroll pane size

        // Display in a JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "All Users", JOptionPane.INFORMATION_MESSAGE);
    }
}
