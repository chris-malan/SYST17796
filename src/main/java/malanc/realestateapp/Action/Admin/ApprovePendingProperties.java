package malanc.realestateapp.Action.Admin;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import malanc.realestateapp.DataStore.DataStoreProperty;
import malanc.realestateapp.Models.Property;

public class ApprovePendingProperties {

    public static void displayPendingProperties() {
        JFrame frame = new JFrame("Approve Pending Properties");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the table with custom TableModel
        PropertyTableModel tableModel = new PropertyTableModel();
        JTable table = new JTable(tableModel);

        // Set column widths and cell alignment
        setTableFormatting(table);

        // Set custom renderer for the buttons in the last column
        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), frame, tableModel, table));

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Adjust row height for better button visibility
        table.setRowHeight(30);

        frame.setSize(1200, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to set column widths and alignment
    private static void setTableFormatting(JTable table) {
        int[] columnWidths = {40, 120, 150, 100, 120, 60, 60, 80, 100, 120, 100, 100, 80, 80, 100, 150, 100, 100, 120, 100};
        for (int i = 0; i < columnWidths.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }

        // Center-align columns with numeric data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount() - 1; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // Custom TableModel for Property data
    static class PropertyTableModel extends AbstractTableModel {
        private final String[] columns = {
            "ID", "Name", "Address", "City", "Owner Name", "Floors",
            "Rooms", "Bathrooms", "Price", "Square Footage", "Year Built", "Property Type", "Energy Efficient", 
            "HOA Fees", "Pet Friendly", "Proximity to Amenities", "Safety Rating", "Property Tax Rate", "School District", "Action"
        };
        private final java.util.List<Property> properties;

        public PropertyTableModel() {
            this.properties = DataStoreProperty.getPendingProperties();
        }

        @Override
        public int getRowCount() {
            return properties.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columns[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Property property = properties.get(rowIndex);
            switch (columnIndex) {
                case 0: return property.getId();
                case 1: return property.getName() != null ? property.getName() : "N/A";
                case 2: return property.getAddress() != null ? property.getAddress() : "N/A";
                case 3: return property.getCity() != null ? property.getCity().name() : "N/A";
                case 4: return property.getOwnerName() != null ? property.getOwnerName() : "N/A";
                case 5: return property.getFloors() != 0 ? property.getFloors() : "N/A";
                case 6: return property.getRooms() != 0 ? property.getRooms() : "N/A";
                case 7: return property.getBathrooms() != 0 ? property.getBathrooms() : "N/A";
                case 8: return property.getPrice() != 0 ? property.getPrice() : "N/A";
                case 9: return property.getSquareFootage() != 0 ? property.getSquareFootage() : "N/A";
                case 10: return property.getYearBuilt() != 0 ? property.getYearBuilt() : "N/A";
                case 11: return property.getType() != null ? property.getType().name() : "N/A";
                case 12: return property.isEnergyEfficient() ? "Yes" : "No";
                case 13: return property.hasHoaFees() ? "Yes" : "No";
                case 14: return property.isPetFriendly() ? "Yes" : "No";
                case 15: return property.getProximityToAmenities() != null ? property.getProximityToAmenities() : "N/A";
                case 16: return property.getSafetyRating() != null ? property.getSafetyRating() : "N/A";
                case 17: return property.getPropertyTaxRate() != 0 ? property.getPropertyTaxRate() : "N/A";
                case 18: return property.getSchoolDistrict() != null ? property.getSchoolDistrict() : "N/A";
                case 19: return "Approve / Decline";
                default: return "N/A";
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 19; // Only the "Action" column is editable
        }

        public void approveProperty(int rowIndex) {
            Property property = properties.get(rowIndex);

            // Generate a unique ID for the approved property if necessary
            int newId = generateUniqueId();
            property.setId(newId);

            // Remove from pending list and add to main properties list
            DataStoreProperty.getPendingProperties().remove(property); // Remove from pending list
            DataStoreProperty.addProperty(property); // Add to main properties list with unique ID

            fireTableRowsDeleted(rowIndex, rowIndex); // Refresh table display
        }

        public void declineProperty(int rowIndex) {
            properties.remove(rowIndex); // Just remove from pending list without approval
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        // Method to generate a unique ID
        private int generateUniqueId() {
            int maxId = 0;
            for (Property prop : DataStoreProperty.getProperties()) { // Assuming getProperties() returns the main list
                if (prop.getId() > maxId) {
                    maxId = prop.getId();
                }
            }
            return maxId + 1; // Increment to get a unique ID
        }
    }

    // Custom renderer for buttons in JTable
    static class ButtonRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            JButton approveButton = new JButton("Approve");
            JButton declineButton = new JButton("Decline");
            approveButton.setBackground(new Color(76, 175, 80));
            approveButton.setForeground(Color.WHITE);
            declineButton.setBackground(new Color(220, 53, 69));
            declineButton.setForeground(Color.WHITE);
            panel.add(approveButton);
            panel.add(declineButton);
            return panel;
        }
    }

    // Custom editor for buttons in JTable
    static class ButtonEditor extends DefaultCellEditor {
        private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        private final JButton approveButton = new JButton("Approve");
        private final JButton declineButton = new JButton("Decline");
        private final PropertyTableModel tableModel;
        private final JTable table;

        public ButtonEditor(JCheckBox checkBox, JFrame frame, PropertyTableModel tableModel, JTable table) {
            super(checkBox);
            this.tableModel = tableModel;
            this.table = table;

            approveButton.setBackground(new Color(76, 175, 80));
            approveButton.setForeground(Color.WHITE);
            declineButton.setBackground(new Color(220, 53, 69));
            declineButton.setForeground(Color.WHITE);

            // Add action listeners
            approveButton.addActionListener(e -> approveAction());
            declineButton.addActionListener(e -> declineAction());

            panel.add(approveButton);
            panel.add(declineButton);
        }

        private void approveAction() {
            int row = table.getEditingRow();
            tableModel.approveProperty(row);
        }

        private void declineAction() {
            int row = table.getEditingRow();
            tableModel.declineProperty(row);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }
}
