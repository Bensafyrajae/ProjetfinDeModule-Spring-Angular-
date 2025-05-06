package com.example.application_web_examen.dto.request;

import com.example.application_web_examen.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDto {
    private String texteQuestion;
    private int dureeEnSecondes;
    private QuestionType type;
    private List<String> choix; // uniquement pour QCM
    private String bonneReponse;
    private String mediaUrl; // URL de l'image
}
