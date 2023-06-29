package com.KDGroup.Knowledge_Deck.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Schools", uniqueConstraints = @UniqueConstraint(columnNames = "Email_id"))
public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Email_id;
    private String password;
    private long ph_number;
    private String university;
    private String course;

    @Column(name = "cutoff")
    private long cutoff;

    // schools will have multiple students enrolled in them
    @ManyToMany
    @JoinTable(name = "School_studsent")
    private Collection<Students> students;

}
