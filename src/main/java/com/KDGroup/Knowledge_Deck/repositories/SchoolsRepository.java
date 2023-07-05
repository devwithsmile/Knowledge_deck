package com.KDGroup.Knowledge_Deck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.KDGroup.Knowledge_Deck.models.Schools;
import org.springframework.stereotype.Repository;


@Repository
public interface SchoolsRepository extends JpaRepository<Schools, Long> {

    Schools findByEmailId(String emailId);
}
