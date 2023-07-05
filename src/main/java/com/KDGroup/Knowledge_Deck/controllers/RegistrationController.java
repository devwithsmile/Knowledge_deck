package com.KDGroup.Knowledge_Deck.controllers;

import com.KDGroup.Knowledge_Deck.DTO.AdminRegistrationDTO;
import com.KDGroup.Knowledge_Deck.DTO.PartnerAssociateRegistrationDTO;
import com.KDGroup.Knowledge_Deck.DTO.SchoolRegistrationDTO;
import com.KDGroup.Knowledge_Deck.DTO.StudentRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;
import com.KDGroup.Knowledge_Deck.models.Users;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {

    private final StudentServiceImpl studentService;
    private final AdminServiceImpl adminService;
    private final PartnerAssociateServiceImpl partnerAssociateService;
    private final SchoolsServiceImpl schoolsService;
    private final UserServiceImpl userService;

    @GetMapping
    public String indexOfRegister() {
        return "Go back, select a Role, and come back.";
    }

    @PostMapping("/student")
    public ResponseEntity<String> student(@RequestBody StudentRegistrationDTO registrationDTO) {
        if (userService.doesUsernameExist(registrationDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists. Please choose a different username.");
        }

        if (studentService.doesEmailExist(registrationDTO.getEmailId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists. Please use a different email.");
        }

        studentService.registerStudents(registrationDTO);

        Users user = new Users();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setRole("Student");
        user.setAccountActive(true);

        userService.createUser(user);

        return ResponseEntity.ok("Successful");
    }

    @PostMapping("/partner")
    public ResponseEntity<String> partner(@RequestBody PartnerAssociateRegistrationDTO registrationDTO) {
        if (partnerAssociateService.doesEmailExist(registrationDTO.getEmailId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists. Please use a different email.");
        }

        if (userService.doesUsernameExist(registrationDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists. Please choose a different username.");
        }

        partnerAssociateService.registerPartner(registrationDTO);

        Users user = new Users();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setRole("Partner");
        user.setAccountActive(false);

        userService.createUser(user);

        return ResponseEntity.ok("Successful");
    }

    @PostMapping("/school")
    public ResponseEntity<String> school(@RequestBody SchoolRegistrationDTO registrationDTO) {
        if (schoolsService.doesEmailExist(registrationDTO.getEmailId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists. Please use a different email.");
        }

        if (userService.doesUsernameExist(registrationDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists. Please choose a different username.");
        }

        String s = schoolsService.registerSchool(registrationDTO);

        Users user = new Users();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setRole("School");
        user.setAccountActive(false);

        String s1 = userService.createUser(user);
        if (s.equals(s1)) {
            return ResponseEntity.ok("Successful");
        }
        return ResponseEntity.ok("Not Successful");
    }

    @PostMapping("/admin")
    public ResponseEntity<String> admin(@RequestBody AdminRegistrationDTO registrationDTO) {
        if (adminService.doesEmailExist(registrationDTO.getEmailId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists. Please use a different email.");
        }

        if (userService.doesUsernameExist(registrationDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists. Please choose a different username.");
        }

        String s = adminService.registerAdmin(registrationDTO);

        Users user = new Users();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setRole("Admin");
        user.setAccountActive(false);

        String s1 = userService.createUser(user);
        if (s.equals(s1)) {
            return ResponseEntity.ok("Successful");
        }
        return ResponseEntity.ok("Not Successful");
    }


}
