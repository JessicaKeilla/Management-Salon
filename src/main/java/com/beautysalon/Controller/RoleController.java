package com.beautysalon.Controller;

import com.beautysalon.DTO.RoleDTO;
import com.beautysalon.Inteface.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("roles", roleService.listarTodos());
        return "role/list";
    }

    @GetMapping("/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        model.addAttribute("role", roleService.buscarPorId(id));
        return "role/detail";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("role") RoleDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "role/form";
        }
        roleService.salvar(dto);
        return "redirect:/roles";
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute("role") RoleDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "role/form";
        }
        roleService.atualizar(id, dto);
        return "redirect:/roles";
    }

    @PostMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        roleService.deletar(id);
        return "redirect:/roles";
    }
}
