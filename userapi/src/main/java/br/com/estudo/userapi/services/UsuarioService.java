package br.com.estudo.userapi.services;

import java.util.List;

import br.com.estudo.userapi.domain.Usuario;

public interface UsuarioService {
	Usuario findById(Long id);

	List<Usuario> findAll();
}
