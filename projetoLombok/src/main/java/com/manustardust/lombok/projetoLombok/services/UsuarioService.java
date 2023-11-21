package com.manustardust.lombok.projetoLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manustardust.lombok.projetoLombok.entities.Usuario;
import com.manustardust.lombok.projetoLombok.repositories.UsuarioRepositorio;


@Service
public class UsuarioService {
	private final UsuarioRepositorio userRepository;

	public UsuarioService(UsuarioRepositorio userRepository) {
		this.userRepository = userRepository;
	}

// preparando as buscas por id
	public Usuario findUsuarioById(Long id) {
		Optional<Usuario> Usuario = userRepository.findById(id);
		return Usuario.orElse(null);
	}

//preparando a busca geral
	public List<Usuario> findAllUsuario() {
		return userRepository.findAll();
	}

	// salvando o Jogo
	public Usuario insertUsuario(Usuario usuario) {
		return userRepository.save(usuario);
	}

	// fazendo o update do jogo com o optional
	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = userRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setEmail(novoUsuario.getEmail());

			return userRepository.save(usuarioExistente);
		} else {
			return null;
		}
	}

	// deletando o update do usuario com o optional
	public boolean deleteUsuario(Long id) {
		Optional<Usuario> usuarioExistente = userRepository.findById(id);
		if (usuarioExistente.isPresent()) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}