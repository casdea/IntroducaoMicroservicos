package br.com.estudo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.domain.Usuario;
import br.com.estudo.repository.UserRepository;
import br.com.estudo.services.UsuarioService;
import br.com.estudo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UserRepository repository;
	
	//@Autowired
	//private Environment env;

	@Override
	public Usuario findById(Long id) {
		//log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}
}
