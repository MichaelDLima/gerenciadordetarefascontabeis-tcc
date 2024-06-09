package br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto;

public record SumarioDTO(Integer pendentes,
                         Integer emAndamento,
                         Integer vencemHoje,
                         Integer vencidas) {
}
