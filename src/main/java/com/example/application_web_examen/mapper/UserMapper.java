package com.example.application_web_examen.mapper;

import com.example.application_web_examen.dto.request.AdminRequestDto;
import com.example.application_web_examen.dto.request.EtudiantRequestDto;
import com.example.application_web_examen.dto.request.ProfRequestDto;
import com.example.application_web_examen.dto.response.AdminResponseDto;
import com.example.application_web_examen.dto.response.EtudiantResponseDto;
import com.example.application_web_examen.dto.response.ProfResponseDto;
import com.example.application_web_examen.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // Admin Mappings
    AdminResponseDto toAdminResponseDto(Admin admin);
    Admin toAdminEntity(AdminRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Admin partialUpdateAdmin(AdminRequestDto adminRequestDto, @MappingTarget Admin admin);

    // Artisan Mappings
    ProfResponseDto toArtisanResponseDto(prof prof);
    prof toArtisanEntity(ProfRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    prof partialUpdateArtisan(ProfRequestDto profRequestDto, @MappingTarget prof prof);

    // Customer Mappings
    EtudiantResponseDto toCustomerResponseDto(Etudiant etudiant);
    Etudiant toCustomerEntity(EtudiantRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Etudiant partialUpdateCustomer(EtudiantRequestDto etudiantRequestDto, @MappingTarget Etudiant etudiant);
}
