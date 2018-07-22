package br.com.alg.curso.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.alg.curso.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{

}
