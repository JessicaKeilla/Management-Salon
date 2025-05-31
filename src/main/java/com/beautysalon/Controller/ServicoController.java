package com.beautysalon.Controller;
import com.beautysalon.DTO.ServicoDTO;
import com.beautysalon.Inteface.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public String listar(Model model) {
        List<ServicoDTO> servicos = servicoService.listarTodos();
        model.addAttribute("servicos", servicos);
        model.addAttribute("pageTitle", "Lista de Serviços");
        model.addAttribute("contentPage", "/WEB-INF/views/servicos/listContent.jsp");
        return "template/layout";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("servico", new ServicoDTO());
        model.addAttribute("pageTitle", "Novo Serviço");
        model.addAttribute("contentPage", "/WEB-INF/views/servicos/formContent.jsp");
        return "template/layout";
    }

    @PostMapping
    public String salvar(@ModelAttribute ServicoDTO dto,
                         @RequestParam("imagem") MultipartFile imagemFile) throws IOException {

        if (!imagemFile.isEmpty()) {
            String nomeArquivo = imagemFile.getOriginalFilename();
            String caminho = "src/main/webapp/uploads/" + nomeArquivo;
            imagemFile.transferTo(new File(caminho));
            dto.setImagem(nomeArquivo);
        }

        servicoService.salvar(dto);
        return "redirect:/servicos";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Long id, Model model) {
        ServicoDTO servico = servicoService.buscarPorId(id);
        model.addAttribute("servico", servico);
        model.addAttribute("pageTitle", "Editar Serviço");
        model.addAttribute("contentPage", "/WEB-INF/views/servicos/formContent.jsp");
        return "template/layout";
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable Long id,
                            @ModelAttribute ServicoDTO dto,
                            @RequestParam("imagem") MultipartFile imagemFile) throws IOException {

        if (!imagemFile.isEmpty()) {
            String nomeArquivo = imagemFile.getOriginalFilename();
            String caminho = "src/main/webapp/uploads/" + nomeArquivo;
            imagemFile.transferTo(new File(caminho));
            dto.setImagem(nomeArquivo);
        }

        servicoService.atualizar(id, dto);
        return "redirect:/servicos";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        servicoService.excluir(id);
        return "redirect:/servicos";
    }
}
