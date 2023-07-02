package com.KDGroup.Knowledge_Deck.serviceImplimentations;

import com.KDGroup.Knowledge_Deck.DTO.LoginDTO;
import com.KDGroup.Knowledge_Deck.models.Users;
import com.KDGroup.Knowledge_Deck.repositories.UserRepository;
import com.KDGroup.Knowledge_Deck.services.LoginService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Getter
@Setter
@Service
public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;

    public String userLogin(LoginDTO loginInfo) {


        Users optionalUsers = userRepository.findByUsername(loginInfo.getUsername());
        //change next two return to "invalid credentials"
       if(optionalUsers == null){
           return "user not found";
       } else if (!optionalUsers.getPassword().equals(loginInfo.getPassword())) {
           return "wrong password";
       }

        String role = optionalUsers.getRole();
        return role;
    }

}
