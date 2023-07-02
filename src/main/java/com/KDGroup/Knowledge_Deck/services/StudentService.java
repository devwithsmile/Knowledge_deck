package com.KDGroup.Knowledge_Deck.services;

import com.KDGroup.Knowledge_Deck.DTO.StudentRegistrationDTO;
import com.KDGroup.Knowledge_Deck.DTO.StudentRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.Students;

public interface StudentService {
    //registeration Form
    Students registerStudents(StudentRegistrationDTO registrationDTO);

    boolean doesEmailExist(String emailId);
}
