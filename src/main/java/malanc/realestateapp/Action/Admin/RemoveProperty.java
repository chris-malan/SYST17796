package malanc.realestateapp.Action.Admin;

import javax.swing.*;
import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Models.Property;
import malanc.realestateapp.Action.Shared.DisplayProperties;
import malanc.realestateapp.Models.UserRole;

public class RemoveProperty {

    public static void removeProperty() {
        // Display all properties before selection
        DisplayProperties.displayAllProperties(UserRole.ADMIN);

        // Prompt for property ID to remove
        String idStr = JOptionPane.showInputDialog("Enter the ID of the property to remove:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        int propertyId;
        try {
            propertyId = Integer.parseInt(idStr.trim()); // Trim whitespace before parsing
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric ID.");
            return;
        }

        Property propertyToRemove = DataStoreProperty.findPropertyById(propertyId);

        if (propertyToRemove != null) {
            // Confirm removal
            String propertyDetails = getPropertyDetails(propertyToRemove);
            int confirm = JOptionPane.showConfirmDialog(null,
                    "<html><body><h3>Are you sure you want to remove the property?</h3><br>" + propertyDetails + "</body></html>",
                    "Confirm Removal",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Remove property from the list
                DataStoreProperty.properties.remove(propertyToRemove);
                JOptionPane.showMessageDialog(null, "Property removed successfully!");

                // Refresh the display to show updated properties list
                DisplayProperties.displayAllProperties(UserRole.ADMIN);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Property with ID " + propertyId + " not found.");
        }
    }

    private static String getPropertyDetails(Property property) {
        return "<html><body style='width: 250px;'>" +
                "<b>ID:</b> " + property.getId() + "<br>" +
                "<b>Name:</b> " + property.getName() + "<br>" +
                "<b>Address:</b> " + property.getAddress() + "<br>" +
                "<b>City:</b> " + property.getCity().name() + "<br>" +
                "<b>Floors:</b> " + property.getFloors() + "<br>" +
                "<b>Rooms:</b> " + property.getRooms() + "<br>" +
                "<b>Type:</b> " + property.getType().name() + "<br>" +
                "<b>Price:</b> $" + String.format("%,d", property.getPrice()) + "<br>" +
                "<b>Square Footage:</b> " + property.getSquareFootage() + " sq ft<br>" +
                "<b>Year Built:</b> " + property.getYearBuilt() + "<br>" +
                "<b>Energy Efficient:</b> " + (property.isEnergyEfficient() ? "Yes" : "No") + "<br>" +
                "<b>HOA Fees:</b> " + (property.hasHoaFees() ? "Yes" : "No") + "<br>" +
                "<b>Pet Friendly:</b> " + (property.isPetFriendly() ? "Yes" : "No") + "<br>" +
                "<b>Safety Rating:</b> " + property.getSafetyRating() + "<br>" +
                "<b>School District:</b> " + property.getSchoolDistrict() + "<br>" +
                "</body></html>";
    }
}
