package com.KDGroup.Knowledge_Deck.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {

    // all common ones and only these much are neeeded for students as of now

    private String name;
    private String email;
    private Long phoneNumber;
    private String password;
    private String repeat;

    // for school one additional
    private String address;


}
