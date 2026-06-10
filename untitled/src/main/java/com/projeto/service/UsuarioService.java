package com.projeto.service;

import com.projeto.entity.Usuario;
import com.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // SALVAR USUARIO
    public Usuario salvar(Usuario usuario) {

        usuario.setDataCadastro(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }

    // LISTAR TODOS
    public List<Usuario> listarTodos() {

        return usuarioRepository.findAll();
    }

    // BUSCAR POR ID
    public Usuario buscarPorId(Long id) {

        Optional<Usuario> usuario =
                usuarioRepository.findById(id);

        return usuario.orElse(null);
    }

    // Put
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setRole(usuarioAtualizado.getRole());

        return usuarioRepository.save(usuario);
    }

    // DELETAR
    public void deletar(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        if (!usuario.getDenuncias().isEmpty()) {
            throw new RuntimeException(
                    "Não é possível excluir um usuário que possui denúncias.");
        }

        usuarioRepository.delete(usuario);
    }
}