package com.KDGroup.Knowledge_Deck.controllers;


import com.KDGroup.Knowledge_Deck.models.MasterMenu;
import com.KDGroup.Knowledge_Deck.models.SubMenu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class FetchRoleMenuAppController {

    private  String topCourses;
    private  String topUniversity;
    private  String trendingNow;

    // thinking to return na object with all the info , including Menu
    //hashmap needs to be created here , that is to be sent as menu to the front end.
    Map<MasterMenu, SubMenu> studentMap= new HashMap<>();
    private ResponseEntity<?> fetchOfStudent(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

   // info section, but ye sab se achha h ki object me hee ye sab return kar du , with map

    private String topCourses(){
        return topCourses;
    }

    private String topUniversity(){
        return topUniversity;
    }

    private String trendingNow(){
        return trendingNow;
    }
}

/*

    # 1. APIs for CRUD of student
    $ done in Home Controller -> respective controller



    # 2. My Applications - The student will be able to see all the
         applications that he has bookmarked to apply later or all the
         applications/courses he has applied in the past.
        //map the application to the student one's he has applied


    # 3. Payment/Transactions - The student can view his
         payment/transaction history by clicking on this option. He
         will be able to see all the history of past payments he has
         done towards the application he applied for.
         // use an api for payment how to map IDK , will need help here

    #4. Search courses - The student will have a search field
        where he can search the courses by clicking on the search
        button, this will take him to the detailed courses screen where
        he will be able to see different courses offered.
        // courses ka ek table with relevant details mapped to particular school

    #5. Information sections :
    5.1 - Top Courses : This will be a square/rectangular section
    (based on the designer’s configuration) which will highlight
    top courses at that point in time. This section is dynamic and
    based on the back-end teams’ configuration they will be able
    to change the details in it. The backend team will have an
    option with a pre-defined control template to just refresh the
    information in the Top courses area whenever they want. // top courses api , just a string to return

    5.2 - Top Universities - This will be a square/rectangular
    section (based on the designers’ configuration) which will
    highlight top courses at that point in time. This section is
    dynamic and based on the back-end teams’ configuration
    they will be able to change the details in it. The backend
    team will have an option with a pre-defined control template
    to just refresh the information in the Top courses area
    whenever they want. //same as above

    5.3 - Trending now - This will be a square/rectangular
    section (based on the designers’ configuration) which will
    highlight top courses at that point in time. This section is
    dynamic and based on the back-end teams’ configuration
    they will be able to change the details in it. The backend
    team will have an option with a pre-defined control template
    to just refresh the information in the Top courses area
    whenever they want. // same as above




//crud to self
// api for payment and mapping to student
// courses table
// baaki easy strings
*/
