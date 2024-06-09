package br.com.rosecontabilidade.gerenciadordetarefascontabeis.service;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto.SumarioDTO;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeService {

    @Autowired
    private TarefasRepository tarefasRepository;

    public SumarioDTO sumarizarTarefas() {
        return new SumarioDTO(tarefasRepository.countByStatus('P'),
                              tarefasRepository.countByStatus('A'),
                              tarefasRepository.ContarTarefasVencendoHoje(),
                              tarefasRepository.ContarTarefasVencidas());
    }
}
