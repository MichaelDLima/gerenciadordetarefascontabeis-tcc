package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "itens_tarefas")
public class ItemTarefa extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemTarefaId;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", foreignKey = @ForeignKey(name = "usuarios_fk"), nullable = false)
    private Usuario responsavel;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private LocalDate prazo;

    @ManyToOne
    @JoinColumn(name = "tarefas_id", foreignKey = @ForeignKey(name = "tarefas_fk"), nullable = false)
    private Tarefa tarefa;

    public ItemTarefa() {
    }

    public ItemTarefa(Usuario responsavel, Tarefa tarefa) {
        this.setResponsavel(responsavel);
        this.setTarefa(tarefa);
        this.setDataCriacao(LocalDate.now());
    }

    public Long getId() {
        return itemTarefaId;
    }

    public void setId(Long id) {
        this.itemTarefaId = id;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    private void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    private void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
