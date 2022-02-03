package com.amanda.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.workshopmongo.domain.User;
import com.amanda.workshopmongo.services.UserService;

@RestController  //inf. que a classe é um recurso Rest
@RequestMapping(value = "/users") //caminho do end point 
public class UserResource {

	@Autowired //injeção de dependencia
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);  //importação
	}
	
}
