package malanc.realestateapp.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int id;
    private String firstName;
    private String lastName;
    private String cellphone;
    private String email;
    private String agentName;
    private String username; // Can be customer or owner username
    private LocalDate date; // Changed to LocalDate
    private LocalTime time; // Changed to LocalTime
    private boolean isApproved;

    // Constructor
    public Booking(String firstName, String lastName, String cellphone, String email, String agentName, String username, LocalDate date, LocalTime time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.email = email;
        this.agentName = agentName;
        this.username = username;
        this.date = date;
        this.time = time;
        this.isApproved = false; // Default to not approved
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Other Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
