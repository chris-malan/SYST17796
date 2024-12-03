package malanc.realestateapp.Action.Admin;

import javax.swing.*;
import java.awt.*;
import malanc.realestateapp.Models.City;
import malanc.realestateapp.Models.Property;
import malanc.realestateapp.Models.PropertyType;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Action.Shared.DisplayProperties;

public class EditProperty {

    public static void editProperty() {
        // Step 1: Display all properties using DisplayProperties class
        DisplayProperties.displayAllProperties(UserRole.ADMIN);

        // Step 2: Prompt the user for the ID of the property to edit
        String idStr = JOptionPane.showInputDialog("Enter the ID of the property to edit:");
        if (idStr == null || idStr.isEmpty()) return;

        int propertyId = Integer.parseInt(idStr);
        Property propertyToEdit = DataStoreProperty.findPropertyById(propertyId);

        if (propertyToEdit != null) {
            JPanel panel = new JPanel(new GridLayout(16, 2, 5, 5));

            JTextField nameField = new JTextField(propertyToEdit.getName());
            JTextField addressField = new JTextField(propertyToEdit.getAddress());
            JComboBox<City> cityBox = new JComboBox<>(City.values());
            cityBox.setSelectedItem(propertyToEdit.getCity());
            JTextField floorsField = new JTextField(String.valueOf(propertyToEdit.getFloors()));
            JTextField roomsField = new JTextField(String.valueOf(propertyToEdit.getRooms()));
            JTextField bathroomsField = new JTextField(String.valueOf(propertyToEdit.getBathrooms()));
            JComboBox<PropertyType> typeBox = new JComboBox<>(PropertyType.values());
            typeBox.setSelectedItem(propertyToEdit.getType());
            JTextField priceField = new JTextField(String.valueOf(propertyToEdit.getPrice()));
            JTextField squareFootageField = new JTextField(String.valueOf(propertyToEdit.getSquareFootage()));
            JTextField yearBuiltField = new JTextField(String.valueOf(propertyToEdit.getYearBuilt()));
            JCheckBox energyEfficientBox = new JCheckBox("", propertyToEdit.isEnergyEfficient());
            JCheckBox hoaFeesBox = new JCheckBox("", propertyToEdit.hasHoaFees());
            JCheckBox petFriendlyBox = new JCheckBox("", propertyToEdit.isPetFriendly());
            JTextField proximityToAmenitiesField = new JTextField(propertyToEdit.getProximityToAmenities());
            JTextField safetyRatingField = new JTextField(propertyToEdit.getSafetyRating());
            JTextField schoolDistrictField = new JTextField(propertyToEdit.getSchoolDistrict());

            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Address:"));
            panel.add(addressField);
            panel.add(new JLabel("City:"));
            panel.add(cityBox);
            panel.add(new JLabel("Floors:"));
            panel.add(floorsField);
            panel.add(new JLabel("Rooms:"));
            panel.add(roomsField);
            panel.add(new JLabel("Bathrooms:"));
            panel.add(bathroomsField);
            panel.add(new JLabel("Type:"));
            panel.add(typeBox);
            panel.add(new JLabel("Price:"));
            panel.add(priceField);
            panel.add(new JLabel("Square Footage:"));
            panel.add(squareFootageField);
            panel.add(new JLabel("Year Built:"));
            panel.add(yearBuiltField);
            panel.add(new JLabel("Energy Efficient:"));
            panel.add(energyEfficientBox);
            panel.add(new JLabel("HOA Fees:"));
            panel.add(hoaFeesBox);
            panel.add(new JLabel("Pet Friendly:"));
            panel.add(petFriendlyBox);
            panel.add(new JLabel("Proximity to Amenities:"));
            panel.add(proximityToAmenitiesField);
            panel.add(new JLabel("Safety Rating:"));
            panel.add(safetyRatingField);
            panel.add(new JLabel("School District:"));
            panel.add(schoolDistrictField);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setPreferredSize(new Dimension(400, 600));

            int result = JOptionPane.showConfirmDialog(null, scrollPane, "Edit Property", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                // Update property details based on user input
                propertyToEdit.setName(nameField.getText());
                propertyToEdit.setAddress(addressField.getText());
                propertyToEdit.setCity((City) cityBox.getSelectedItem());
                propertyToEdit.setFloors(Integer.parseInt(floorsField.getText()));
                propertyToEdit.setRooms(Integer.parseInt(roomsField.getText()));
                propertyToEdit.setBathrooms(Integer.parseInt(bathroomsField.getText()));
                propertyToEdit.setType((PropertyType) typeBox.getSelectedItem());
                propertyToEdit.setPrice(Integer.parseInt(priceField.getText()));
                propertyToEdit.setSquareFootage(Integer.parseInt(squareFootageField.getText()));
                propertyToEdit.setYearBuilt(Integer.parseInt(yearBuiltField.getText()));
                propertyToEdit.setEnergyEfficient(energyEfficientBox.isSelected());
                propertyToEdit.setHoaFees(hoaFeesBox.isSelected());
                propertyToEdit.setPetFriendly(petFriendlyBox.isSelected());
                propertyToEdit.setProximityToAmenities(proximityToAmenitiesField.getText());
                propertyToEdit.setSafetyRating(safetyRatingField.getText());
                propertyToEdit.setSchoolDistrict(schoolDistrictField.getText());

                JOptionPane.showMessageDialog(null, "Property updated successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Property with ID " + propertyId + " not found.");
        }
    }
}
