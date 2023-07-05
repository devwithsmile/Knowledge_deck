package com.KDGroup.Knowledge_Deck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.KDGroup.Knowledge_Deck.models.Students;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long>{


    Students findByEmailId(String emailId);
}

