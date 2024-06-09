package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Cadastro {
    @Column(nullable = false)
    private Character status; // Outros:              A - Ativo; I - Inativo;
                              // Tarefa/ItemTarefa:   P - Pendente; A - Em Andamento; C - Concluída; X - Cancelada;

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public abstract Long getId();
    public abstract void setId(Long id);
}
