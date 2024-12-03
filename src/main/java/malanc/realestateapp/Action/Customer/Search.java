package malanc.realestateapp.Action.Customer;

import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Models.Property;
import javax.swing.*;
import java.awt.*;

public class Search {

    public static void searchProperties() {
        // Dropdown for selecting city
        String[] cities = {"Any", "Brampton", "Mississauga", "Toronto"};
        JComboBox<String> cityComboBox = new JComboBox<>(cities);

        // Dropdown for selecting property type
        String[] propertyTypes = {"Any", "Single-Family", "Condo", "Townhouse", "Apartment"};
        JComboBox<String> propertyTypeComboBox = new JComboBox<>(propertyTypes);

        // Dropdown for selecting price range
        String[] priceRanges = {"Any", "Under 300,000", "300,000 - 500,000", "500,000 - 700,000", "700,000 - 900,000", "900,000 and above"};
        JComboBox<String> priceRangeComboBox = new JComboBox<>(priceRanges);

        // Additional fields for other criteria
        JTextField minRoomsField = new JTextField();
        JTextField maxRoomsField = new JTextField();
        JCheckBox petFriendlyCheckBox = new JCheckBox("Pet Friendly");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("City:"));
        panel.add(cityComboBox);
        panel.add(new JLabel("Property Type:"));
        panel.add(propertyTypeComboBox);
        panel.add(new JLabel("Price Range:"));
        panel.add(priceRangeComboBox);
        panel.add(new JLabel("Minimum Rooms:"));
        panel.add(minRoomsField);
        panel.add(new JLabel("Maximum Rooms:"));
        panel.add(maxRoomsField);
        panel.add(new JLabel("Pet Friendly:"));
        panel.add(petFriendlyCheckBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Search Properties", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Retrieve selected search criteria
                String selectedCity = (String) cityComboBox.getSelectedItem();
                String selectedPropertyType = (String) propertyTypeComboBox.getSelectedItem();
                String selectedPriceRange = (String) priceRangeComboBox.getSelectedItem();
                String minRooms = minRoomsField.getText().isEmpty() ? "N/A" : minRoomsField.getText();
                String maxRooms = maxRoomsField.getText().isEmpty() ? "N/A" : maxRoomsField.getText();
                boolean petFriendly = petFriendlyCheckBox.isSelected();

                // Define price range boundaries
                int minPrice = 0;
                int maxPrice = Integer.MAX_VALUE;
                switch (selectedPriceRange) {
                    case "Under 300,000":
                        maxPrice = 300000;
                        break;
                    case "300,000 - 500,000":
                        minPrice = 300000;
                        maxPrice = 500000;
                        break;
                    case "500,000 - 700,000":
                        minPrice = 500000;
                        maxPrice = 700000;
                        break;
                    case "700,000 - 900,000":
                        minPrice = 700000;
                        maxPrice = 900000;
                        break;
                    case "900,000 and above":
                        minPrice = 900000;
                        break;
                }

                // Build the input summary at the top of the results
                StringBuilder criteriaSummary = new StringBuilder("<html><body><h3>Showing Properties Based on this Input:</h3><ul>");
                criteriaSummary.append("<li>City: ").append(selectedCity).append("</li>");
                criteriaSummary.append("<li>Property Type: ").append(selectedPropertyType).append("</li>");
                criteriaSummary.append("<li>Price Range: ").append(selectedPriceRange).append("</li>");
                criteriaSummary.append("<li>Rooms: ").append(minRooms).append(" - ").append(maxRooms).append("</li>");
                criteriaSummary.append("<li>Pet Friendly: ").append(petFriendly ? "Yes" : "No").append("</li>");
                criteriaSummary.append("</ul>");

                // Start building the results table
                StringBuilder results = new StringBuilder(criteriaSummary.toString());
                results.append("<h3>Search Results:</h3>");
                
                boolean matchFound = false;
                StringBuilder exactMatches = new StringBuilder();
                StringBuilder recommendations = new StringBuilder();

                for (Property property : DataStoreProperty.properties) {
                    boolean matchesCity = selectedCity.equals("Any") || property.getCity().name().equalsIgnoreCase(selectedCity);
                    boolean matchesType = selectedPropertyType.equals("Any") || property.getType().name().equalsIgnoreCase(selectedPropertyType);
                    boolean matchesPrice = property.getPrice() >= minPrice && property.getPrice() <= maxPrice;
                    boolean matchesRooms = (minRooms.equals("N/A") || property.getRooms() >= Integer.parseInt(minRooms)) &&
                                           (maxRooms.equals("N/A") || property.getRooms() <= Integer.parseInt(maxRooms));
                    boolean matchesPetFriendly = !petFriendly || property.isPetFriendly();

                    // Exact match check: all criteria must match
                    if (matchesCity && matchesType && matchesPrice && matchesRooms && matchesPetFriendly) {
                        matchFound = true;
                        exactMatches.append("<tr>")
                                .append("<td>").append(property.getId()).append("</td>")
                                .append("<td>").append(property.getName()).append("</td>")
                                .append("<td>").append(property.getAddress()).append("</td>")
                                .append("<td>").append(property.getCity().name()).append("</td>")
                                .append("<td>").append(property.getFloors()).append("</td>")
                                .append("<td>").append(property.getRooms()).append("</td>")
                                .append("<td>").append(property.getBathrooms()).append("</td>")
                                .append("<td>").append(property.getType().name()).append("</td>")
                                .append("<td>").append(property.getPrice()).append("</td>")
                                .append("<td>").append(property.getSquareFootage()).append("</td>")
                                .append("<td>").append(property.getYearBuilt()).append("</td>")
                                .append("<td>").append(property.isEnergyEfficient() ? "Yes" : "No").append("</td>")
                                .append("<td>").append(property.hasHoaFees() ? "Yes" : "No").append("</td>")
                                .append("<td>").append(property.isPetFriendly() ? "Yes" : "No").append("</td>")
                                .append("<td>").append(property.getProximityToAmenities()).append("</td>")
                                .append("<td>").append(property.getSafetyRating()).append("</td>")
                                .append("<td>").append(property.getPropertyTaxRate()).append("</td>")
                                .append("<td>").append(property.getSchoolDistrict()).append("</td>")
                                .append("</tr>");
                    } else if (!matchFound && (matchesCity || matchesType)) {
                        // Add properties matching some criteria as recommendations if no exact match is found
                        recommendations.append("<tr>")
                                .append("<td>").append(property.getId()).append("</td>")
                                .append("<td>").append(property.getName()).append("</td>")
                                .append("<td>").append(property.getAddress()).append("</td>")
                                .append("<td>").append(property.getCity().name()).append("</td>")
                                .append("<td>").append(property.getFloors()).append("</td>")
                                .append("<td>").append(property.getRooms()).append("</td>")
                                .append("<td>").append(property.getBathrooms()).append("</td>")
                                .append("<td>").append(property.getType().name()).append("</td>")
                                .append("<td>").append(property.getPrice()).append("</td>")
                                .append("<td>").append(property.getSquareFootage()).append("</td>")
                                .append("<td>").append(property.getYearBuilt()).append("</td>")
                                .append("<td>").append(property.isEnergyEfficient() ? "Yes" : "No").append("</td>")
                                .append("<td>").append(property.hasHoaFees() ? "Yes" : "No").append("</td>")
                                .append("<td>").append(property.isPetFriendly() ? "Yes" : "No").append("</td>")
                                .append("<td>").append(property.getProximityToAmenities()).append("</td>")
                                .append("<td>").append(property.getSafetyRating()).append("</td>")
                                .append("<td>").append(property.getPropertyTaxRate()).append("</td>")
                                .append("<td>").append(property.getSchoolDistrict()).append("</td>")
                                .append("</tr>");
                    }
                }

                if (matchFound) {
                    results.append("<table border='1' cellpadding='5' cellspacing='0'><tr>")
                           .append("<th>ID</th><th>Name</th><th>Address</th><th>City</th><th>Floors</th><th>Rooms</th><th>Bathrooms</th><th>Type</th><th>Price</th><th>Square Footage</th>")
                           .append("<th>Year Built</th><th>Energy Efficient</th><th>HOA Fees</th><th>Pet Friendly</th><th>Proximity to Amenities</th><th>Safety Rating</th><th>Property Tax Rate</th><th>School District</th></tr>")
                           .append(exactMatches.toString())
                           .append("</table></body></html>");
                } else {
                    results.append("<p><b>No exact results found.</b> Showing recommended properties based on some of your criteria:</p>")
                           .append("<table border='1' cellpadding='5' cellspacing='0'><tr>")
                           .append("<th>ID</th><th>Name</th><th>Address</th><th>City</th><th>Floors</th><th>Rooms</th><th>Bathrooms</th><th>Type</th><th>Price</th><th>Square Footage</th>")
                           .append("<th>Year Built</th><th>Energy Efficient</th><th>HOA Fees</th><th>Pet Friendly</th><th>Proximity to Amenities</th><th>Safety Rating</th><th>Property Tax Rate</th><th>School District</th></tr>")
                           .append(recommendations.toString())
                           .append("</table></body></html>");
                }

                // Display results in a scrollable panel
                JLabel resultsLabel = new JLabel(results.toString());
                JScrollPane scrollPane = new JScrollPane(resultsLabel);
                scrollPane.setPreferredSize(new Dimension(1400, 700));

                JOptionPane.showMessageDialog(null, scrollPane, "Search Results", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for rooms.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
