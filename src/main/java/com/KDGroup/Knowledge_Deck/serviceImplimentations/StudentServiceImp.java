package com.KDGroup.Knowledge_Deck.serviceImplimentations;

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
import com.KDGroup.Knowledge_Deck.services.StudentService;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.AdmissionForm;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.StudentHome;
import com.KDGroup.Knowledge_Deck.web.Menu.Students.StudentProfile;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentsRepository studentsRepository;

    public StudentServiceImp(StudentsRepository studentsRepository) {
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

    // overriden methods

    @Override
    public Students saveHome(StudentHome studentHome) {
        // TODO Auto-generated method stub
       
        throw new UnsupportedOperationException("Unimplemented method 'saveHome'");
    }

    @Override
    public Students saveForm(AdmissionForm admissionForm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveForm'");
    }

    @Override
    public Students saveProfile(StudentProfile studentProfile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveProfile'");
    }

}
