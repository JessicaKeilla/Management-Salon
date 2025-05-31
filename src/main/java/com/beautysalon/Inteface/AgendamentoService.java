package com.beautysalon.Inteface;


import com.beautysalon.DTO.AgendamentoDTO;

import java.util.List;

//gravar essa pasta como Service
public interface AgendamentoService
{
    List<AgendamentoDTO> listarTodos();
    AgendamentoDTO buscarPorId(Long id);
    AgendamentoDTO salvar(AgendamentoDTO dto);
    AgendamentoDTO atualizar(Long id, AgendamentoDTO dto);
    void deletar(Long id);
}
