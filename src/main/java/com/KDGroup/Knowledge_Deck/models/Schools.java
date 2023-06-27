package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Schools")
public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Email_id;
    private String password;
    private long ph_number;
    
    
    @Column(name = "cutoff")
    private long cutoff;

    public Schools() {
        // default constructor
    }

   

    public Schools(Long id, String name, String email_id, String password, long ph_number, long cutoff) {
		super();
		this.id = id;
		this.name = name;
		Email_id = email_id;
		this.password = password;
		this.ph_number = ph_number;
		this.cutoff = cutoff;
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

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }

	public Long getcutoff() {
		return cutoff;
	}

	public void setcutoff(Long cutoff) {
		this.cutoff = cutoff;
	}
}
