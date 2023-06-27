package com.KDGroup.Knowledge_Deck.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.KDGroup.Knowledge_Deck.models.Students;
import com.KDGroup.Knowledge_Deck.repositories.StudentsRepository;

@Service
public class StudentService {

    private final StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Students> getTotalStudents() {
        return studentsRepository.findAll();
    }

    public Students getStudentsByID(Long id) {
        return studentsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found."));
    }

    public Students createStudents(Students students) {
        return studentsRepository.save(students);
    }

    public Students updateStudents(@PathVariable Long id, @Validated @RequestBody Students updatedStudents) {
        Students student = studentsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found."));

        student.setId(updatedStudents.getId());
        student.setName(updatedStudents.getName());
        student.setEmail(updatedStudents.getEmail());
        student.setPh_number(updatedStudents.getPh_number());
        student.setPassword(updatedStudents.getPassword());

        studentsRepository.save(student);
        return student;
    }

    public ResponseEntity<?> deleteStudent(Long id) {
        Students students = studentsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found"));
        studentsRepository.delete(students);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
