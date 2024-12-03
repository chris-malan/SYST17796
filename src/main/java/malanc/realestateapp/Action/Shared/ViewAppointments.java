package malanc.realestateapp.Action.Shared;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import malanc.realestateapp.Models.Booking;
import malanc.realestateapp.DataStore.DataStoreBooking;

public class ViewAppointments {

    public static void displayAllAppointments() {
        List<Booking> appointments = DataStoreBooking.getAllBookings(); // Retrieve all bookings

        if (appointments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No appointments available.", "View Appointments", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder appointmentsList = new StringBuilder("<html><body><h2 style='text-align: center; color: #4CAF50;'>All Appointments</h2>");
        appointmentsList.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100%; border-collapse: collapse;'>");

        // Adding table header with styling
        appointmentsList.append("<tr style='background-color: #4CAF50; color: white;'>")
                .append("<th>ID</th>")
                .append("<th>Agent Name</th>")
                .append("<th>Customer First Name</th>")
                .append("<th>Customer Last Name</th>")
                .append("<th>Date</th>")
                .append("<th>Time</th>")
                .append("<th>Status</th>")
                .append("</tr>");

        // Populating table with appointment data
        for (Booking appointment : appointments) {
            appointmentsList.append("<tr>")
                    .append("<td>").append(appointment.getId()).append("</td>")
                    .append("<td>").append(appointment.getAgentName()).append("</td>")
                    .append("<td>").append(appointment.getFirstName()).append("</td>")
                    .append("<td>").append(appointment.getLastName()).append("</td>")
                    .append("<td>").append(appointment.getDate().toString()).append("</td>") // Display date
                    .append("<td>").append(appointment.getTime().toString()).append("</td>") // Display time
                    .append("<td>").append(appointment.isApproved() ? "Approved" : "Pending").append("</td>")
                    .append("</tr>");
        }

        appointmentsList.append("</table></body></html>");

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(appointmentsList.toString());
        textPane.setEditable(false);

        // Adding the JTextPane to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(700, 400)); // Adjust the size as needed
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JOptionPane.showMessageDialog(null, scrollPane, "Appointments List", JOptionPane.INFORMATION_MESSAGE);
    }
}
