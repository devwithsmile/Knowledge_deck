package com.KDGroup.Knowledge_Deck.web.Menu.Students;

public class AdmissionForm {

    private int id;
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

    public AdmissionForm(String salutation, String first_name, String middle_name, String last_name, int gender,
            String address, String country, String email_id, int ph_no, int emergency_contact_no, String relationship,
            String course1, String course1_year, int course1_grade, String course2, String course2_year,
            int course2_grade, String course3, String course3_year, int course3_grade, boolean confirmation) {

        Salutation = salutation;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.address = address;
        this.country = country;
        this.email_id = email_id;
        this.ph_no = ph_no;
        this.emergency_contact_no = emergency_contact_no;
        this.relationship = relationship;
        this.course1 = course1;
        this.course1_year = course1_year;
        this.course1_grade = course1_grade;
        this.course2 = course2;
        this.course2_year = course2_year;
        this.course2_grade = course2_grade;
        this.course3 = course3;
        this.course3_year = course3_year;
        this.course3_grade = course3_grade;
        this.confirmation = confirmation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getPh_no() {
        return ph_no;
    }

    public void setPh_no(int ph_no) {
        this.ph_no = ph_no;
    }

    public int getEmergency_contact_no() {
        return emergency_contact_no;
    }

    public void setEmergency_contact_no(int emergency_contact_no) {
        this.emergency_contact_no = emergency_contact_no;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse1_year() {
        return course1_year;
    }

    public void setCourse1_year(String course1_year) {
        this.course1_year = course1_year;
    }

    public int getCourse1_grade() {
        return course1_grade;
    }

    public void setCourse1_grade(int course1_grade) {
        this.course1_grade = course1_grade;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse2_year() {
        return course2_year;
    }

    public void setCourse2_year(String course2_year) {
        this.course2_year = course2_year;
    }

    public int getCourse2_grade() {
        return course2_grade;
    }

    public void setCourse2_grade(int course2_grade) {
        this.course2_grade = course2_grade;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    public String getCourse3_year() {
        return course3_year;
    }

    public void setCourse3_year(String course3_year) {
        this.course3_year = course3_year;
    }

    public int getCourse3_grade() {
        return course3_grade;
    }

    public void setCourse3_grade(int course3_grade) {
        this.course3_grade = course3_grade;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

}
