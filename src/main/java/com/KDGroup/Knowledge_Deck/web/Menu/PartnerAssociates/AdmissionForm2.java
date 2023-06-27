package com.KDGroup.Knowledge_Deck.web.Menu.PartnerAssociates;

import com.KDGroup.Knowledge_Deck.web.Menu.Schools.AdmissionForm3;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.AdmissionForm;

public class AdmissionForm2 {
    // students form wil come here get signed and passed to school
    private AdmissionForm studentform;
    private boolean signedbyPA;

    // to decide to send it to whom like 1 to school 0 for student
    private boolean school_or_student;
    private AdmissionForm3 schoolform;

    public AdmissionForm2(boolean signedbyPA, boolean school_or_student) {
        this.signedbyPA = signedbyPA;
        this.school_or_student = school_or_student;
    }

    public AdmissionForm getStudentform() {
        return studentform;
    }

    public void setStudentform(AdmissionForm studentform) {
        this.studentform = studentform;
    }

    public boolean isSignedbyPA() {
        return signedbyPA;
    }

    public void setSignedbyPA(boolean signedbyPA) {
        this.signedbyPA = signedbyPA;
    }

    public boolean isSchool_or_student() {
        return school_or_student;
    }

    public void setSchool_or_student(boolean school_or_student) {
        this.school_or_student = school_or_student;
    }

    public AdmissionForm3 getSchoolform() {
        return schoolform;
    }

    public void setSchoolform(AdmissionForm3 schoolform) {
        this.schoolform = schoolform;
    }

}
