package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Students",uniqueConstraints =@UniqueConstraint(columnNames = "email"))
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private String email;
    private String password;
    private long ph_number;
    
    //will have one school which either he is applying to or is enrolled in.
    @OneToOne
    @Autowired
    private Schools schools;

}
