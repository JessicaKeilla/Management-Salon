package com.beautysalon.Inteface;

import com.beautysalon.DTO.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserDTO> listarTodos();
    UserDTO buscarPorId(Long id);
    UserDTO salvar(UserDTO dto) throws IOException;
    UserDTO atualizar(Long id, UserDTO dto);
    void deletar(Long id);
}
