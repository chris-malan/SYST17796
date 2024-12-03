package malanc.realestateapp.UserType;

import malanc.realestateapp.Models.User;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.UserPage.AdminPage;

public class AdminUser extends User {

    public AdminUser(String firstName, String lastName, String cellphone, String username, String password, String email) {
        super(firstName, lastName, cellphone, username, password, email, UserRole.ADMIN);  // Pass "Admin" as role
    }

    @Override
    public boolean displayUserOptions() {
        AdminPage.displayAdminOptions();  // Directly call the admin options page
        return false; // Return false if user isn't logging out
    }
}
