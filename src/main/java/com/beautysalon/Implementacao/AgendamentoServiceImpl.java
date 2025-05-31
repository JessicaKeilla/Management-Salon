package com.beautysalon.Implementacao;

import com.beautysalon.DTO.AgendamentoDTO;
import com.beautysalon.Inteface.AgendamentoService;
import com.beautysalon.model.Agendamento;
import com.beautysalon.repository.AgendamentoRepository;
import com.beautysalon.repository.ClienteRepository;
import com.beautysalon.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Isso informa ao Spring que esta classe é um componente de
// serviço e deve ser gerenciada pelo contêiner de injeção de dependência.

public class AgendamentoServiceImpl  implements AgendamentoService
{
    //todas as anotacoe autowired esta dar erro, so na anotacao
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public List<AgendamentoDTO> listarTodos() {
        return agendamentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AgendamentoDTO buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

    }

    @Override
    public AgendamentoDTO salvar(AgendamentoDTO dto) {
        Agendamento agendamento = toEntity(dto);
        return toDTO(agendamentoRepository.save(agendamento));

    }

    @Override
    public AgendamentoDTO atualizar(Long id, AgendamentoDTO dto) {
//        Agendamento existente = agendamentoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
//        existente.setDataHora(dto.getDataHora());
//        existente.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null)); //setCliente nao funciona
//       // existente.setServico(servicoRepository.findById(dto.getServicoId()).orElse(null));//setServico tambem , e o restate dos
//        return toDTO(agendamentoRepository.save(existente));
        return null;
    }

    @Override
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);

    }
    private AgendamentoDTO toDTO(Agendamento a) {
        AgendamentoDTO dto = new AgendamentoDTO();
//        dto.setId(a.getId());
//        dto.setDataHora(a.getDataHora());
//        dto.setClienteId(a.getCliente().getId());
//        //dto.setServicoId(a.getServico().getId());
        return dto;
    }

    private Agendamento toEntity(AgendamentoDTO dto) {
        Agendamento agendamento = new Agendamento();
//        agendamento.setDataHora(dto.getDataHora());
//        agendamento.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));
//      //  agendamento.setServico(servicoRepository.findById(dto.getServicoId()).orElse(null));
        return agendamento;
    }
}
