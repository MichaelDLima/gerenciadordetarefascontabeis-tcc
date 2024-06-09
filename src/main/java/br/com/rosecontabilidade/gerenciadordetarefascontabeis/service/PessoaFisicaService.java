package br.com.rosecontabilidade.gerenciadordetarefascontabeis.service;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto.PessoaFisicaDTO;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.PessoaFisica;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.repository.PessoaFisicaRepository;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.specification.PessoaFisicaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public List<PessoaFisicaDTO> buscarPessoasFisicasTodos() {
        return converterListaParaDTO(pessoaFisicaRepository.findAll());
    }

    public List<PessoaFisicaDTO> buscarPessoasFisicasFiltrado(String nome, String rg, String cpf, Character status) {
        return converterListaParaDTO(pessoaFisicaRepository.findAll(PessoaFisicaSpecification.withFilters(nome, rg, cpf, status)));
    }

    public PessoaFisicaDTO buscarPessoaFisicaPorId(Long id){
        Optional<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findById(id);

        return pessoaFisica.map(this::converterParaDTO).orElse(null);
    }

    public Boolean pessoaFisicaExiste(PessoaFisica pessoaFisica){
        Optional<PessoaFisica> pf = pessoaFisicaRepository.findByCpf(pessoaFisica.getCpf());
        return pf.isPresent() && !pf.get().getId().equals(pessoaFisica.getId());
    }

    public PessoaFisicaDTO gravarPessoaFisica(PessoaFisica pessoaFisica) {
        if (pessoaFisicaExiste(pessoaFisica)) {
            throw new RuntimeException("CPF já existente.");
        }

        PessoaFisica pf = pessoaFisicaRepository.save(pessoaFisica);
        return converterParaDTO(pf);
    }

    private List<PessoaFisicaDTO> converterListaParaDTO(List<PessoaFisica> pessoaFisica) {
        return pessoaFisica.stream()
                .sorted(Comparator.comparing(PessoaFisica::getNome))
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private PessoaFisicaDTO converterParaDTO(PessoaFisica pf){
        return new PessoaFisicaDTO(pf.getId(), pf.getNome(), pf.getRg(), pf.getCpf(), pf.getStatus());
    }
}
