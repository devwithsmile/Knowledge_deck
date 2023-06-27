package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Partners", uniqueConstraints =@UniqueConstraint(columnNames = "Email_id") )
public class PartnerAssociate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String password;
	private long ph_number;
	private String Email_id;
	private DeckRole Role = DeckRole.Partner_Associate;
	


	public PartnerAssociate() {
		// default constructor
	}

	public PartnerAssociate(Long id, String name, String password, long ph_number, String email_id, DeckRole role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.ph_number = ph_number;
		Email_id = email_id;
		Role = role;
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

	public DeckRole getRole() {
		return Role;
	}

	public void setRole(DeckRole role) {
		Role = role;
	}


}
