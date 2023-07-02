package com.KDGroup.Knowledge_Deck.serviceImplimentations;

import com.KDGroup.Knowledge_Deck.models.Users;
import com.KDGroup.Knowledge_Deck.repositories.UserRepository;
import com.KDGroup.Knowledge_Deck.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String createUser(Users user) {
        userRepository.save(user);
        return "successful";
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        Users book = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return book;
    }

    public Users updateUser(@PathVariable Long id, @NotNull @Validated @RequestBody Users userDetails) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        user.setUsername(userDetails.getUsername());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());


        // user = userDetails; can I do this ?
        userRepository.save(user);
        return user;
    }


    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public boolean doesUsernameExist(String username) {
        Users user = userRepository.findByUsername(username);
        if (user == null){
            return false;
        }
        return true;
    }


}
