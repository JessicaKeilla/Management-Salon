package com.beautysalon.Implementacao;

import com.beautysalon.DTO.ClienteDTO;
import com.beautysalon.Inteface.ClienteService;
import com.beautysalon.model.Cliente;
import com.beautysalon.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        Cliente salvo = clienteRepository.save(cliente);
        return toDTO(salvo);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
    @Override
    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        Cliente atualizado = clienteRepository.save(cliente);
        return toDTO(atualizado);
    }

}
