package com.KDGroup.Knowledge_Deck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KDGroup.Knowledge_Deck.models.Schools;

@Repository
public interface SchoolsRepository extends JpaRepository<Schools, Long> {

}
