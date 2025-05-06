package com.example.application_web_examen.service;

import com.example.application_web_examen.dto.request.EtudiantRequestDto;
import com.example.application_web_examen.mapper.UserMapper;
import com.example.application_web_examen.model.Etudiant;
import com.example.application_web_examen.model.Media;
import com.example.application_web_examen.repository.EtudiantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private MediaService mediaService;

    @Autowired
    private UserMapper userMapper;

    public List<Etudiant> getAllCustomers() {
        return etudiantRepository.findAll();
    }

    public Etudiant getCustomerById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public void deleteCustomer(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Transactional
    public Etudiant updateCustomer(EtudiantRequestDto customerDTO, Etudiant etudiant, MultipartFile userPhoto) {
        Etudiant updatedEtudiant = userMapper.partialUpdateCustomer(customerDTO, etudiant);

        if (userPhoto != null && !userPhoto.isEmpty()) {
            Media media=  mediaService.updateMediaForUser(userPhoto, updatedEtudiant);
            updatedEtudiant.setUserPhoto(media);
            return etudiantRepository.save(updatedEtudiant);
        }

        return etudiantRepository.save(updatedEtudiant);
    }
}
