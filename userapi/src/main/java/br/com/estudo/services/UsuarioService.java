package br.com.estudo.services;

import java.util.List;

import br.com.estudo.domain.Usuario;

public interface UsuarioService {
	Usuario findById(Long id);

	List<Usuario> findAll();
}
