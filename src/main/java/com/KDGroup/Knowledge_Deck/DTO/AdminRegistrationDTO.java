package com.KDGroup.Knowledge_Deck.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRegistrationDTO {
    private String firstName;
    private String lastName;

    private String emailId;
    private Long phoneNumber;
    private String username;
    private String password;
    private String confirmPassword;

}
