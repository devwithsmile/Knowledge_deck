package com.KDGroup.Knowledge_Deck.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.KDGroup.Knowledge_Deck.models.Schools;
import com.KDGroup.Knowledge_Deck.repositories.SchoolsRepository;

@Service
public class SchoolsService {

    private final SchoolsRepository schoolsRepository;

    public SchoolsService(SchoolsRepository schoolsRepository) {
        this.schoolsRepository = schoolsRepository;
    }

    public List<Schools> getTotalSchools() {
        return schoolsRepository.findAll();
    }

    public Schools getSchoolsByID(Long id) {
        Schools schools = schoolsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "school not found"));

        return schools;
    }

    public Schools createSchools(Schools schools) {
        return schoolsRepository.save(schools);
    }

    // update one
    public Schools updateSchools(@PathVariable Long id,
            @Validated @RequestBody Schools schoolDetails) {

        Schools schools = schoolsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found"));

        schools.setId(schoolDetails.getId());
        schools.setName(schoolDetails.getName());
        schools.setcutoff(schoolDetails.getcutoff());
        schools.setEmail_id(schoolDetails.getEmail_id());
        schools.setPassword(schoolDetails.getPassword());
        schools.setPh_number(schoolDetails.getPh_number());

        schoolsRepository.save(schools);
        return schools;
    }
    //

    public ResponseEntity<?> deleteSchools(@PathVariable Long id) {
        Schools school = schoolsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found"));
        schoolsRepository.delete(school);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
