package com.KDGroup.Knowledge_Deck.web.Menu.Students;

import com.KDGroup.Knowledge_Deck.web.Menu.PartnerAssociates.AdmissionForm2;
import com.KDGroup.Knowledge_Deck.web.Menu.Schools.AdmissionForm3;

public class StudentHome {

    // home will have just a logout button and the forms which are active for
    // addmission . Inspired by SPPU
    private boolean login;
    private AdmissionForm2 form;
    private AdmissionForm3 revertReadyForm;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public AdmissionForm2 getForm() {
        return form;
    }

    public void setForm(AdmissionForm2 form) {
        this.form = form;
    }

    public AdmissionForm3 getRevertReadyForm() {
        return revertReadyForm;
    }

    public void setRevertReadyForm(AdmissionForm3 revertReadyForm) {
        this.revertReadyForm = revertReadyForm;
    }

}
