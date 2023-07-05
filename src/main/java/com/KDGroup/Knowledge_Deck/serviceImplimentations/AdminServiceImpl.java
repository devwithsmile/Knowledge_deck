package com.KDGroup.Knowledge_Deck.serviceImplimentations;

import java.util.List;

import com.KDGroup.Knowledge_Deck.DTO.AdminRegistrationDTO;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.KDGroup.Knowledge_Deck.models.Admin;
import com.KDGroup.Knowledge_Deck.repositories.AdminRepository;
import com.KDGroup.Knowledge_Deck.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getTotalAdmin() {
        return adminRepository.findAll();
    }

    public Admin getAdminByID(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not Found."));
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(@PathVariable Long id, @Validated @RequestBody Admin updatedAdmins) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not Found."));

        adminRepository.save(admin);
        return admin;
    }

    public ResponseEntity<?> deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not Found"));
        adminRepository.delete(admin);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // overridden methods

    @Override
    public String registerAdmin(@NotNull AdminRegistrationDTO registrationDTO) {
        Admin admin = new Admin();

        admin.setFirstName(registrationDTO.getFirstName());
        admin.setLastName(registrationDTO.getLastName());
        admin.setEmailId(registrationDTO.getEmailId());
        admin.setPhoneNumber(registrationDTO.getPhoneNumber());
        admin.setUsername(registrationDTO.getUsername());
        admin.setPassword(registrationDTO.getPassword());
        admin.setConfirmPassword(registrationDTO.getConfirmPassword());
        adminRepository.save(admin);

        return "successful";
    }

    @Override
    public boolean doesEmailExist(String emailId) {
        Admin admin = adminRepository.findByEmailId(emailId);
        if (admin == null){
            return false;
        }
        return true;
    }
}
