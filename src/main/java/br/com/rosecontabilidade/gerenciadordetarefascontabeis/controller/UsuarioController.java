package br.com.rosecontabilidade.gerenciadordetarefascontabeis.controller;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto.UsuarioDTO;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.Usuario;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<UsuarioDTO> buscarUsuariosTodos(){
        return usuarioService.buscarUsuariosTodos();
    };

    @GetMapping("/filtrar")
    public List<UsuarioDTO> buscarUsuariosFiltrado(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String login,
            @RequestParam(required = false) Integer nivel,
            @RequestParam(required = false) Character status) {
        return usuarioService.buscarUsuariosFiltrado(nome, login, nivel, status);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping("/gravar")
    public ResponseEntity<?> gravarUsuario(@RequestBody Usuario usuario){
        try{
            UsuarioDTO dto = usuarioService.gravarUsuario(usuario);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
