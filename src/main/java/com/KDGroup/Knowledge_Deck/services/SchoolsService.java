package com.KDGroup.Knowledge_Deck.services;
//
//import com.KDGroup.Knowledge_Deck.models.Schools;

import com.KDGroup.Knowledge_Deck.DTO.PartnerAssociateRegistrationDTO;
import com.KDGroup.Knowledge_Deck.DTO.SchoolRegistrationDTO;
import com.KDGroup.Knowledge_Deck.DTO.StudentRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.Students;

public interface SchoolsService {

    String registerSchool(SchoolRegistrationDTO registrationDTO);

    boolean doesEmailExist(String emailId);
}
