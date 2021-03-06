package br.com.alg.curso.mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alg.curso.mongodb.domain.Post;
import br.com.alg.curso.mongodb.exceptions.ObjectNotFoudException;
import br.com.alg.curso.mongodb.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll() {
		return this.repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> user = this.repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoudException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return this.repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return this.repository.fullSearch(text, minDate, maxDate);
	}
	
	
	
}
