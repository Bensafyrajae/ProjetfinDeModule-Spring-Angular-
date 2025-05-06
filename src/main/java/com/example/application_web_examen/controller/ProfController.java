package com.example.application_web_examen.controller;

import com.example.application_web_examen.dto.request.ProfRequestDto;
import com.example.application_web_examen.dto.response.ProfResponseDto;
import com.example.application_web_examen.mapper.UserMapper;
import com.example.application_web_examen.model.prof;
import com.example.application_web_examen.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for managing artisans.
 */
@RestController
@RequestMapping("/api/artisans")
public class ProfController {

    private final ProfService profService;
    private final UserMapper userMapper;

    @Autowired
    public ProfController(ProfService profService, UserMapper userMapper) {
        this.profService = profService;
        this.userMapper = userMapper;
    }

    /**
     * Retrieve all artisans.
     *
     * @return List of all artisans.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<ProfResponseDto>> getAllArtisans() {
        List<prof> profs = profService.getAllArtisans();
        List<ProfResponseDto> profResponseDtos = profs.stream()
                .map(userMapper::toArtisanResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(profResponseDtos, HttpStatus.OK);
    }

    /**
     * Retrieve an artisan by ID.
     *
     * @return The artisan with the specified ID.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'ARTISAN')")
    @GetMapping("/details")
    public ResponseEntity<ProfResponseDto> getArtisanById(@AuthenticationPrincipal prof currentProf) {
        prof prof = profService.getArtisanById(currentProf.getId());
        return prof != null
                ? new ResponseEntity<>(userMapper.toArtisanResponseDto(prof), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Update an existing artisan.
     *
     * @param artisanDTO The artisan with updated information.
     * @param userPhoto  The photo to be updated, if any.
     * @param prof    The authenticated artisan.
     * @return The updated artisan.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'ARTISAN')")
    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProfResponseDto> updateArtisan(
            @RequestPart("artisan") ProfRequestDto artisanDTO,
            @RequestPart(value = "userPhoto", required = false) MultipartFile userPhoto,
            @AuthenticationPrincipal prof prof) {

        prof updatedProf = profService.updateArtisan(artisanDTO, prof, userPhoto);
        return new ResponseEntity<>(userMapper.toArtisanResponseDto(updatedProf), HttpStatus.OK);
    }
}
