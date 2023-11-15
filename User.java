
public class User {
    private int userID;
    private String username;
    private String surname;
    private int houseNumber;
    private String postcode;
    private String city;

    //constructor
    public User(int userID, String username, String surname, int houseNumber, String postcode, String city) {
        this.userID = userID;
        this.username = username;
        this.surname = surname;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
    }

    //getters
    public int getUserID() {
        return userID;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getSurname() {
        return surname;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
    
    public String getPostcode() {
        return postcode;
    }
    
    public String getCity() {
        return city;
    }
    
    //setters  
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
