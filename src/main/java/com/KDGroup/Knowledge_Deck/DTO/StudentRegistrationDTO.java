package com.KDGroup.Knowledge_Deck.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentRegistrationDTO {

    // all common ones and only these much are neeeded for students as of now

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String Gender;


    private String homeAddress;
    private String emailId;
    private Long phoneNumber;
    private String school; /* if present, insititute will autopopulate or else "other" but work of UI */


    private String username; /* user_table */
    private String password; /* user_table */
    private String confirmPassword;

}
