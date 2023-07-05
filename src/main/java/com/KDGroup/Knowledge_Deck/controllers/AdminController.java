package com.KDGroup.Knowledge_Deck.controllers;

import java.util.List;

import com.KDGroup.Knowledge_Deck.serviceImplimentations.AdminServiceImpl;
import com.KDGroup.Knowledge_Deck.serviceImplimentations.StudentServiceImpl;
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

import com.KDGroup.Knowledge_Deck.models.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminServiceImpl adminServiceimpl;

    public AdminController(StudentServiceImpl adminServiceImpl) {
        this.adminServiceimpl = AdminController.this.adminServiceimpl;
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> students = adminServiceimpl.getTotalAdmin();

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminByID(@PathVariable("id") Long id) {
        Admin students = adminServiceimpl.getAdminByID(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin students) {
        Admin newAdmin = adminServiceimpl.createAdmin(students);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Long id, @RequestBody Admin updatedAdmin) {
        Admin students = adminServiceimpl.updateAdmin(id, updatedAdmin);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Long id) {
        adminServiceimpl.deleteAdmin(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
