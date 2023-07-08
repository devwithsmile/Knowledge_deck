package com.KDGroup.Knowledge_Deck.DTO;

import com.KDGroup.Knowledge_Deck.models.CourseInfo;
import com.KDGroup.Knowledge_Deck.models.Schools;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentApplicationDTO {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String Gender;


    private String homeAddress;
    private String emailId;
    private Long phoneNumber;
    private Schools school;
    private CourseInfo Course;

    private boolean bookmarked  = false;
    private boolean fessPaid = false;


}
