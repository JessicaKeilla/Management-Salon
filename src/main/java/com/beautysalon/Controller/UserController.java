package com.beautysalon.Controller;

import com.beautysalon.DTO.UserDTO;
import com.beautysalon.Inteface.RoleService;
import com.beautysalon.Inteface.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", userService.listarTodos());
        return "user/list";
    }

    @GetMapping("/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", userService.buscarPorId(id));
        return "user/list";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("usuario") UserDTO dto, BindingResult result, Model model) throws IOException {


        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.listarTodos());
            return "usuario/form";
        }
        userService.salvar(dto);
        return "redirect:/usuarios";
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute("usuario") UserDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.listarTodos());
            return "usuario/form";
        }
        userService.atualizar(id, dto);
        return "redirect:/usuarios";
    }

    @PostMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        userService.deletar(id);
        return "redirect:/usuarios";
    }
}
