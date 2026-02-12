package com.example.devops.controller;

import com.example.devops.model.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EstudianteController {

    private final Map<String, Estudiante> estudiantes = new HashMap<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("estudiantes", new ArrayList<>(estudiantes.values()));
        model.addAttribute("nuevoEstudiante", new Estudiante()); 
        return "index";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("nuevoEstudiante") Estudiante estudiante) {

        if (estudiante.getId() != null && !estudiante.getId().isEmpty()) {
            estudiantes.put(estudiante.getId(), estudiante);
        }
        return "redirect:/";
    }

    @GetMapping("/estudiantes")
    @ResponseBody
    public List<Estudiante> listarJson() {
        return new ArrayList<>(estudiantes.values());
    }

    @PostMapping("/estudiantes")
    @ResponseBody
    public ResponseEntity<Object> registrarJson(@RequestBody Estudiante estudiante) {
        if (estudiantes.containsKey(estudiante.getId())) {
            return new ResponseEntity<>("Error: El ID ya existe", HttpStatus.BAD_REQUEST);
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
    }
}