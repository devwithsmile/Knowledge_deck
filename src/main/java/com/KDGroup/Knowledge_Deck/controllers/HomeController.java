package com.KDGroup.Knowledge_Deck.controllers;

import com.KDGroup.Knowledge_Deck.DTO.StudentApplicationDTO;
import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;
import com.KDGroup.Knowledge_Deck.models.Schools;
import com.KDGroup.Knowledge_Deck.models.Students;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.PartnerAssociateServiceImpl;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.SchoolsServiceImpl;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.StudentServiceImpl;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final StudentServiceImpl studentService;
    private final SchoolsServiceImpl schoolsService;
    private final PartnerAssociateServiceImpl partnerAssociateService;
    private final UserServiceImpl userService;


 // role can be found from specific url b4 this url was hit to log in , email wo khud daalega

    @GetMapping("/{role}/{email}")
    private ResponseEntity<?> getObjectBasedOnRoleAndEmail(@PathVariable("role") String role, @PathVariable("email") String email) {
        switch (role) {
            case "student":
                Students studentObj = studentService.getStudentsByEmailId(email);
                if (studentObj == null)
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(studentObj, HttpStatus.OK);

            case "school":
                Schools schoolsObj = schoolsService.getSchoolByEmailId(email);
                if (schoolsObj == null)
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(schoolsObj, HttpStatus.OK);

            case "PA":
                PartnerAssociate partnerObj = partnerAssociateService.getPartnerByEmailId(email);
                if (partnerObj == null)
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(partnerObj, HttpStatus.OK);

            default:
                return new ResponseEntity<>("Invalid role specified", HttpStatus.BAD_REQUEST);
        }
    }


    // for filling the application

    private ResponseEntity<?> submitApplication(@RequestBody StudentApplicationDTO studentApplicationDTO){

        return new ResponseEntity<>("Application Form Saved",HttpStatus.OK);
    }

}



/*_________________________What I have to do , what is done and how to do & how is done _________________________ */
/*
*  user's can perform RUD operations on self after this , as this will send whole object,
*  which will have Id as well and update by ID wala code is written in their respective Controller.
*
*
* */
