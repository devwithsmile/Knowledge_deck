package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Partners", uniqueConstraints = {@UniqueConstraint(columnNames = {"emailId"}), @UniqueConstraint(columnNames = {"username"})})
public class PartnerAssociate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String associateFirmName;
	private String emailId;
	private Long phoneNumber;

	private String username; // was not in SRS

}
