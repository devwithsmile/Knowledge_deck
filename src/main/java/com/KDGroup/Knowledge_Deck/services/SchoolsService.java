package com.KDGroup.Knowledge_Deck.services;

import com.KDGroup.Knowledge_Deck.models.Schools;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.AdmissionForm;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.StudentHome;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.StudentProfile;

public interface SchoolsService {
    // to save Partner home details
    Schools saveHome(StudentHome studentHome);

    // to save Partner Admission Form details
    Schools saveForm(AdmissionForm admissionForm);

    // to save Partner profile, but there is nothig in it as of now
    Schools saveProfile(StudentProfile studentProfile);

}
