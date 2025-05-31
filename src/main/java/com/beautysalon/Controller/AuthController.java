package com.beautysalon.Controller;

import com.beautysalon.DTO.UserDTO;
import com.beautysalon.Inteface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String formRegistro(Model model) {
        model.addAttribute("user", new UserDTO());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registrar(@ModelAttribute UserDTO userDTO) throws IOException {
        userService.salvar(userDTO); // Deve encriptar a senha dentro do service
        return "redirect:/login";
    }
}
