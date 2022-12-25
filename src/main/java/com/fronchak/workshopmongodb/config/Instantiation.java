package com.fronchak.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fronchak.workshopmongodb.domain.entities.User;
import com.fronchak.workshopmongodb.domain.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		User gabriel = new User(null, "Gabriel", "gabriel@gmail.com");
		User alice = new User(null, "Alice", "alice@gmail.com");
		User claudia = new User(null, "Claudia", "claudia@gmail.com");
		
		repository.saveAll(Arrays.asList(gabriel, alice, claudia));
	}
}
