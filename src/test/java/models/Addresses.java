package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Addresses {
    public static User userBuilder;
    private String lastName;
    private String firstName;
    private String company;
    private String address;
    private String postCode;
    private String city;
    private String country;
    private String phone;
    private String mobile;
    private String state;
    private String alias;

}
