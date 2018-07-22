package br.com.alg.curso.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alg.curso.mongodb.domain.User;
import br.com.alg.curso.mongodb.dto.UserDTO;
import br.com.alg.curso.mongodb.exceptions.ObjectNotFoudException;
import br.com.alg.curso.mongodb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = this.repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoudException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return this.repository.insert(obj);
	}
	
	public User update(User obj) {
		User newObj = this.findById(obj.getId());
		this.updateData(newObj, obj);
		return this.repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(String id) {
		User user = this.findById(id);
		this.repository.delete(user);
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
	
}
