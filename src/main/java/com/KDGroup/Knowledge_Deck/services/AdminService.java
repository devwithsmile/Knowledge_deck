package com.KDGroup.Knowledge_Deck.services;

import com.KDGroup.Knowledge_Deck.DTO.AdminRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.Admin;

public interface AdminService {
    String registerAdmin(AdminRegistrationDTO registrationDTO);

    boolean doesEmailExist(String emailId);
}
