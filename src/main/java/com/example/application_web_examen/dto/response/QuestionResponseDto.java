package com.example.application_web_examen.dto.response;

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
public class QuestionResponseDto {
    private Long id;
    private String texteQuestion;
    private int dureeEnSecondes;
    private QuestionType type;
    private List<String> choix;
    private String bonneReponse;
    private String mediaUrl;
}
