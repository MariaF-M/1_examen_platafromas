package com.example.devops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor

public class Estudiante {

    private String id;
    private String nombre;
    private String carrera;

}
