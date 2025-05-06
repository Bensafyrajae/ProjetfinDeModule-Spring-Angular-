package com.example.application_web_examen.mapper;

import com.example.application_web_examen.dto.request.ExamenRequestDto;
import com.example.application_web_examen.dto.request.ParticipationRequestDto;
import com.example.application_web_examen.dto.request.QuestionRequestDto;
import com.example.application_web_examen.dto.request.ReponseRequestDto;
import com.example.application_web_examen.dto.response.ExamenResponseDto;
import com.example.application_web_examen.dto.response.ParticipationResponseDto;
import com.example.application_web_examen.dto.response.QuestionResponseDto;
import com.example.application_web_examen.dto.response.ReponseResponseDto;
import com.example.application_web_examen.model.Examen;
import com.example.application_web_examen.model.Question;
import com.example.application_web_examen.model.Reponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReponseMapper {

    // Reponse
    ReponseResponseDto toReponseResponseDto(Reponse reponse);
    Reponse toReponseEntity(ReponseRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reponse partialUpdateReponse(ReponseRequestDto dto, @MappingTarget Reponse reponse);
}
