package malanc.realestateapp.Models;

public abstract class User {
    private String firstName;
    private String lastName;
    private String cellphone;
    private String username;
    private String password;
    private String email;
    protected UserRole role; // Use UserRole enum for role

    // Constructor
    public User(String firstName, String lastName, String cellphone, String username, String password, String email, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role; // Initialize role with UserRole enum
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    // New helper method to get the full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Abstract method to display user-specific options; returns true if logged out, false otherwise
    public abstract boolean displayUserOptions();

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role + // Adjusted to print UserRole
                '}';
    }
}
