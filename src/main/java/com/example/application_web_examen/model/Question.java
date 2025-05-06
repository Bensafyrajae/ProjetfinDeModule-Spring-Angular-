package com.example.application_web_examen.model;

import com.example.application_web_examen.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texte;

    private int dureeSeconds;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private String bonneReponse;

    @ElementCollection
    private List<String> options;

    @ManyToOne
    private Examen examen;

    @OneToOne(cascade = CascadeType.ALL)
    private Media image;
}
