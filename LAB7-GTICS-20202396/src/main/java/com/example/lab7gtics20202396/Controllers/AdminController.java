package com.example.lab7gtics20202396.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/salas")
    public String showSalas() {
        return "Admin/salas";
    }

    @GetMapping("/peliculas")
    public String showPeliculas() {
        return "Admin/peliculas";
    }

    @GetMapping("/proyecciones")
    public String showProyecciones() {
        return "Admin/proyeccciones";
    }

}
