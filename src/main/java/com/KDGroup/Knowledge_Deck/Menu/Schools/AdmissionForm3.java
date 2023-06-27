package com.KDGroup.Knowledge_Deck.Menu.Schools;

import com.KDGroup.Knowledge_Deck.Menu.PartnerAssociates.AdmissionForm2;

public class AdmissionForm3 {
    // studentform2 will be coming if manually accepted, revert back for payment
    //I havent created the constructor , I dont think it will be needeed but I might be wrong here

    private AdmissionForm2 admissionForm2;
    private boolean accepted;

    //payment amount 
    private int payment;
    
    //payment status done or no
    private  boolean payment_recived;

    public AdmissionForm2 getAdmissionForm2() {
        return admissionForm2;
    }

    public void setAdmissionForm2(AdmissionForm2 admissionForm2) {
        this.admissionForm2 = admissionForm2;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public boolean isPayment_recived() {
        return payment_recived;
    }

    public void setPayment_recived(boolean payment_recived) {
        this.payment_recived = payment_recived;
    }

}
