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

import com.KDGroup.Knowledge_Deck.models.Students;
import com.KDGroup.Knowledge_Deck.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all") // because on index of this I think it shud be the login page of PA.
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = studentService.getTotalStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentsByID(@PathVariable("id") Long id) {
        Students students = studentService.getStudentsByID(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Students> createStudents(@RequestBody Students students) {
        Students newStudents = studentService.createStudents(students);
        return new ResponseEntity<>(newStudents, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudents(@PathVariable("id") Long id, @RequestBody Students updatedStudents) {
        Students students = studentService.updateStudents(id, updatedStudents);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
