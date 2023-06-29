package com.KDGroup.Knowledge_Deck.DTO;

import com.KDGroup.Knowledge_Deck.DTO.AdmissionForm2;
import com.KDGroup.Knowledge_Deck.DTO.AdmissionForm3;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentHome {

    // home will have just a logout button and the forms which are active for
    // addmission . Inspired by SPPU
    private boolean login;
    private AdmissionForm2 form;
    private AdmissionForm3 revertReadyForm;
    //have to take special care of this
    private String topUniversity;


}
