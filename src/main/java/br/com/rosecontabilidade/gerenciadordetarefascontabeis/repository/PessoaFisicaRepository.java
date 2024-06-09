package br.com.rosecontabilidade.gerenciadordetarefascontabeis.repository;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>, JpaSpecificationExecutor<PessoaFisica> {
    List<PessoaFisica> findAll();

    Optional<PessoaFisica> findById(Long id);

    Optional<PessoaFisica> findByCpf(String login);
}
