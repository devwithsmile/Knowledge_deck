package com.KDGroup.Knowledge_Deck.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartnerAssociateRegistrationDTO {
    private String firstName;
    private String lastName;
    private String username; //personally given , it was not in SRS
    private String associateFirmName;
    private String emailId;
    private Long phoneNumber;
    private String password;

}
