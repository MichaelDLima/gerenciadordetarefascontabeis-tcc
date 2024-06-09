package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "obrigacoes")
public class Obrigacao extends Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obrigacoes_id")
    private Long obrigacaoId;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Character periodicidade; // D - Diária; S - Semanal; M - Mensal; T - Trimestral, E - Semestral; A - Anual;

    public Long getId() {
        return obrigacaoId;
    }

    public void setId(Long id) {
        this.obrigacaoId = id;
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

    public Character getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Character periodicidade) {
        this.periodicidade = periodicidade;
    }
}
