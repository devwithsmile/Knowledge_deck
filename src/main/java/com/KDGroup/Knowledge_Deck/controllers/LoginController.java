package com.KDGroup.Knowledge_Deck.controllers;

import com.KDGroup.Knowledge_Deck.DTO.LoginDTO;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @GetMapping("/student")
    public ResponseEntity<String> loginStudent(@RequestBody LoginDTO loginDTO) {
        String s = loginServiceImpl.userLogin(loginDTO);
        switch (s) {
            case "Student":
                return ResponseEntity.ok("Successful login for Student");
            case "user not found":
            case "wrong password":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed for Student");
        }
    }

    @GetMapping("/partner")
    public ResponseEntity<String> loginPartner(@RequestBody LoginDTO loginDTO) {
        String s = loginServiceImpl.userLogin(loginDTO);
        switch (s) {
            case "Partner":
                return ResponseEntity.ok("Successful login for Partner");
            case "user not found":
            case "wrong password":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed for Partner");
        }
    }

    @GetMapping("/school")
    public ResponseEntity<String> loginSchool(@RequestBody LoginDTO loginDTO) {
        String s = loginServiceImpl.userLogin(loginDTO);
        switch (s) {
            case "School":
                return ResponseEntity.ok("Successful login for School");
            case "user not found":
            case "wrong password":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed for School");
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<String> loginAdmin(@RequestBody LoginDTO loginDTO) {
        String s = loginServiceImpl.userLogin(loginDTO);
        switch (s) {
            case "Admin":
                return ResponseEntity.ok("Successful login for Admin");
            case "user not found":
            case "wrong password":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed for School");
        }
    }


}
