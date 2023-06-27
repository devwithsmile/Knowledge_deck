package com.KDGroup.Knowledge_Deck.services;

import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.AdmissionForm;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.StudentHome;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.StudentProfile;

public interface PartnerAssociateService {
    // to save Partner home details
    PartnerAssociate saveHome(StudentHome studentHome);

    // to save Partner Admission Form details
    PartnerAssociate saveForm(AdmissionForm admissionForm);

    // to save Partner profile, but there is nothig in it as of now
    PartnerAssociate saveProfile(StudentProfile studentProfile);

}
