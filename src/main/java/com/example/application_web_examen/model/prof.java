package com.example.application_web_examen.model;

import com.example.application_web_examen.enums.Role;
import com.example.application_web_examen.enums.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class prof extends User {

    public prof() {
        this.setRole(Role.PROF);
    }

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private String location;
    private int experience;

}
