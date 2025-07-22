package utils;

public class UserData {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String postcode;
    public String phone;
    public String email;
    public String country;
    public UserData() {}

    public UserData(String firstName, String lastName, String address, String city,
                    String state, String postcode, String phone, String email, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
        this.country = country;
    }
}
