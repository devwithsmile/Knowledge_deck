package com.KDGroup.Knowledge_Deck.Menu;

public class RegisterationForm {

    // all common ones and only these much are neeeded for students as of now
    private Long id;
    private String name;
    private String email;
    private int ph_number;
    private String password;

    // for school one additional
    private String address;

    public RegisterationForm(String name, String email, int ph_number, String password) {
        this.name = name;
        this.email = email;
        this.ph_number = ph_number;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPh_number() {
        return ph_number;
    }

    public void setPh_number(int ph_number) {
        this.ph_number = ph_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
