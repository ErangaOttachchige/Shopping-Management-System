public class User {
    private String username;
    private String password;


    // Constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Default constructor
    public User() {
        this.username = "default";
        this.password = "default";
    }

    public String getUsername() {
        return username;                               // This is a getter
    }
    public String getPassword() {
        return password;                               // This is a getter
    }
    public void setUsername(String username) {
        this.username = username;                        // This is a setter
    }
    public void setPassword(String password) {
        this.password = password;                        // This is a setter
    }

    @Override
    public String toString() {                                              // This is a toString method
        return "Username: " + getUsername() + "\n" +
                "Password: " + getPassword() + "\n";
    }
}
