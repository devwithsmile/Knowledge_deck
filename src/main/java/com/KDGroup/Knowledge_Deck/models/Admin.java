package com.KDGroup.Knowledge_Deck.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin", uniqueConstraints = {@UniqueConstraint(columnNames = {"emailId"}), @UniqueConstraint(columnNames = {"username"})})
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private String emailId;
    private Long phoneNumber;
    private String username;
    private String password;
    private String confirmPassword;


}
