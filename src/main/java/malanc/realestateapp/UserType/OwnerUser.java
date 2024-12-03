package malanc.realestateapp.UserType;

import malanc.realestateapp.Models.User;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.UserPage.OwnerPage;

public class OwnerUser extends User {

    public OwnerUser(String firstName, String lastName, String cellphone, String username, String password, String email) {
        super(firstName, lastName, cellphone, username, password, email, UserRole.OWNER);  // Pass "Owner" as role
    }

    @Override
    public boolean displayUserOptions() {
        OwnerPage.displayOwnerOptions(this);  // Pass the entire OwnerUser object to OwnerPage
        return false; // Return false if user isn't logging out
    }
}
