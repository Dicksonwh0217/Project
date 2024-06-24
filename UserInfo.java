public class UserInfo {
    private String name;
    private String userID;

    public UserInfo() {
    }

    // Tell user to enter first name and surname
    public void setName(String name) {
    	this.name = name;
    	setUserID();
    }

    // Check if the name entered contains space(s)
    private boolean spaces(String name) {
        return name.contains(" ");
    }

    // Generate user ID based on the name
    public void setUserID() {
        if (spaces(name)) {
            String[] names = name.split(" ");
            userID = Character.toUpperCase(names[0].charAt(0)) + names[names.length - 1];
        } else {
            userID = "guest";
        }
    }

    // Get the name of the user
    public String getName() {
        return name;
    }

    // Get the user ID
    public String getUserID() {
        return userID;
    }

}
