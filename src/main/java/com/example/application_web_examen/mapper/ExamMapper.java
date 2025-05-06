package com.example.application_web_examen.mapper;

import com.example.application_web_examen.dto.request.*;
import com.example.application_web_examen.dto.response.*;
import com.example.application_web_examen.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {QuestionMapper.class})
public interface ExamMapper {

    // Examen
    ExamenResponseDto toExamenResponseDto(Examen examen);
    Examen toExamenEntity(ExamenRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Examen partialUpdateExamen(ExamenRequestDto dto, @MappingTarget Examen examen);
}
