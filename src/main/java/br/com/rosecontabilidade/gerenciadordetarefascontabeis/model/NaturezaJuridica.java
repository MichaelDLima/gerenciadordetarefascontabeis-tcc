package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "naturezas_juridicas")
public class NaturezaJuridica extends Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "naturezas_juridicas_id")
    private Long naturezaJuridicaId;

    @Column(nullable = false)
    private Integer codigo;

    @Column(length = 3, nullable = false, unique = true)
    private String sigla;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    public Long getId() {
        return naturezaJuridicaId;
    }

    public void setId(Long id) {
        this.naturezaJuridicaId = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public void setNome(String tipo) {
        this.nome = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
