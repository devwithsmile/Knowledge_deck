package com.KDGroup.Knowledge_Deck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KDGroup.Knowledge_Deck.models.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long>{


    Students findByEmailId(String emailId);
}
