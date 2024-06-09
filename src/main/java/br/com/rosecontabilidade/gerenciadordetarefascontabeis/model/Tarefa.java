package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tarefas")
public class Tarefa extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarefas_id")
    private Long tarefaId;

    @ManyToOne
    private Usuario responsavel;

    @Column(nullable = false)
    private LocalDate dataCriacao;

    @ManyToOne
    private Obrigacao obrigacao;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private LocalDate prazo;

    @ManyToOne
    @JoinColumn(name = "clientes_id", foreignKey = @ForeignKey(name = "clientes_fk"), nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
    private List<ItemTarefa> itensTarefa = new ArrayList<>();

    public Tarefa() {
    }

    public Tarefa(Usuario responsavel, Cliente cliente, Obrigacao obrigacao) {
        this.setResponsavel(responsavel);
        this.setCliente(cliente);
        this.setObrigacao(obrigacao);
        this.setDataCriacao(LocalDate.now());
    }

    public Long getId() {
        return tarefaId;
    }

    public void setId(Long id) {
        this.tarefaId = id;
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

    public Obrigacao getObrigacao() {
        return obrigacao;
    }

    public void setObrigacao(Obrigacao obrigacao) {
        this.obrigacao = obrigacao;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemTarefa> getItensTarefa() {
        return itensTarefa;
    }

    public void setItensTarefa(ItemTarefa itemTarefa) {
        this.itensTarefa.add(itemTarefa);
    }
}
