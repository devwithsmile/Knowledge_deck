package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Students",uniqueConstraints =@UniqueConstraint(columnNames = "email"))
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private long ph_number;
    
    //will have one school which either he is applying to or is enrolled in.
    @OneToOne
    private Schools schools;

    public Students() {
        // default constructor
    }

    public Schools getSchools() {
        return schools;
    }

    public void setSchools(Schools schools) {
        this.schools = schools;
    }

    public Students(Long id, String name, String email, String password, long ph_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.ph_number = ph_number;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPh_number() {
        return ph_number;
    }

    public void setPh_number(long ph_number) {
        this.ph_number = ph_number;
    }

}
