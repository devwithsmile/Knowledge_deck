package com.KDGroup.Knowledge_Deck.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolRegistrationDTO {
    private  String schoolName;
    private String instituteName;
    private String emailId;
    private String address;
    private Long phoneNumber;
    private String username;
    private  String password;
}
