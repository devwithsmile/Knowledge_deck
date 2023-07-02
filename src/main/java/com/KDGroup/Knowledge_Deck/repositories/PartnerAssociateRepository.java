package com.KDGroup.Knowledge_Deck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;

@Repository
public interface PartnerAssociateRepository extends JpaRepository<PartnerAssociate,Long>{

    PartnerAssociate findByEmailId(String emailId);
}
