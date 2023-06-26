package com.KDGroup.Knowledge_Deck.controllers;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KDGroup.Knowledge_Deck.models.Schools;
import com.KDGroup.Knowledge_Deck.services.SchoolsService;

@RestController
@RequestMapping("/schools")
public class SchoolsController {

    private final SchoolsService schoolsService;

    public SchoolsController(SchoolsService schoolsService) {
        this.schoolsService = schoolsService;
    }

    @GetMapping("/all") // because on index of this I think it shud be the login page of PA.
    public ResponseEntity<List<Schools>> getAllSchools() {
        List<Schools> schools = schoolsService.getTotalSchools();

        return new ResponseEntity<>(schools, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Schools> getSchoolsByID(@PathVariable("id") Long id) {
        Schools schools = schoolsService.getSchoolsByID(id);
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Schools> createSchools(@RequestBody Schools schools) {
        Schools newSchools = schoolsService.createSchools(schools);
        return new ResponseEntity<>(newSchools, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schools> updateSchools(@PathVariable("id") Long id, @RequestBody Schools updatedSchools) {
        Schools schools = schoolsService.updateSchools(id, updatedSchools);
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchools(@PathVariable("id") Long id) {
        schoolsService.deleteSchools(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
