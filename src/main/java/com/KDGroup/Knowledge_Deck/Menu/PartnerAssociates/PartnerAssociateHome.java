package com.KDGroup.Knowledge_Deck.Menu.PartnerAssociates;

import com.KDGroup.Knowledge_Deck.Menu.Schools.AdmissionForm3;
import com.KDGroup.Knowledge_Deck.Menu.Students.AdmissionForm;

public class PartnerAssociateHome {
    private boolean login;
    private AdmissionForm studentform;
    private AdmissionForm2 admissionForm2;
    private AdmissionForm3 admissionForm3;

    //no constructor here as  of now 

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public AdmissionForm getStudentform() {
        return studentform;
    }

    public void setStudentform(AdmissionForm studentform) {
        this.studentform = studentform;
    }

    public AdmissionForm2 getAdmissionForm2() {
        return admissionForm2;
    }

    public void setAdmissionForm2(AdmissionForm2 admissionForm2) {
        this.admissionForm2 = admissionForm2;
    }

    public AdmissionForm3 getAdmissionForm3() {
        return admissionForm3;
    }

    public void setAdmissionForm3(AdmissionForm3 admissionForm3) {
        this.admissionForm3 = admissionForm3;
    }

}
