package com.KDGroup.Knowledge_Deck.serviceImplimentations;

import com.KDGroup.Knowledge_Deck.DTO.SchoolRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.Schools;
import com.KDGroup.Knowledge_Deck.repositories.SchoolsRepository;
import com.KDGroup.Knowledge_Deck.services.SchoolsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SchoolsServiceImpl implements SchoolsService {

    private final SchoolsRepository schoolsRepository;

    public SchoolsServiceImpl(SchoolsRepository schoolsRepository) {
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

        Schools school = schoolsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found"));

        school.setSchoolName(schoolDetails.getSchoolName());
        school.setInstituteName(schoolDetails.getInstituteName());
        school.setEmailId(schoolDetails.getEmailId());
        school.setAddress(schoolDetails.getAddress());
        school.setPhoneNumber(schoolDetails.getPhoneNumber());

        schoolsRepository.save(school);
        return school;
    }
    //

    public ResponseEntity<?> deleteSchools(@PathVariable Long id) {
        Schools school = schoolsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found"));
        schoolsRepository.delete(school);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public String registerSchool(SchoolRegistrationDTO registrationDTO) {
        Schools school = new Schools();


        school.setSchoolName(registrationDTO.getSchoolName());
        school.setInstituteName(registrationDTO.getInstituteName());
        school.setEmailId(registrationDTO.getEmailId());
        school.setAddress(registrationDTO.getAddress());
        school.setPhoneNumber(registrationDTO.getPhoneNumber());
        school.setUsername(registrationDTO.getUsername());

        schoolsRepository.save(school);
        return "successful";
    }

    @Override
    public boolean doesEmailExist(String emailId) {
        Schools school = schoolsRepository.findByEmailId(emailId);
        if (school == null){
            return false;
        }
        return true;
    }


}
