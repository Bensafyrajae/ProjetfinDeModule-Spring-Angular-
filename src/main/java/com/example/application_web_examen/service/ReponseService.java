package com.example.application_web_examen.service;

import com.example.application_web_examen.model.Reponse;
import com.example.application_web_examen.repository.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseService {

    @Autowired
    private ReponseRepository reponseRepository;

    public List<Reponse> getAll() {
        return reponseRepository.findAll();
    }

    public Optional<Reponse> getById(Long id) {
        return reponseRepository.findById(id);
    }

    public Reponse save(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    public void delete(Long id) {
        reponseRepository.deleteById(id);
    }
}
