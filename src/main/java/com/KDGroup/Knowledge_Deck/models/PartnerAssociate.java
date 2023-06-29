package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
	

}
