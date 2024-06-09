package br.com.rosecontabilidade.gerenciadordetarefascontabeis.controller;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto.PessoaFisicaDTO;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.PessoaFisica;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping()
    public List<PessoaFisicaDTO> buscarPessoasFisicasTodos(){
        return pessoaFisicaService.buscarPessoasFisicasTodos();
    };

    @GetMapping("/filtrar")
    public List<PessoaFisicaDTO> buscarPessoasFisicasFiltrado(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String rg,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) Character status) {
        return pessoaFisicaService.buscarPessoasFisicasFiltrado(nome, rg, cpf, status);
    }

    @GetMapping("/{id}")
    public PessoaFisicaDTO buscarPessoaFisicaPorId(@PathVariable Long id) {
        return pessoaFisicaService.buscarPessoaFisicaPorId(id);
    }

    @PostMapping("/gravar")
    public ResponseEntity<?> gravarPessoaFisica(@RequestBody PessoaFisica pessoaFisica){
        try{
            PessoaFisicaDTO dto = pessoaFisicaService.gravarPessoaFisica(pessoaFisica);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
