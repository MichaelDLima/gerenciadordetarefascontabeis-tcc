package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "portes_empresariais")
public class PorteEmpresarial extends Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portes_empresariais_id")
    private Long porteEmpresarialId;

    @Column(length = 3, nullable = false, unique = true)
    private String sigla;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    public Long getId() {
        return porteEmpresarialId;
    }

    public void setId(Long id) {
        this.porteEmpresarialId = id;
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
