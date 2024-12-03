package malanc.realestateapp.Action.Admin;

import javax.swing.*;
import java.awt.*;
import malanc.realestateapp.Models.City;
import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Models.Property;
import malanc.realestateapp.Models.PropertyType;

public class AddProperty {

    public static void addProperty() {
        JTextField nameField = createPlaceholderTextField("e.g., Maple Villa");
        JTextField addressField = createPlaceholderTextField("e.g., 123 Maple St");
        JComboBox<City> cityBox = new JComboBox<>(City.values());
        JTextField floorsField = createPlaceholderTextField("e.g., 2");
        JTextField roomsField = createPlaceholderTextField("e.g., 3");
        JTextField bathroomsField = createPlaceholderTextField("e.g., 2");
        JComboBox<PropertyType> typeBox = new JComboBox<>(PropertyType.values());
        JTextField squareFootageField = createPlaceholderTextField("e.g., 1500");
        JTextField yearBuiltField = createPlaceholderTextField("e.g., 2010");
        JTextField priceField = createPlaceholderTextField("e.g., 300000");
        JCheckBox energyEfficientBox = new JCheckBox();
        JCheckBox hoaFeesBox = new JCheckBox();
        JCheckBox petFriendlyBox = new JCheckBox();
        JTextField proximityToAmenitiesField = createPlaceholderTextField("e.g., Near schools");
        JTextField safetyRatingField = createPlaceholderTextField("e.g., High");
        JTextField propertyTaxRateField = createPlaceholderTextField("e.g., 1.2");
        JTextField schoolDistrictField = createPlaceholderTextField("e.g., Peel District");
        JTextField ownerNameField = createPlaceholderTextField("e.g., John Doe"); // New owner name field

        JPanel panel = new JPanel(new GridLayout(19, 2, 5, 5));
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
        panel.add(new JLabel("Square Footage:"));
        panel.add(squareFootageField);
        panel.add(new JLabel("Year Built:"));
        panel.add(yearBuiltField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
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
        panel.add(new JLabel("Property Tax Rate:"));
        panel.add(propertyTaxRateField);
        panel.add(new JLabel("School District:"));
        panel.add(schoolDistrictField);
        panel.add(new JLabel("Owner Name:")); // Adding owner name label
        panel.add(ownerNameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Property", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Check if required fields are filled
            String name = nameField.getText().trim();
            String address = addressField.getText().trim();
            City city = (City) cityBox.getSelectedItem();
            String ownerName = ownerNameField.getText().trim(); // Get owner name input

            if (name.isEmpty() || address.isEmpty() || city == null || ownerName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the required fields: Name, Address, City, and Owner Name.");
                return;
            }

            try {
                // Optional fields
                int floors = floorsField.getText().isEmpty() ? 0 : Integer.parseInt(floorsField.getText().trim());
                int rooms = roomsField.getText().isEmpty() ? 0 : Integer.parseInt(roomsField.getText().trim());
                int bathrooms = bathroomsField.getText().isEmpty() ? 0 : Integer.parseInt(bathroomsField.getText().trim());
                PropertyType type = (PropertyType) typeBox.getSelectedItem();
                int squareFootage = squareFootageField.getText().isEmpty() ? 0 : Integer.parseInt(squareFootageField.getText().trim());
                int yearBuilt = yearBuiltField.getText().isEmpty() ? 0 : Integer.parseInt(yearBuiltField.getText().trim());
                int price = priceField.getText().isEmpty() ? 0 : Integer.parseInt(priceField.getText().trim());
                boolean energyEfficient = energyEfficientBox.isSelected();
                boolean hoaFees = hoaFeesBox.isSelected();
                boolean petFriendly = petFriendlyBox.isSelected();
                String proximityToAmenities = proximityToAmenitiesField.getText();
                String safetyRating = safetyRatingField.getText();
                double propertyTaxRate = propertyTaxRateField.getText().isEmpty() ? 0.0 : Double.parseDouble(propertyTaxRateField.getText().trim());
                String schoolDistrict = schoolDistrictField.getText();

                Property property = new Property(
                        DataStoreProperty.getNextId(), // Assuming getNextId() generates a unique ID
                        name, address, city, floors, rooms, bathrooms, type,
                        squareFootage, yearBuilt, price, energyEfficient, hoaFees, petFriendly,
                        proximityToAmenities, safetyRating, propertyTaxRate, schoolDistrict, ownerName // Pass ownerName here
                );

                DataStoreProperty.addProperty(property);
                JOptionPane.showMessageDialog(null, "Property added successfully!");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for floors, rooms, bathrooms, square footage, year built, price, and tax rate.");
            }
        }
    }

    private static JTextField createPlaceholderTextField(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });

        return textField;
    }
}
