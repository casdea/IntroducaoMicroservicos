package br.com.estudo.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.domain.Usuario;
import br.com.estudo.resources.UsuarioResource;
import br.com.estudo.services.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class UsuarioResourceImpl implements UsuarioResource {

	@Autowired	
	private UsuarioService service;

	@Override
	public ResponseEntity<Usuario> findById(Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@Override
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
