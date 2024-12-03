package malanc.realestateapp.UserType;

import malanc.realestateapp.Models.User;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.UserPage.CustomerPage;

public class CustomerUser extends User {

    public CustomerUser(String firstName, String lastName, String cellphone, String username, String password, String email) {
        super(firstName, lastName, cellphone, username, password, email, UserRole.CUSTOMER);  // Pass "Customer" as role
    }

    @Override
    public boolean displayUserOptions() {
        // Pass the username to CustomerPage to allow user-specific actions
        CustomerPage.displayCustomerOptions(this.getUsername());  
        return false; // Return false if user isn't logging out
    }
}
