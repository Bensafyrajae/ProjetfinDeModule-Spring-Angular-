package com.example.application_web_examen.service;

import com.example.application_web_examen.model.Examen;
import com.example.application_web_examen.model.prof;
import com.example.application_web_examen.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExamenService {

    private final ExamenRepository examenRepository;

    @Autowired
    public ExamenService(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    public List<Examen> getAllExamens() {
        return examenRepository.findAll();
    }

    public Optional<Examen> getExamenById(Long id) {
        return examenRepository.findById(id);
    }

    public Optional<Examen> getExamenByLienUnique(UUID lienUnique) {
        return examenRepository.findByLienUnique(lienUnique);
    }

    public Examen createExamen(Examen examen, prof createur) {
        examen.setCreateur(createur);
        return examenRepository.save(examen);
    }

    public Examen updateExamen(Long id, Examen updatedExamen) {
        return examenRepository.findById(id)
                .map(examen -> {
                    examen.setNom(updatedExamen.getNom());
                    examen.setDescription(updatedExamen.getDescription());
                    examen.setQuestions(updatedExamen.getQuestions());
                    return examenRepository.save(examen);
                })
                .orElseThrow(() -> new RuntimeException("Examen non trouvé"));
    }

    public void deleteExamen(Long id) {
        examenRepository.deleteById(id);
    }
}
