package br.com.alg.curso.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.alg.curso.mongodb.domain.Post;
import br.com.alg.curso.mongodb.domain.User;
import br.com.alg.curso.mongodb.dto.AuthorDTO;
import br.com.alg.curso.mongodb.repositories.PostRepository;
import br.com.alg.curso.mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		this.repository.deleteAll();
		this.postRepository.deleteAll();
		
		User maria  = new User(null, "Maria Brown", "maria@gmail.com");
		User alex  = new User(null, "Alex Green", "alex@gmail.com");
		User bob  = new User(null, "Bob Grey", "bob@gmail.com");
		
		this.repository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		this.postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
