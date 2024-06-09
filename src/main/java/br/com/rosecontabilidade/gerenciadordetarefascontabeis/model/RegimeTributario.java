package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "regimes_tributarios")
public class RegimeTributario extends Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regimes_tributarios_id")
    private Long regimeTributarioId;

    @Column(length = 3, nullable = false, unique = true)
    private String sigla;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    public Long getId() {
        return regimeTributarioId;
    }

    public void setId(Long id) {
        this.regimeTributarioId = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
}
