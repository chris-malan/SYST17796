package malanc.realestateapp.DataStore;

import malanc.realestateapp.Models.PropertyType;
import malanc.realestateapp.Models.City;
import malanc.realestateapp.Models.Property;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class DataStoreProperty {
    // Main property list that is visible in the database
    public static List<Property> properties = new ArrayList<>();

    // List to store properties pending admin approval
    public static List<Property> pendingProperties = new ArrayList<>();

    static {
        properties.add(new Property(1, "Maple Villa", "123 Maple St", City.BRAMPTON, 2, 3, 2, PropertyType.SINGLE_FAMILY, 2500, 2005, 500000, true, false, true, "Schools, Grocery", "Medium", 1.2, "Peel District", "John Doe"));
        properties.add(new Property(2, "Oak Residence", "456 Oak Ave", City.MISSISSAUGA, 1, 2, 1, PropertyType.CONDO, 1200, 2018, 300000, false, true, false, "Public Transport", "High", 0.8, "Toronto District", "Jane Smith"));
        properties.add(new Property(3, "Pine Apartments", "789 Pine St", City.TORONTO, 3, 4, 2, PropertyType.APARTMENT, 1800, 2010, 750000, true, true, false, "Shopping Mall, Park", "Low", 1.5, "Toronto District", "Mike Johnson"));
        properties.add(new Property(4, "Cedar Townhouse", "321 Cedar Ln", City.BRAMPTON, 2, 3, 3, PropertyType.TOWNHOUSE, 2200, 2020, 450000, false, false, true, "Schools, Grocery, Hospital", "Medium", 1.3, "Peel District", "Emily Davis"));
        properties.add(new Property(5, "Spruce Estate", "654 Spruce Blvd", City.MISSISSAUGA, 1, 5, 4, PropertyType.SINGLE_FAMILY, 3500, 2015, 850000, true, true, true, "Nature Trails, Grocery", "Low", 1.6, "Peel District", "David Wilson"));
        properties.add(new Property(6, "Birch Condo", "101 Birch Ave", City.TORONTO, 1, 2, 1, PropertyType.CONDO, 900, 2019, 280000, false, false, false, "Grocery, Bus Stop", "High", 1.0, "Toronto District", "Sophia Brown"));
        properties.add(new Property(7, "Willow Manor", "202 Willow Rd", City.BRAMPTON, 3, 4, 3, PropertyType.SINGLE_FAMILY, 2700, 2000, 670000, true, true, true, "Schools, Park", "Medium", 1.4, "Peel District", "Daniel Garcia"));
        properties.add(new Property(8, "Elm Cottage", "303 Elm Dr", City.MISSISSAUGA, 2, 3, 2, PropertyType.TOWNHOUSE, 2100, 2012, 400000, true, false, true, "Schools, Grocery, Gym", "Medium", 1.3, "Peel District", "Emma Martinez"));
        properties.add(new Property(9, "Poplar Residence", "404 Poplar St", City.TORONTO, 1, 2, 1, PropertyType.APARTMENT, 1300, 2017, 320000, false, true, false, "Public Transport, Grocery", "High", 1.1, "Toronto District", "Liam Thomas"));
        properties.add(new Property(10, "Aspen Estate", "505 Aspen Ave", City.BRAMPTON, 2, 5, 4, PropertyType.SINGLE_FAMILY, 3600, 2016, 920000, true, true, true, "Nature Trails, Schools", "Low", 1.7, "Peel District", "Olivia White"));

        properties.add(new Property(11, "Riverfront Villa", "606 River Rd", City.MISSISSAUGA, 1, 3, 2, PropertyType.TOWNHOUSE, 1600, 2011, 370000, false, false, true, "River, Grocery", "Medium", 1.2, "Peel District", "James Anderson"));
        properties.add(new Property(12, "Skyline Apartments", "707 Sky St", City.TORONTO, 10, 3, 2, PropertyType.APARTMENT, 1100, 2019, 300000, true, true, false, "Park, Shopping Center", "Low", 0.9, "Toronto District", "Ava Martin"));
        properties.add(new Property(13, "Bayview Bungalow", "808 Bay Ave", City.BRAMPTON, 1, 3, 1, PropertyType.SINGLE_FAMILY, 1400, 1998, 280000, false, false, false, "Beach, Schools", "Medium", 1.4, "Peel District", "William Jackson"));
        properties.add(new Property(14, "Urban Loft", "909 Loft Rd", City.MISSISSAUGA, 1, 2, 1, PropertyType.CONDO, 900, 2015, 270000, true, false, false, "Restaurants, Gym", "High", 1.1, "Toronto District", "Mia Harris"));
        properties.add(new Property(15, "Lakefront House", "101 Lake Rd", City.TORONTO, 2, 4, 3, PropertyType.SINGLE_FAMILY, 3200, 2014, 920000, true, true, true, "Lake, Grocery, Park", "Low", 1.5, "Toronto District", "Ethan Clark"));
        properties.add(new Property(16, "Forest Townhouse", "202 Forest St", City.BRAMPTON, 2, 4, 2, PropertyType.TOWNHOUSE, 2100, 2007, 410000, true, false, true, "Schools, Gym", "Medium", 1.3, "Peel District", "Sophia Green"));
        properties.add(new Property(17, "Valley View", "303 Valley Rd", City.MISSISSAUGA, 3, 5, 3, PropertyType.SINGLE_FAMILY, 2800, 2018, 830000, true, true, true, "Schools, Grocery", "Low", 1.4, "Peel District", "Robert King"));
        properties.add(new Property(18, "Hilltop Manor", "404 Hill Rd", City.TORONTO, 2, 3, 2, PropertyType.CONDO, 1600, 2013, 620000, false, true, false, "Public Transport, Park", "Medium", 1.0, "Toronto District", "Laura Price"));
        properties.add(new Property(19, "Sunny Apartment", "505 Sun St", City.BRAMPTON, 1, 2, 1, PropertyType.APARTMENT, 1100, 2020, 330000, false, true, false, "Grocery, Bus Stop", "High", 1.1, "Peel District", "Henry Bell"));
        properties.add(new Property(20, "Riverside Cottage", "606 River St", City.MISSISSAUGA, 2, 4, 3, PropertyType.SINGLE_FAMILY, 2300, 2016, 620000, true, true, true, "River, Schools", "Low", 1.5, "Peel District", "Elena Taylor"));

        properties.add(new Property(21, "Mountain View", "707 Peak St", City.TORONTO, 3, 4, 3, PropertyType.TOWNHOUSE, 2500, 2008, 480000, true, false, true, "Park, Trails", "Medium", 1.2, "Toronto District", "Michael Lewis"));
        properties.add(new Property(22, "Ocean Breeze", "808 Ocean Dr", City.BRAMPTON, 2, 3, 2, PropertyType.SINGLE_FAMILY, 1500, 2017, 560000, true, true, true, "Beach, Schools", "Medium", 1.3, "Peel District", "Nina Young"));
        properties.add(new Property(23, "Garden Estates", "909 Garden Rd", City.MISSISSAUGA, 1, 5, 3, PropertyType.SINGLE_FAMILY, 3200, 2010, 780000, false, true, false, "Shopping, Parks", "Low", 1.4, "Peel District", "Leo Green"));
        properties.add(new Property(24, "City Lights Condo", "101 City Ave", City.TORONTO, 1, 1, 1, PropertyType.CONDO, 700, 2019, 290000, false, false, false, "Downtown, Metro", "High", 1.0, "Toronto District", "Chris Black"));
        properties.add(new Property(25, "Greenfield Villa", "202 Green Ln", City.BRAMPTON, 2, 4, 3, PropertyType.SINGLE_FAMILY, 2500, 2011, 670000, true, false, true, "Parks, Grocery", "Medium", 1.3, "Peel District", "Linda Brown"));
        properties.add(new Property(26, "Summit Heights", "303 Summit St", City.MISSISSAUGA, 3, 5, 4, PropertyType.TOWNHOUSE, 3100, 2015, 850000, true, true, true, "Hiking Trails, Schools", "Low", 1.6, "Peel District", "Paul Carter"));
        properties.add(new Property(27, "Parkside Condo", "404 Park St", City.TORONTO, 1, 2, 1, PropertyType.CONDO, 950, 2017, 320000, false, true, false, "Park, Grocery", "Medium", 1.0, "Toronto District", "Susan Morris"));
        properties.add(new Property(28, "Downtown Loft", "505 Urban St", City.TORONTO, 1, 3, 2, PropertyType.APARTMENT, 1800, 2018, 550000, true, true, false, "Downtown, Mall", "Low", 1.4, "Toronto District", "Edward Lee"));
        properties.add(new Property(29, "Suburban Home", "606 Suburb Ave", City.BRAMPTON, 2, 4, 3, PropertyType.SINGLE_FAMILY, 3000, 2013, 740000, true, false, true, "Parks, Schools", "Medium", 1.5, "Peel District", "Anna Scott"));
        properties.add(new Property(30, "Lakeside Retreat", "707 Lake Dr", City.MISSISSAUGA, 2, 3, 2, PropertyType.SINGLE_FAMILY, 2000, 2019, 480000, true, true, true, "Lake, Grocery", "Low", 1.6, "Peel District", "Mark Watson"));

        properties.add(new Property(31, "Sunset Ridge", "811 Sunset Blvd", City.MISSISSAUGA, 2, 4, 3, PropertyType.SINGLE_FAMILY, 2800, 2014, 610000, true, true, true, "Parks, Schools", "Medium", 1.2, "Peel District", "Nancy Bell"));
        properties.add(new Property(32, "Downtown Flats", "712 Urban Way", City.TORONTO, 1, 1, 1, PropertyType.CONDO, 800, 2021, 320000, false, false, true, "Mall, Subway", "High", 1.1, "Toronto District", "Isaac White"));
        properties.add(new Property(33, "Forest Edge", "133 Oak Ln", City.BRAMPTON, 2, 3, 2, PropertyType.TOWNHOUSE, 1600, 2012, 400000, true, true, false, "Gym, Hospital", "Low", 1.3, "Peel District", "Mary Grant"));
        properties.add(new Property(34, "Highrise Haven", "909 Skyline Ave", City.TORONTO, 15, 2, 1, PropertyType.APARTMENT, 1100, 2019, 370000, false, true, false, "Shopping Center", "Medium", 1.5, "Toronto District", "Jacob Turner"));
        properties.add(new Property(35, "Lakehouse Retreat", "325 Shoreline Rd", City.MISSISSAUGA, 1, 4, 3, PropertyType.SINGLE_FAMILY, 3300, 2010, 820000, true, true, true, "Lake, Grocery", "Medium", 1.8, "Peel District", "Betty Roberts"));
        properties.add(new Property(36, "Grove Residence", "200 Grove Ave", City.BRAMPTON, 1, 3, 2, PropertyType.CONDO, 900, 2018, 290000, false, false, true, "Public Transport", "High", 1.2, "Peel District", "Lisa Moore"));
        properties.add(new Property(37, "Suburban Townhouse", "400 Elm Ln", City.MISSISSAUGA, 2, 4, 3, PropertyType.TOWNHOUSE, 2300, 2007, 590000, true, true, true, "Parks, Schools", "Medium", 1.4, "Peel District", "Kevin Edwards"));
        properties.add(new Property(38, "Cozy Corner", "511 Willow St", City.BRAMPTON, 1, 2, 1, PropertyType.APARTMENT, 1100, 2019, 330000, false, true, false, "Grocery, Bus Stop", "Medium", 1.1, "Peel District", "Rachel Howard"));
        properties.add(new Property(39, "Urban Heights", "233 City Rd", City.TORONTO, 20, 2, 1, PropertyType.CONDO, 950, 2020, 340000, false, true, true, "Metro, Restaurants", "High", 1.3, "Toronto District", "Patrick Hall"));
        properties.add(new Property(40, "West End Villa", "355 West St", City.BRAMPTON, 2, 5, 4, PropertyType.SINGLE_FAMILY, 3000, 2015, 750000, true, true, true, "Nature Trails", "Low", 1.7, "Peel District", "Nicole Perry"));

        properties.add(new Property(41, "Riverside Lodge", "402 River Rd", City.MISSISSAUGA, 1, 4, 2, PropertyType.SINGLE_FAMILY, 2500, 2011, 630000, true, true, true, "Riverside, School", "Medium", 1.5, "Peel District", "George Clark"));
        properties.add(new Property(42, "City Center Condo", "530 Downtown Ave", City.TORONTO, 5, 2, 1, PropertyType.CONDO, 1200, 2022, 400000, false, true, false, "Subway, Shopping", "High", 1.2, "Toronto District", "Stephanie Wright"));
        properties.add(new Property(43, "Eco-Friendly Home", "150 Green St", City.BRAMPTON, 1, 3, 2, PropertyType.SINGLE_FAMILY, 1400, 2018, 460000, true, false, true, "Grocery, Gym", "Low", 1.3, "Peel District", "Bruce Green"));
        properties.add(new Property(44, "Nature's Abode", "700 Oak St", City.MISSISSAUGA, 2, 4, 3, PropertyType.TOWNHOUSE, 2700, 2013, 580000, true, true, true, "Park, Grocery", "Medium", 1.6, "Peel District", "Rose Hill"));
        properties.add(new Property(45, "Coastal View", "810 Coast Rd", City.TORONTO, 3, 5, 4, PropertyType.SINGLE_FAMILY, 3900, 2014, 980000, true, true, true, "Beach, Mall", "Low", 2.0, "Toronto District", "Tom Martin"));
        properties.add(new Property(46, "Mountain Retreat", "900 Highland Blvd", City.BRAMPTON, 2, 4, 3, PropertyType.SINGLE_FAMILY, 3400, 2009, 800000, true, true, true, "Hiking Trails, Grocery", "Low", 1.7, "Peel District", "Sarah Griffin"));
        properties.add(new Property(47, "Urban Dwelling", "260 City St", City.TORONTO, 2, 3, 2, PropertyType.APARTMENT, 1000, 2015, 460000, true, true, false, "Restaurants, Gym", "High", 1.5, "Toronto District", "Amanda Cooper"));
        properties.add(new Property(48, "Countryside Home", "123 Country Ln", City.BRAMPTON, 1, 3, 2, PropertyType.SINGLE_FAMILY, 2000, 2005, 570000, true, false, true, "Nature, Schools", "Medium", 1.4, "Peel District", "Victor Baker"));
        properties.add(new Property(49, "Bayfront Condo", "530 Bayfront St", City.TORONTO, 7, 2, 1, PropertyType.CONDO, 950, 2018, 390000, false, true, false, "Park, Shopping", "High", 1.2, "Toronto District", "Sandra Hill"));
        properties.add(new Property(50, "Hilltop Retreat", "760 Hilltop Ave", City.MISSISSAUGA, 1, 3, 2, PropertyType.SINGLE_FAMILY, 2600, 2017, 600000, true, true, true, "Hill, Grocery", "Low", 1.5, "Peel District", "Diana Cox"));
    }

    // Method to find a property by ID
    public static Property findPropertyById(int propertyId) {
        for (Property property : properties) {
            if (property.getId() == propertyId) {
                return property;
            }
        }
        return null; // Return null if no property with the given ID is found
    }

    // Method to add a property directly to the main properties list (for admin use)
    public static void addProperty(Property property) {
        properties.add(property);
    }

    // Method to add a property to the pending properties list (for owner use)
    public static void addPendingProperty(Property property) {
        pendingProperties.add(property);
    }

    // Method for admin to approve pending properties
    public static void approvePendingProperties() {
        // Implement approval logic as needed
    }

    public static List<Property> getProperties() {
        return properties;
    }

    public static List<Property> getPendingProperties() {
        return pendingProperties;
    }
    
    // Add this method in DataStoreProperty class
    public static int getNextId() {
        int maxId = properties.stream().mapToInt(Property::getId).max().orElse(0);
        return maxId + 1;
    }
    
    public static void approveProperty(int propertyId) {
    Property propertyToApprove = null;

    // Find the property in the pending list by ID
    for (Property property : pendingProperties) {
        if (property.getId() == propertyId) {
            propertyToApprove = property;
            break;
        }
    }

    // If found, move it to the main properties list
    if (propertyToApprove != null) {
        pendingProperties.remove(propertyToApprove);
        properties.add(propertyToApprove);
        JOptionPane.showMessageDialog(null, "Property approved successfully!");
    } else {
        JOptionPane.showMessageDialog(null, "Property not found in pending list.");
    }
    }
    
        // Static initializer for properties
    static {
       
        // Adding a sample pending property submitted by an existing owner (e.g., "Jane Smith")
        pendingProperties.add(new Property(
            getNextId(), // Automatically generate the next unique ID
            "Cedar Heights Pending",           // Property name
            "789 Cedar St",            // Address
            City.TORONTO,              // City
            3,                         // Floors
            4,                         // Rooms
            3,                         // Bathrooms
            PropertyType.TOWNHOUSE,    // Type
            1800,                      // Square footage
            2022,                      // Year built
            600000,                    // Price
            true,                      // Energy efficient
            true,                      // HOA fees
            false,                     // Pet friendly
            "Near park and metro",     // Proximity to amenities
            "High",                    // Safety rating
            1.5,                       // Property tax rate
            "Toronto District",        // School district
            "Jane Smith"               // Owner name (from existing owners)
            ));
        }

    
}