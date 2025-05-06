package com.example.application_web_examen.service;

import com.example.application_web_examen.model.Participation;
import com.example.application_web_examen.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

    public List<Participation> getAll() {
        return participationRepository.findAll();
    }

    public Optional<Participation> getById(Long id) {
        return participationRepository.findById(id);
    }

    public Participation save(Participation participation) {
        return participationRepository.save(participation);
    }

    public void delete(Long id) {
        participationRepository.deleteById(id);
    }
}
