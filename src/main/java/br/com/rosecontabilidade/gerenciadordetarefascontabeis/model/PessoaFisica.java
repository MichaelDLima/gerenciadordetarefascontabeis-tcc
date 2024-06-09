package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas_fisicas")
public class PessoaFisica extends Cliente {

    @OneToOne
    @JoinColumn(name = "clientes_id", foreignKey = @ForeignKey(name = "clientes_fk"), nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private String nome;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 10, unique = true)
    private String rg;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}
