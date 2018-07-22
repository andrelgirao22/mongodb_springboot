package br.com.alg.curso.mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.alg.curso.mongodb.domain.User;
import br.com.alg.curso.mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		this.repository.deleteAll();
		
		User maria  = new User(null, "Maria Brown", "maria@gmail.com");
		User alex  = new User(null, "Alex Green", "alex@gmail.com");
		User bob  = new User(null, "Bob Grey", "bob@gmail.com");
		
		this.repository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
