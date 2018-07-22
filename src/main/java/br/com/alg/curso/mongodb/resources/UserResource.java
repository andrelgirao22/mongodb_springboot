package br.com.alg.curso.mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alg.curso.mongodb.domain.User;
import br.com.alg.curso.mongodb.dto.UserDTO;
import br.com.alg.curso.mongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = this.service.findAll();
		List<UserDTO> listDto = 
				list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = this.service.findById(id);
		UserDTO objDto = new UserDTO(obj);
		return ResponseEntity.ok(objDto);
	}
	
}
