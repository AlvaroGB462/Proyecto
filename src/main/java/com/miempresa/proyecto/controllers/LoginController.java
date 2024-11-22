package com.miempresa.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miempresa.proyecto.models.User;
import com.miempresa.proyecto.services.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Página de inicio, redirige a la página de bienvenida
    @GetMapping("/")
    public String redirectToWelcome() {
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Asegúrate de que login.jsp está en el lugar correcto
    }

    @PostMapping("/login")
    public String login(@RequestParam String usernameOrEmail, @RequestParam String password, HttpSession session, Model model) {
        User user = loginService.login(usernameOrEmail, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/welcome";  // Asegúrate de que la vista welcome.jsp está correctamente configurada
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";  // Aquí se maneja correctamente el redireccionamiento a la vista login
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        // Obtiene el usuario de la sesión
        User user = (User) session.getAttribute("user");

        // Si el usuario está logueado, añádelo al modelo
        if (user != null) {
            model.addAttribute("user", user);
            
            // Si el usuario es admin, añades una variable especial
            if ("admin".equals(user.getRole())) {  // Asumiendo que el usuario tiene un campo 'role'
                model.addAttribute("isAdmin", true);
            } else {
                model.addAttribute("isAdmin", false);
            }
        } else {
            // Si no hay usuario logueado, añadimos un atributo para mostrar el botón de login
            model.addAttribute("isLoggedIn", false);
        }

        // Devuelve la vista de welcome.jsp
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";  // Redirige al login después de cerrar sesión
    }
}
