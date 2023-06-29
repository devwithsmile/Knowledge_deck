package com.KDGroup.Knowledge_Deck.services;

import com.KDGroup.Knowledge_Deck.models.Students;
import com.KDGroup.Knowledge_Deck.DTO.AdmissionForm;
import com.KDGroup.Knowledge_Deck.DTO.StudentHome;
import com.KDGroup.Knowledge_Deck.DTO.StudentProfile;

public interface StudentService {
    // to save student home details
    Students saveHome(StudentHome studentHome);

    // to save student Admission Form details
    Students saveForm(AdmissionForm admissionForm);

    // to save student profile, but there is nothig in it as of now
    Students saveProfile(StudentProfile studentProfile);

}
