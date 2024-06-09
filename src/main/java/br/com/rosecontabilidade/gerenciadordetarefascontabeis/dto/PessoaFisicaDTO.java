package br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto;

public record PessoaFisicaDTO(Long id,
                              String nome,
                              String rg,
                              String cpf,
                              Character status) {
}
