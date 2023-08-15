package br.com.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

}
