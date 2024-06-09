package br.com.rosecontabilidade.gerenciadordetarefascontabeis.service;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.dto.UsuarioDTO;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.Usuario;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.repository.UsuarioRepository;
import br.com.rosecontabilidade.gerenciadordetarefascontabeis.specification.UsuarioSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> buscarUsuariosTodos() {
        return converterListaParaDTO(usuarioRepository.findAll());
    }

    public List<UsuarioDTO> buscarUsuariosFiltrado(String nome, String login, Integer nivel, Character status) {
        return converterListaParaDTO(usuarioRepository.findAll(UsuarioSpecification.withFilters(nome, login, nivel, status)));
    }

    public UsuarioDTO buscarUsuarioPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.map(this::converterParaDTO).orElse(null);
    }

    public Boolean usuarioExiste(Usuario usuario){
        Optional<Usuario> u = usuarioRepository.findByLogin(usuario.getLogin());
        return u.isPresent() && !u.get().getId().equals(usuario.getId());
    }

    public UsuarioDTO gravarUsuario(Usuario usuario) {
        if (usuarioExiste(usuario)) {
            throw new RuntimeException("Login já existente.");
        }

        Usuario u = usuarioRepository.save(usuario);
        return converterParaDTO(u);
    }

    private List<UsuarioDTO> converterListaParaDTO(List<Usuario> usuarios) {
        return usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private UsuarioDTO converterParaDTO(Usuario u){
        return new UsuarioDTO(u.getId(), u.getNome(), u.getLogin(), u.getSenha(), u.getNivel(), u.getStatus());
    }
}
