package com.example.lab7gtics20202396.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gerente")
public class GereneteController {

    @GetMapping("/proyecciones")
    public String showProyecciones() {
        return "Gerente/proyeccciones";
    }

    @GetMapping("/reservas")
    public String showReservas() {
        return "Gerente/reservas";
    }
}
