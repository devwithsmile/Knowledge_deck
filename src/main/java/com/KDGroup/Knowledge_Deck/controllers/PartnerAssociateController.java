package com.KDGroup.Knowledge_Deck.controllers;

import com.KDGroup.Knowledge_Deck.models.PartnerAssociate;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.PartnerAssociateServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/partners")
public class PartnerAssociateController {

    private final PartnerAssociateServiceImpl partnerServiceImp;

    public PartnerAssociateController(PartnerAssociateServiceImpl partnerServiceImp) {
        this.partnerServiceImp = partnerServiceImp;
    }

    @GetMapping("/all") // because on index of this I think it shud be the login page of PA.
    public ResponseEntity<List<PartnerAssociate>> getAllPartnerAssociates() {
        List<PartnerAssociate> partnerAssociates = partnerServiceImp.getTotalAssociates();

        return new ResponseEntity<>(partnerAssociates, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerAssociate> getPartnerAssociateById(@PathVariable("id") Long id) {
        PartnerAssociate partnerAssociate = partnerServiceImp.getPartnerAssociateByID(id);
        return new ResponseEntity<>(partnerAssociate, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PartnerAssociate> createPartnerAssociate(@RequestBody PartnerAssociate partnerAssociate) {
        PartnerAssociate newPartnerAssociate = partnerServiceImp.createPartnerAssociate(partnerAssociate);
        return new ResponseEntity<>(newPartnerAssociate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerAssociate> updatePartnerAssociate(@PathVariable("id") Long id,
                                                                   @RequestBody PartnerAssociate updatedPartnerAssociate) {
        PartnerAssociate partnerAssociate = partnerServiceImp.updatedPartnerAssociate(id, updatedPartnerAssociate);
        return new ResponseEntity<>(partnerAssociate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartnerAssociate(@PathVariable("id") Long id) {
        partnerServiceImp.deletePartnerAssociate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
