package com.example.application_web_examen.service;

import com.example.application_web_examen.dto.request.ProfRequestDto;
import com.example.application_web_examen.mapper.UserMapper;
import com.example.application_web_examen.model.prof;
import com.example.application_web_examen.model.Media;
import com.example.application_web_examen.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProfService {

    private final ProfRepository profRepository;
    private final MediaService mediaService;
    private final UserMapper userMapper;

    @Autowired
    public ProfService(ProfRepository profRepository, MediaService mediaService, UserMapper userMapper) {
        this.profRepository = profRepository;
        this.mediaService = mediaService;
        this.userMapper = userMapper;
    }

    public List<prof> getAllArtisans() {
        return profRepository.findAll();
    }

    public prof getArtisanById(Long id) {
        return profRepository.findById(id).orElse(null);
    }

    public void deleteArtisan(Long id) {
        profRepository.deleteById(id);
    }

    public prof updateArtisan(ProfRequestDto artisanDTO, prof prof, MultipartFile userPhoto) {
        prof newProf = userMapper.partialUpdateArtisan(artisanDTO, prof);

        if (userPhoto != null && !userPhoto.isEmpty()) {
            Media media=  mediaService.updateMediaForUser(userPhoto, newProf);
            newProf.setUserPhoto(media);
            return profRepository.save(newProf);
        }

        return profRepository.save(newProf);
    }
}
