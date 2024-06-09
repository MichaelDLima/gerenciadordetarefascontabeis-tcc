package br.com.rosecontabilidade.gerenciadordetarefascontabeis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas_juridicas")
public class PessoaJuridica extends Cliente{

    @OneToOne
    @JoinColumn(name = "clientes_id", foreignKey = @ForeignKey(name = "clientes_fk"), nullable = false)
    private Cliente cliente;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "inscricao_estadual", length = 9)
    private String inscricaoEstadual;

    @OneToOne
    @JoinColumn(name = "naturezas_juridicas_id", foreignKey = @ForeignKey(name = "naturezas_juridicas_fk"), nullable = false)
    private NaturezaJuridica naturezaJuridica;

    @OneToOne
    @JoinColumn(name = "portes_empresarias_id", foreignKey = @ForeignKey(name = "portes_empresarias_fk"), nullable = false)
    private PorteEmpresarial porteEmpresarial;

    @OneToOne
    @JoinColumn(name = "regimes_tributarios_id", foreignKey = @ForeignKey(name = "regimes_tributarios_fk"), nullable = false)
    private RegimeTributario regimeTributario;

    public PessoaJuridica(){
        this.naturezaJuridica = new NaturezaJuridica();
        this.porteEmpresarial = new PorteEmpresarial();
        this.regimeTributario = new RegimeTributario();
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setNaturezaJuridica(NaturezaJuridica naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public void setPorteEmpresarial(PorteEmpresarial porteEmpresarial) {
        this.porteEmpresarial = porteEmpresarial;
    }

    public void setRegimeTributario(RegimeTributario regimeTributario) {
        this.regimeTributario = regimeTributario;
    }
}
