package malanc.realestateapp.UserType;

import malanc.realestateapp.Models.User;
import malanc.realestateapp.Models.UserRole;
import malanc.realestateapp.UserPage.AgentPage;

public class AgentUser extends User {

    public AgentUser(String firstName, String lastName, String cellphone, String username, String password, String email) {
        super(firstName, lastName, cellphone, username, password, email, UserRole.AGENT);  // Pass "Agent" as role
    }

    @Override
    public boolean displayUserOptions() {
        AgentPage.displayAgentOptions();  // Directly call the agent options page
        return false; // Return false if user isn't logging out
    }
}
