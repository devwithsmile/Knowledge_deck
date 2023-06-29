package com.KDGroup.Knowledge_Deck.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdmissionForm2 {
    // students form wil come here get signed and passed to school
    private AdmissionForm studentForm;
    private boolean signedByPA;

    // to decide to send it to whom like 1 to school 0 for student
    private boolean school_or_student;
    private AdmissionForm3 schoolForm;


}
