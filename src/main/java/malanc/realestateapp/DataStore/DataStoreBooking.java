package malanc.realestateapp.DataStore;

import malanc.realestateapp.Models.Booking;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStoreBooking {

    // List to store all bookings
    private static List<Booking> bookings = new ArrayList<>();

    // Counter to assign unique IDs to bookings
    private static int bookingIdCounter = 1;

    static {
        // Initialize with sample bookings
        initializeRealisticBookings();
    }

    // Add a new booking with validation
    public static boolean addBooking(Booking booking) {
        // Validate essential booking details
        if (booking.getDate() == null || booking.getTime() == null || booking.getAgentName() == null || booking.getUsername() == null) {
            System.out.println("Invalid booking details.");
            return false; // Indicate unsuccessful addition
        }

        // Assign a unique ID to the booking and add to list
        booking.setId(bookingIdCounter++);
        bookings.add(booking);
        return true; // Indicate successful addition
    }

    // Retrieve all bookings
    public static List<Booking> getAllBookings() {
        return bookings;
    }

    // Retrieve bookings by agent's name
    public static List<Booking> getBookingsByAgent(String agentName) {
        return bookings.stream()
                .filter(booking -> agentName != null && agentName.equalsIgnoreCase(booking.getAgentName()))
                .collect(Collectors.toList());
    }

    // Retrieve bookings by user (customer or owner)
    public static List<Booking> getBookingsByUser(String username) {
        return bookings.stream()
                .filter(booking -> username != null && username.equalsIgnoreCase(booking.getUsername()))
                .collect(Collectors.toList());
    }

    // Retrieve upcoming bookings
    public static List<Booking> getUpcomingBookings() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        return bookings.stream()
                .filter(booking -> booking.getDate() != null &&
                                   (booking.getDate().isAfter(today) || 
                                   (booking.getDate().isEqual(today) && booking.getTime().isAfter(now))))
                .collect(Collectors.toList());
    }

    // Retrieve past bookings
    public static List<Booking> getPastBookings() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        return bookings.stream()
                .filter(booking -> booking.getDate() != null &&
                                   (booking.getDate().isBefore(today) || 
                                   (booking.getDate().isEqual(today) && booking.getTime().isBefore(now))))
                .collect(Collectors.toList());
    }

    // Approve a booking
    public static void approveBooking(Booking booking) {
        booking.setApproved(true);
    }

    // Reject a booking
    public static void rejectBooking(Booking booking) {
        booking.setApproved(false);
    }

    // Find a booking by ID
    public static Booking findBookingById(int bookingId) {
        return bookings.stream()
                .filter(booking -> booking.getId() == bookingId)
                .findFirst()
                .orElse(null);
    }

    // Method to add realistic bookings with unique IDs
    private static void initializeRealisticBookings() {
        // Bookings for existing customers and owners with each agent

        // Booking for Jane Smith (Customer) with Agent Daniel Wilson
        bookings.add(createBooking("Jane", "Smith", "0987654321", "customer1@example.com", "Daniel Wilson", "customer1", LocalDate.of(2025, 1, 5), LocalTime.of(10, 30)));

        // Booking for Jane Smith (Customer) with Agent Emma Taylor
        bookings.add(createBooking("Jane", "Smith", "0987654321", "customer1@example.com", "Emma Taylor", "customer1", LocalDate.of(2025, 1, 6), LocalTime.of(11, 45)));

        // Booking for Emily Johnson (Customer) with Agent Daniel Wilson
        bookings.add(createBooking("Emily", "Johnson", "5678901234", "customer2@example.com", "Daniel Wilson", "customer2", LocalDate.of(2025, 1, 7), LocalTime.of(14, 0)));

        // Booking for Emily Johnson (Customer) with Agent Emma Taylor
        bookings.add(createBooking("Emily", "Johnson", "5678901234", "customer2@example.com", "Emma Taylor", "customer2", LocalDate.of(2025, 1, 8), LocalTime.of(15, 30)));

        // Booking for Michael Brown (Owner) with Agent Daniel Wilson
        bookings.add(createBooking("Michael", "Brown", "2345678901", "owner1@example.com", "Daniel Wilson", "owner1", LocalDate.of(2025, 1, 9), LocalTime.of(9, 15)));

        // Booking for Michael Brown (Owner) with Agent Emma Taylor
        bookings.add(createBooking("Michael", "Brown", "2345678901", "owner1@example.com", "Emma Taylor", "owner1", LocalDate.of(2025, 1, 10), LocalTime.of(10, 45)));

        // Booking for Sarah Davis (Owner) with Agent Daniel Wilson
        bookings.add(createBooking("Sarah", "Davis", "6789012345", "owner2@example.com", "Daniel Wilson", "owner2", LocalDate.of(2025, 1, 11), LocalTime.of(13, 0)));

        // Booking for Sarah Davis (Owner) with Agent Emma Taylor
        bookings.add(createBooking("Sarah", "Davis", "6789012345", "owner2@example.com", "Emma Taylor", "owner2", LocalDate.of(2025, 1, 12), LocalTime.of(14, 30)));

        // Randomly approve some bookings
        bookings.get(1).setApproved(true);
        bookings.get(4).setApproved(true);
        bookings.get(7).setApproved(true);
    }

    // Helper method to create a booking and assign a unique ID
    private static Booking createBooking(String firstName, String lastName, String cellphone, String email, String agentName, String username, LocalDate date, LocalTime time) {
        Booking booking = new Booking(firstName, lastName, cellphone, email, agentName, username, date, time);
        booking.setId(bookingIdCounter++); // Assign a unique ID
        return booking;
    }
    
    public static List<Booking> getPendingBookings() {
        return bookings.stream()
                .filter(booking -> !booking.isApproved())
                .collect(Collectors.toList());
    }

    // Retrieve pending bookings for a specific agent
    public static List<Booking> getPendingBookingsByAgent(String agentName) {
        return bookings.stream()
                .filter(booking -> !booking.isApproved() && agentName.equalsIgnoreCase(booking.getAgentName()))
                .collect(Collectors.toList());
    }
}
