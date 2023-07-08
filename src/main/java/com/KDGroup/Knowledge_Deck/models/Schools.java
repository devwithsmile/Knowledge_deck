package com.KDGroup.Knowledge_Deck.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Schools", uniqueConstraints = {@UniqueConstraint(columnNames = {"emailId"}), @UniqueConstraint(columnNames = {"username"})})
public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;
    private String instituteName;
    private String emailId;
    private String address;
    private Long phoneNumber;
    private String username;
    private String password;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<CourseInfo> courses;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Students> students;


}
