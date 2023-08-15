package br.com.estudo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo.userapi.domain.Usuario;
import br.com.estudo.userapi.repository.UserRepository;

@SpringBootApplication
public class UserapiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UserapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userRepository.saveAll(List.of(
				new Usuario(null, "JOSE", "jose@gmail.com","123", Double.valueOf(20.00)),
				new Usuario(null, "MARIA", "maria@gmail.com","123", Double.valueOf(10.00))
				));
	}

}
