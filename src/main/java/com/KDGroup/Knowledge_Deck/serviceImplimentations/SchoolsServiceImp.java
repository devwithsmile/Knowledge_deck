package com.KDGroup.Knowledge_Deck.serviceImplimentations;

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
import com.KDGroup.Knowledge_Deck.services.SchoolsService;
import com.KDGroup.Knowledge_Deck.DTO.AdmissionForm;
import com.KDGroup.Knowledge_Deck.DTO.StudentHome;
import com.KDGroup.Knowledge_Deck.DTO.StudentProfile;

@Service
public class SchoolsServiceImp implements SchoolsService{

    private SchoolsRepository schoolsRepository;

    public SchoolsServiceImp(SchoolsRepository schoolsRepository) {
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

    @Override
    public Schools saveHome(StudentHome studentHome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveHome'");
    }

    @Override
    public Schools saveForm(AdmissionForm admissionForm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveForm'");
    }

    @Override
    public Schools saveProfile(StudentProfile studentProfile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveProfile'");
    }

}
