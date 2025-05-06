package com.example.application_web_examen.repository;

import com.example.application_web_examen.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
    Optional<Examen> findByLienUnique(UUID lienUnique);
}
