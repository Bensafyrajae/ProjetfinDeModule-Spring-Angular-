package com.example.application_web_examen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reponseDonnee;

    private boolean correcte;

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Examen examen;

    @ManyToOne
    private Participation participation;
}
