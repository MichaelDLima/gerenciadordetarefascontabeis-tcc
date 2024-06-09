package br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto;

public record UsuarioDTO(Long id,
                         String nome,
                         String login,
                         String senha,
                         Integer nivel,
                         Character status) {
}
