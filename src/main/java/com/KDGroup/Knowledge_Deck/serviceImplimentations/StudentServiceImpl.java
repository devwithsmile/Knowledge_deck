package com.KDGroup.Knowledge_Deck.serviceImplimentations;

import com.KDGroup.Knowledge_Deck.DTO.StudentRegistrationDTO;
import com.KDGroup.Knowledge_Deck.models.Students;
import com.KDGroup.Knowledge_Deck.repositories.StudentsRepository;
import com.KDGroup.Knowledge_Deck.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentsRepository studentsRepository;

    public StudentServiceImpl(StudentsRepository studentsRepository) {
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

        studentsRepository.save(student);
        return student;
    }

    public ResponseEntity<?> deleteStudent(Long id) {
        Students students = studentsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not Found"));
        studentsRepository.delete(students);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // overridden methods

    @Override
    public Students registerStudents(StudentRegistrationDTO registrationDTO) {
        Students student = new Students();

        student.setFirstName(registrationDTO.getFirstName());
        student.setLastName(registrationDTO.getLastName());
        student.setBirthDate(registrationDTO.getBirthDate());
        student.setGender(registrationDTO.getGender());

        student.setHomeAddress(registrationDTO.getHomeAddress());
        student.setEmailId(registrationDTO.getEmailId());
        student.setPhoneNumber(registrationDTO.getPhoneNumber());
        student.setUsername(registrationDTO.getUsername());

        student.setSchool(registrationDTO.getSchool());
        return studentsRepository.save(student);
    }

    @Override
    public boolean doesEmailExist(String emailId) {
        Students student = studentsRepository.findByEmailId(emailId);
        if (student == null) {
            return false;
        }
        return true;
    }

    @Override
    public Students getStudentsByEmailId(String email) {
        Students studentObj = studentsRepository.findByEmailId(email);


        if (studentObj == null) {
            return null;
        }
        return studentObj;
    }


}
