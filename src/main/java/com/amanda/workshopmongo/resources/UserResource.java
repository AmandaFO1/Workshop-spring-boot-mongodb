package com.amanda.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.workshopmongo.domain.User;
import com.amanda.workshopmongo.dto.UserDTO;
import com.amanda.workshopmongo.services.UserService;

@RestController  //inf. que a classe é um recurso Rest
@RequestMapping(value = "/users") //caminho do end point 
public class UserResource {

	@Autowired //injeção de dependencia
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll(); 
		List<UserDTO> listDto = list.stream().map(x ->new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);  //importação
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findAll(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));  //importação
	}
	
}
