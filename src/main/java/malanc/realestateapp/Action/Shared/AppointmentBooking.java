package malanc.realestateapp.Action.Shared;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import malanc.realestateapp.Models.Booking;
import malanc.realestateapp.DataStore.DataStoreBooking;
import malanc.realestateapp.DataStore.DataStoreUser;

public class AppointmentBooking {

    public static void bookAppointment(String currentUsername) {
        // Define fields for booking appointment details
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField cellphoneField = new JTextField();
        JTextField emailField = new JTextField();
        
        // Fetch real agent names from DataStoreUser
        JComboBox<String> agentDropdown = new JComboBox<>(DataStoreUser.getAgentRealNames().toArray(new String[0]));
        
        // Date picker using JSpinner with SpinnerDateModel
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());

        // Format the date and time spinners
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm"));

        // Create a panel for input form
        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Cellphone:"));
        panel.add(cellphoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Select Agent:"));
        panel.add(agentDropdown);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateSpinner);
        panel.add(new JLabel("Time (HH:MM):"));
        panel.add(timeSpinner);

        int result;
        do {
            result = JOptionPane.showConfirmDialog(null, panel, "Book Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    // Collect booking details
                    String firstName = firstNameField.getText().trim();
                    String lastName = lastNameField.getText().trim();
                    String cellphone = cellphoneField.getText().trim();
                    String email = emailField.getText().trim();
                    String agentName = (String) agentDropdown.getSelectedItem();

                    // Get selected date and time from spinners
                    Date selectedDate = (Date) dateSpinner.getValue();
                    Date selectedTime = (Date) timeSpinner.getValue();

                    // Convert selected Date and Time to LocalDate and LocalTime
                    LocalDate bookingDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalTime bookingTime = selectedTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                    // Validate required fields
                    if (firstName.isEmpty() || lastName.isEmpty() || cellphone.isEmpty() || email.isEmpty() || agentName == null) {
                        JOptionPane.showMessageDialog(null, "All fields are required. Please complete the form.");
                    } else {
                        Booking booking = new Booking(firstName, lastName, cellphone, email, agentName, currentUsername, bookingDate, bookingTime);

                        // Add booking to DataStoreBooking
                        if (DataStoreBooking.addBooking(booking)) {
                            JOptionPane.showMessageDialog(null, "Your agent will soon contact you. Thank you!");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Booking could not be added. Please check details and try again.");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid date and time.");
                }
            } else {
                break;
            }
        } while (true);
    }
}
