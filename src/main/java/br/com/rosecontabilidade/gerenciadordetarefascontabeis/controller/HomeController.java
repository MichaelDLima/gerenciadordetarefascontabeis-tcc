package br.com.rosecontabilidade.gerenciadordetarefascontabeis.controller;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto.SumarioDTO;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/sumario")
    public SumarioDTO SumarizarTarefas(){
        return homeService.sumarizarTarefas();
    };
}
