package com.KDGroup.Knowledge_Deck.DTO;

import com.KDGroup.Knowledge_Deck.DTO.AdmissionForm2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdmissionForm3 {
    // studentform2 will be coming if manually accepted, revert back for payment
    //I havent created the constructor , I dont think it will be needeed but I might be wrong here

    private AdmissionForm2 admissionForm2;
    private boolean accepted;

    //payment amount 
    private int payment;
    
    //payment status done or no
    private  boolean payment_recived;

}
