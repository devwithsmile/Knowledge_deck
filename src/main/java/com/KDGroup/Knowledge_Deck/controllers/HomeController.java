package com.KDGroup.Knowledge_Deck.controllers;

import com.KDGroup.Knowledge_Deck.DTO.RegistrationDTO;
import org.springframework.web.bind.annotation.*;

import com.KDGroup.Knowledge_Deck.DTO.LoginDTO;

@RestController
@RequestMapping("/login")
public class HomeController {
    
    
    @GetMapping
    public String login(@RequestBody LoginDTO loginDTO) {
        
    	System.out.println(loginDTO.getUserName());
    	return "Ya I am working";
    }

    @PostMapping
    public String registration(@RequestBody RegistrationDTO registrationDTO){
        System.out.println(registrationDTO.getEmail());
        System.out.println(registrationDTO.getPassword());
        return "registration executed";
    }
    
    
}
