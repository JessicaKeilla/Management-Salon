package com.beautysalon.Implementacao;

import com.beautysalon.DTO.UserDTO;
import com.beautysalon.Inteface.UserService;
import com.beautysalon.model.Role;
import com.beautysalon.model.User;
import com.beautysalon.repository.RoleRepository;
import com.beautysalon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserDTO> listarTodos() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());

    }

    @Override
    public UserDTO buscarPorId(Long id) {
        return userRepository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }

    @Override
    public UserDTO salvar(UserDTO dto) throws IOException {
        User user = toEntity(dto);
        if (dto.getImagem() != null && !dto.getImagem().isEmpty()) {
            String nomeArquivo = UUID.randomUUID() + "_" + dto.getImagem().getOriginalFilename();
            Path caminho = Paths.get("src/main/webapp/uploads/usuarios", nomeArquivo);
            Files.createDirectories(caminho.getParent());
            dto.getImagem().transferTo(caminho.toFile());
            user.setImagem(nomeArquivo); //entidade.setImagem(nomeArquivo);
        }

        return toDTO(userRepository.save(user));

    }

    @Override
    public UserDTO atualizar(Long id, UserDTO dto) {
        User existente = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        existente.setNome(dto.getUsername());
        existente.setEmail(dto.getEmail());
        if (dto.getPassword() != null) {
            existente.setPassword(dto.getPassword()); // Lembre de codificar!
        }
        existente.setRoles(buscarRoles(dto.getRoleIds()));
        return toDTO(userRepository.save(existente));

    }

    @Override
    public void deletar(Long id) {
        userRepository.deleteById(id);
    }
    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getNome());
        dto.setEmail(user.getEmail());
        dto.setRoleIds(user.getRoles().stream().map(Role::getId).collect(Collectors.toSet()));
        return dto;
    }

    private User toEntity(UserDTO dto) {
        User user = new User();
        user.setNome(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Lembre de codificar!
        user.setRoles(buscarRoles(dto.getRoleIds()));
        return user;
    }

    private Set<Role> buscarRoles(Set<Long> ids) {
        return ids.stream().map(id -> roleRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Role não encontrada: " + id)))
                .collect(Collectors.toSet());
    }
}
