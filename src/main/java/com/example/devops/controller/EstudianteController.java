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

    // Definir tipos específicos <String, Estudiante> 
    // Persistencia en memoria 
    private final Map<String, Estudiante> estudiantes = new HashMap<>();

    // --- SECCIÓN MVC (VISTA) ---
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

    // --- SECCIÓN API REST ---

    // Requerimiento: GET /estudiantes retorna lista con código 200 
    @GetMapping("/estudiantes")
    @ResponseBody
    public ResponseEntity<List<Estudiante>> listarJson() {
        return new ResponseEntity<>(new ArrayList<>(estudiantes.values()), HttpStatus.OK);
    }

    // Requerimiento: POST /estudiantes, valida ID único, guarda y retorna 201
    @PostMapping("/estudiantes")
    @ResponseBody
    public ResponseEntity<?> registrarJson(@RequestBody Estudiante estudiante) {
        // Validación de ID único
        if (estudiantes.containsKey(estudiante.getId())) {
            return new ResponseEntity<>("Error: El ID ya existe", HttpStatus.BAD_REQUEST);
        }
        
        // Guardado en memoria
        estudiantes.put(estudiante.getId(), estudiante);
        
        // Retorno estricto de código 201 
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
    }
}