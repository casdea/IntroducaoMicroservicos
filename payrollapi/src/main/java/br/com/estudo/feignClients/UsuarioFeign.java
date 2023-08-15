package br.com.estudo.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.estudo.domain.Usuario;

@FeignClient(name = "user-api")
public interface UsuarioFeign {

	@GetMapping(value = "/api/users/{id}")
	ResponseEntity<Usuario> findById(@PathVariable Long id);

	@GetMapping
	ResponseEntity<List<Usuario>> findAll();

}
