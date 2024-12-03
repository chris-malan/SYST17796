package malanc.realestateapp.Action.Agent;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;
import malanc.realestateapp.DataStore.DataStoreBooking;
import malanc.realestateapp.Models.Booking;
import malanc.realestateapp.Models.User;
import malanc.realestateapp.DataStore.DataStoreUser;

public class ApproveBooking {

    private static String loggedInAgentName; // Store the logged-in agent name

    public static void loginAsAgent(String agentName) {
        loggedInAgentName = agentName; // Set the logged-in agent's name
    }

    public static void displayApproveBookings() {
        if (loggedInAgentName == null) {
            JOptionPane.showMessageDialog(null, "Agent name not set. Please log in as an agent.");
            return;
        }

        JFrame frame = new JFrame("Approve Bookings for " + loggedInAgentName);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the table with custom TableModel
        BookingTableModel tableModel = new BookingTableModel(DataStoreBooking.getPendingBookingsByAgent(loggedInAgentName));
        JTable table = new JTable(tableModel);

        setTableFormatting(table);

        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), tableModel, table));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to set table formatting for uniform column width and alignment
    private static void setTableFormatting(JTable table) {
        int[] columnWidths = {40, 150, 100, 100, 120, 100, 80};
        for (int i = 0; i < columnWidths.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.setRowHeight(30); // Set row height for better visibility of the Approve button
    }

    // Custom TableModel for Booking data
    static class BookingTableModel extends AbstractTableModel {
        private final String[] columns = {
            "ID", "Customer Name", "Date", "Time", "Agent Name", "User Type", "Action"
        };
        private final List<Booking> bookings;

        public BookingTableModel(List<Booking> bookings) {
            this.bookings = bookings;
        }

        @Override
        public int getRowCount() {
            return bookings.size();
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
            Booking booking = bookings.get(rowIndex);
            switch (columnIndex) {
                case 0: return booking.getId();
                case 1: return booking.getFirstName() + " " + booking.getLastName();
                case 2: return booking.getDate();
                case 3: return booking.getTime();
                case 4: return booking.getAgentName();
                case 5: // Fetch user type from DataStoreUser or Booking data
                    User user = DataStoreUser.findUserByUsername(booking.getUsername());
                    if (user != null) {
                        System.out.println("User found: " + user.getUsername() + ", Role: " + user.getRole()); // Debug output
                        return user.getRole() != null ? user.getRole().toString() : "Unknown";
                    } else {
                        System.out.println("User not found for username: " + booking.getUsername()); // Debug output
                        return "Unknown";
                    }
                case 6: return "Approve";
                default: return "N/A";
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 6; // Only the "Action" column is editable
        }

        public void approveBooking(int rowIndex) {
            Booking booking = bookings.get(rowIndex);
            DataStoreBooking.approveBooking(booking); // Set booking as approved
            bookings.remove(rowIndex); // Remove the approved booking from the list
            fireTableRowsDeleted(rowIndex, rowIndex); // Refresh table
        }
    }

    // Renderer for the "Approve" button in the Action column
    static class ButtonRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            JButton button = new JButton("Approve");
            button.setBackground(new Color(76, 175, 80));
            button.setForeground(Color.WHITE);
            return button;
        }
    }

    // Editor for the "Approve" button in the Action column
    static class ButtonEditor extends DefaultCellEditor {
        private final JButton button;
        private final BookingTableModel tableModel;
        private final JTable table;

        public ButtonEditor(JCheckBox checkBox, BookingTableModel tableModel, JTable table) {
            super(checkBox);
            this.tableModel = tableModel;
            this.table = table;
            button = new JButton("Approve");
            button.setBackground(new Color(76, 175, 80));
            button.setForeground(Color.WHITE);
            button.addActionListener(e -> approveAction());
        }

        private void approveAction() {
            int row = table.getEditingRow();
            tableModel.approveBooking(row);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Approve";
        }
    }
}
