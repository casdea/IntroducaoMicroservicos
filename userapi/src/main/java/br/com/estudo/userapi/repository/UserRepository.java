package br.com.estudo.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.userapi.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

}
