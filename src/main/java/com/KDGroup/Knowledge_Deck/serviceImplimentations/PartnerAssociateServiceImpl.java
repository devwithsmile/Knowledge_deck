package com.KDGroup.Knowledge_Deck.serviceImplimentations;

import com.KDGroup.Knowledge_Deck.DTO.PartnerAssociateRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;
import com.KDGroup.Knowledge_Deck.models.Students;
import com.KDGroup.Knowledge_Deck.repositories.PartnerAssociateRepository;
import com.KDGroup.Knowledge_Deck.services.PartnerAssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PartnerAssociateServiceImpl implements PartnerAssociateService {

    @Autowired
    private final PartnerAssociateRepository partnerAssociateRepository;

    public PartnerAssociateServiceImpl(PartnerAssociateRepository partnerAssociateRepository) {
        this.partnerAssociateRepository = partnerAssociateRepository;
    }

    // CRUD

    // create
    public PartnerAssociate createPartnerAssociate(PartnerAssociate PAS) {

        return partnerAssociateRepository.save(PAS);
    }

    // read one
    public PartnerAssociate getPartnerAssociateByID(Long id) {
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


    public String registerPartner(PartnerAssociateRegistrationDTO registrationDTO) {

        PartnerAssociate partner = new PartnerAssociate();

        partner.setFirstName(registrationDTO.getFirstName());
        partner.setLastName(registrationDTO.getLastName());
        partner.setAssociateFirmName(registrationDTO.getAssociateFirmName());
        partner.setEmailId(registrationDTO.getEmailId());
        partner.setUsername(registrationDTO.getUsername());
        partner.setPhoneNumber(registrationDTO.getPhoneNumber());

        partnerAssociateRepository.save(partner);
        return "Partner saved";
    }

    @Override
    public boolean doesEmailExist(String emailId) {
        PartnerAssociate associate= partnerAssociateRepository.findByEmailId(emailId);
        if (associate == null){
            return false;
        }
        return true;
    }

    @Override
    public PartnerAssociate getPartnerByEmailId(String email) {
        PartnerAssociate partnerObj = partnerAssociateRepository.findByEmailId(email);


        if (partnerObj == null) {
            return null;
        }
        return partnerObj;
    }
}
