package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientes_id")
    private Long clienteId;

    @Column(name = "tipo_cliente", length = 2, nullable = false)
    private String tipoCliente; // PF - Pessoa Física; PJ - Pessoa Jurídica

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    public Cliente(){
        this.endereco = new Endereco();
        this.contato = new Contato();
    }

    public Long getId() {
        return clienteId;
    }

    public void setId(Long id) {
        this.clienteId = id;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }
}
