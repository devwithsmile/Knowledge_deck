package com.KDGroup.Knowledge_Deck.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdmissionForm {

    private String Salutation;
    private String first_name;
    private String middle_name;
    private String last_name;

    // basic details
    private int gender;
    private String address;
    private String country;
    private String email_id;

    // Contact and emergency contacts
    private int ph_no;
    private int emergency_contact_no;
    private String relationship;

    // education details
    private String course1;
    private String course1_year;
    private int course1_grade;

    private String course2;
    private String course2_year;
    private int course2_grade;

    private String course3;
    private String course3_year;
    private int course3_grade;

    // confirmation before submitting the form
    private boolean confirmation;

}
