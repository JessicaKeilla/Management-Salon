package com.beautysalon.Controller;

import com.beautysalon.DTO.ClienteDTO;
import com.beautysalon.Inteface.ClienteService;
import com.beautysalon.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes/lista"; // Criar JSP correspondente depois
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute ("cliente") ClienteDTO clienteDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cliente", clienteDTO);
            return "clientes/form";
        }
        clienteService.salvar(clienteDTO);
        return "redirect:/clientes/listar"; //no ex n tem listar
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }
    @GetMapping("/form")
    public String exibirFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/form"; // se o JSP estiver em views/clientes/form.jsp
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Long id, @Valid @ModelAttribute ("cliente") ClienteDTO clienteDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cliente", clienteDTO);
            return "cliente/form";
        }
        clienteService.salvar(clienteDTO);
        return "redirect:/clientes/listar"; //no ex n tem listar


        }


}
