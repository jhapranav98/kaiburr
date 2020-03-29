package com.example.kaiburrassignment;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerControllers {
	@Autowired
	private ServerRepository serverRepository;
	
	@GetMapping("/getMessage")
	public String getMessage() {
		return "Hello world";
	}
	@PutMapping("/add")
	public Server addServer(@RequestBody Server server) {
		return serverRepository.save(server);
	}
	@DeleteMapping("/deleteServer/{id}")
	public String deleteServer(@PathVariable String id) {
//		Server server = serverRepository.findById(id).get();
		serverRepository.deleteById(id);
		return "Server deleted from Database";
	}
	@GetMapping("/findByName/{name}")
	public Server findByName(@PathVariable String name) {
		return serverRepository.findByName(name);
	}
	@GetMapping("/getservers")
	public List<Server> getAllServer(){
		return serverRepository.findAll();
	}
}
