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

    // schools will have mutlple students enrolled in them
    @ManyToMany
    @JoinTable(name = "School_student")
    private Collection<Students> students;

    public Schools(String name, String email_id, String password, long ph_number, String university,
            Collection<Students> students, String course, long cutoff) {
        this.name = name;
        Email_id = email_id;
        this.password = password;
        this.ph_number = ph_number;
        this.university = university;
        this.students = students;
        this.course = course;
        this.cutoff = cutoff;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Collection<Students> getStudents() {
        return students;
    }

    public void setStudents(Collection<Students> students) {
        this.students = students;
    }

    public long getCutoff() {
        return cutoff;
    }

    public void setCutoff(long cutoff) {
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
