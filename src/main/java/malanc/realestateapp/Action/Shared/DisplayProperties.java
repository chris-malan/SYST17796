package malanc.realestateapp.Action.Shared;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Models.Property;
import malanc.realestateapp.Models.UserRole;

public class DisplayProperties {

    public static void displayAllProperties(UserRole userRole) {
        List<Property> properties = DataStoreProperty.getProperties();

        if (properties.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No properties available.", "View Properties", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder propertiesList = new StringBuilder("<html><body><h2 style='text-align: center; color: #4CAF50;'>All Properties</h2>");
        propertiesList.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100%; border-collapse: collapse;'>");

        // Adding table header with styling
        propertiesList.append("<tr style='background-color: #4CAF50; color: white;'>")
                .append("<th>ID</th>")
                .append("<th>Name</th>")
                .append("<th>Address</th>")
                .append("<th>City</th>")
                .append("<th>Floors</th>")
                .append("<th>Rooms</th>")
                .append("<th>Type</th>")
                .append("<th>Price</th>")
                .append("<th>Square Footage</th>")
                .append("<th>Year Built</th>")
                .append("<th>Energy Efficient</th>")
                .append("<th>HOA Fees</th>")
                .append("<th>Pet Friendly</th>")
                .append("<th>Safety Rating</th>")
                .append("<th>School District</th>");

        // Conditionally add the Owner column only for Admin
        if (userRole == UserRole.ADMIN || userRole == UserRole.AGENT) {
            propertiesList.append("<th>Owner Name</th>");
        }
        propertiesList.append("</tr>");

        // Populate table rows with property data
        for (Property property : properties) {
            propertiesList.append("<tr>")
                    .append("<td>").append(property.getId()).append("</td>")
                    .append("<td>").append(property.getName()).append("</td>")
                    .append("<td>").append(property.getAddress()).append("</td>")
                    .append("<td>").append(property.getCity().name()).append("</td>")
                    .append("<td>").append(property.getFloors()).append("</td>")
                    .append("<td>").append(property.getRooms()).append("</td>")
                    .append("<td>").append(property.getType().name()).append("</td>")
                    .append("<td>").append(property.getPrice()).append("</td>")
                    .append("<td>").append(property.getSquareFootage()).append("</td>")
                    .append("<td>").append(property.getYearBuilt()).append("</td>")
                    .append("<td>").append(property.isEnergyEfficient() ? "Yes" : "No").append("</td>")
                    .append("<td>").append(property.hasHoaFees() ? "Yes" : "No").append("</td>")
                    .append("<td>").append(property.isPetFriendly() ? "Yes" : "No").append("</td>")
                    .append("<td>").append(property.getSafetyRating()).append("</td>")
                    .append("<td>").append(property.getSchoolDistrict()).append("</td>");

            // Conditionally add the Owner data for Admin
            if (userRole == UserRole.ADMIN || userRole == UserRole.AGENT) {
                propertiesList.append("<td>").append(property.getOwnerName()).append("</td>");
            }

            propertiesList.append("</tr>");
        }

        propertiesList.append("</table></body></html>");

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(propertiesList.toString());
        textPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(1200, 700));

        JOptionPane.showMessageDialog(null, scrollPane, "Properties List", JOptionPane.INFORMATION_MESSAGE);
    }
}
