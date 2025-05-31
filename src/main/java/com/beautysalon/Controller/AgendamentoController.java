package com.beautysalon.Controller;


import com.beautysalon.DTO.AgendamentoDTO;
import com.beautysalon.Implementacao.ClienteServiceImpl;
import com.beautysalon.Inteface.AgendamentoService;
import com.beautysalon.Inteface.ClienteService;
import com.beautysalon.Inteface.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos());
        return "agendamento/list";
    }

    @GetMapping("/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        model.addAttribute("agendamento", agendamentoService.buscarPorId(id));
        return "agendamento/detail";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute ("agendamento") AgendamentoDTO agendamentoDTO, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("servicos", servicoService.listarTodos());
            return "agendamento/form";

        }
        agendamentoService.salvar(agendamentoDTO);
        return "redirect:/agendamentos/" + agendamentoDTO.getId(); //redirect:/agendamentos
    }
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("agendamentoDTO", new AgendamentoDTO());
        return "agendamentos/form";
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute("agendamento") AgendamentoDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("servicos", servicoService.listarTodos());
            return "agendamento/form";
        }
        agendamentoService.atualizar(id, dto);
        return "redirect:/agendamentos";
    }

    @PostMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
        return "redirect:/agendamentos";
    }
}
