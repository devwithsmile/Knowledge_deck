package com.KDGroup.Knowledge_Deck.repositories;

import com.KDGroup.Knowledge_Deck.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <Users,Long> {
    Users findByUsername(String username);

}
