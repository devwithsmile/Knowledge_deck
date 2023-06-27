package com.KDGroup.Knowledge_Deck.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;
import com.KDGroup.Knowledge_Deck.repositories.PartnerAssociateRepository;

@Service
public class PartnerAssociateService {
    private final PartnerAssociateRepository partnerAssociateRepository;

    public PartnerAssociateService(PartnerAssociateRepository partnerAssociateRepository) {
        this.partnerAssociateRepository = partnerAssociateRepository;
    }

    // CRUD

    // create
    public PartnerAssociate createPartnerAssociate(PartnerAssociate PAS) {
        return partnerAssociateRepository.save(PAS);
    }

    // read one
    public PartnerAssociate getPartnerAssociatebyID(Long id) {
        PartnerAssociate PAS = partnerAssociateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Associate not found"));

        return PAS;
    }

    // read many
    public List<PartnerAssociate> getTotalAssociates() {
        return partnerAssociateRepository.findAll();
    }

    // update one
    public PartnerAssociate updatedPartnerAssociate(@PathVariable Long id,
            @Validated @RequestBody PartnerAssociate PADetails) {
        PartnerAssociate pAssociate = partnerAssociateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Associate not found"));

        pAssociate.setId(PADetails.getId());
        pAssociate.setName(PADetails.getName());
        pAssociate.setPassword(PADetails.getPassword());
        pAssociate.setPh_number(PADetails.getPh_number());
        pAssociate.setEmail_id(PADetails.getEmail_id());
        pAssociate.setRole(PADetails.getRole());

        partnerAssociateRepository.save(pAssociate);
        return pAssociate;
    }

    // delete one

    public ResponseEntity<?> deletePartnerAssociate(@PathVariable Long id) {
        PartnerAssociate partnerAssociate = partnerAssociateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Associate not found"));
        partnerAssociateRepository.delete(partnerAssociate);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    

}
