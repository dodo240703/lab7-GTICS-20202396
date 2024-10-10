package com.example.lab7gtics20202396.Controllers;

import com.example.lab7gtics20202396.Entities.Role;
import com.example.lab7gtics20202396.Entities.User;
import com.example.lab7gtics20202396.Repositories.RoleRepository;
import com.example.lab7gtics20202396.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LR_controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna la vista del formulario de login
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Retorna la vista del formulario de registro
    }

    @PostMapping("/register")
    public String register(User user, Model model,@RequestParam("confirmPassword") String confirmPassword) {
        // Verificar si el correo ya está registrado
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "El correo ya está registrado");
            return "register";
        }
        // Validar si las contraseñas coinciden
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "register";
        }

        // Encriptar la contraseña antes de guardar
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Asignar el rol con ID 6
        Role role = roleRepository.findById(6).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        user.setRole(role);
        // Guardar el usuario en la base de datos
        userRepository.save(user);

        return "redirect:/login"; // Redirigir al formulario de login después del registro exitoso
    }
}
