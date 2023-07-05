package com.KDGroup.Knowledge_Deck.repositories;

import com.KDGroup.Knowledge_Deck.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmailId(String emailId);
//
}
