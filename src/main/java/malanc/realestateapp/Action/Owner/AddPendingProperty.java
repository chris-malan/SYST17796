package malanc.realestateapp.Action.Owner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import malanc.realestateapp.Models.City;
import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Models.Property;
import malanc.realestateapp.Models.PropertyType;
import malanc.realestateapp.Models.User;

public class AddPendingProperty {

    public static void addPendingProperty(User owner) {
        // Extract owner's first and last names from the User object
        String ownerFirstName = owner.getFirstName();
        String ownerLastName = owner.getLastName();

        // Define form fields with placeholder text
        JTextField nameField = createPlaceholderField("e.g., Maple Villa");
        JTextField addressField = createPlaceholderField("e.g., 123 Maple St");
        JComboBox<City> cityBox = new JComboBox<>(City.values());
        JTextField floorsField = createPlaceholderField("e.g., 2");
        JTextField roomsField = createPlaceholderField("e.g., 3");
        JTextField bathroomsField = createPlaceholderField("e.g., 2");
        JComboBox<PropertyType> typeBox = new JComboBox<>(PropertyType.values());
        JTextField squareFootageField = createPlaceholderField("e.g., 1500");
        JTextField yearBuiltField = createPlaceholderField("e.g., 2010");
        JTextField priceField = createPlaceholderField("e.g., 300000");
        JCheckBox energyEfficientBox = new JCheckBox();
        JCheckBox hoaFeesBox = new JCheckBox();
        JCheckBox petFriendlyBox = new JCheckBox();
        JTextField proximityToAmenitiesField = createPlaceholderField("e.g., Near schools");
        JTextField safetyRatingField = createPlaceholderField("e.g., High");
        JTextField propertyTaxRateField = createPlaceholderField("e.g., 1.2");
        JTextField schoolDistrictField = createPlaceholderField("e.g., Peel District");

        // Display owner’s first and last name as non-editable fields
        JTextField ownerFirstNameField = new JTextField(ownerFirstName);
        JTextField ownerLastNameField = new JTextField(ownerLastName);
        ownerFirstNameField.setEditable(false);
        ownerLastNameField.setEditable(false);

        // Panel setup for form layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#f5f5f5")); // Light background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Add Property for Approval", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.decode("#4CAF50"));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titleLabel, gbc);

        // Reset grid width for form fields
        gbc.gridwidth = 1;

        // Adding fields to the form
        addField(panel, gbc, "Name:", nameField, 1);
        addField(panel, gbc, "Address:", addressField, 2);
        addField(panel, gbc, "City:", cityBox, 3);
        addField(panel, gbc, "Floors:", floorsField, 4);
        addField(panel, gbc, "Rooms:", roomsField, 5);
        addField(panel, gbc, "Bathrooms:", bathroomsField, 6);
        addField(panel, gbc, "Type:", typeBox, 7);
        addField(panel, gbc, "Square Footage:", squareFootageField, 8);
        addField(panel, gbc, "Year Built:", yearBuiltField, 9);
        addField(panel, gbc, "Price:", priceField, 10);
        addField(panel, gbc, "Energy Efficient:", energyEfficientBox, 11);
        addField(panel, gbc, "HOA Fees:", hoaFeesBox, 12);
        addField(panel, gbc, "Pet Friendly:", petFriendlyBox, 13);
        addField(panel, gbc, "Proximity to Amenities:", proximityToAmenitiesField, 14);
        addField(panel, gbc, "Safety Rating:", safetyRatingField, 15);
        addField(panel, gbc, "Property Tax Rate:", propertyTaxRateField, 16);
        addField(panel, gbc, "School District:", schoolDistrictField, 17);
        addField(panel, gbc, "Owner First Name:", ownerFirstNameField, 18);
        addField(panel, gbc, "Owner Last Name:", ownerLastNameField, 19);

        // Display the form dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Property for Approval", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Create a new property with the provided data
                Property property = new Property(
                        DataStoreProperty.getNextId(),
                        nameField.getText(),
                        addressField.getText(),
                        (City) cityBox.getSelectedItem(),
                        Integer.parseInt(floorsField.getText()),
                        Integer.parseInt(roomsField.getText()),
                        Integer.parseInt(bathroomsField.getText()),
                        (PropertyType) typeBox.getSelectedItem(),
                        Integer.parseInt(squareFootageField.getText()),
                        Integer.parseInt(yearBuiltField.getText()),
                        Integer.parseInt(priceField.getText()),
                        energyEfficientBox.isSelected(),
                        hoaFeesBox.isSelected(),
                        petFriendlyBox.isSelected(),
                        proximityToAmenitiesField.getText(),
                        safetyRatingField.getText(),
                        Double.parseDouble(propertyTaxRateField.getText()),
                        schoolDistrictField.getText(),
                        ownerFirstName + " " + ownerLastName // Set owner’s full name
                );

                // Add property to pending properties
                DataStoreProperty.addPendingProperty(property);
                JOptionPane.showMessageDialog(null, "Your property has been added and is pending approval. The company will contact you shortly.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for Floors, Rooms, Bathrooms, Square Footage, Year Built, Price, and Property Tax Rate.");
            }
        }
    }

    // Helper method to add a label and field to the panel
    private static void addField(JPanel panel, GridBagConstraints gbc, String labelText, Component field, int yPosition) {
        gbc.gridx = 0;
        gbc.gridy = yPosition;
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = yPosition;
        panel.add(field, gbc);
    }

    // Helper method to create a text field with placeholder text functionality
    private static JTextField createPlaceholderField(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        return textField;
    }
}
