package com.fronchak.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fronchak.workshopmongodb.domain.dtos.user.AuthorDTO;
import com.fronchak.workshopmongodb.domain.entities.Post;
import com.fronchak.workshopmongodb.domain.entities.User;
import com.fronchak.workshopmongodb.domain.repositories.PostRepository;
import com.fronchak.workshopmongodb.domain.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User gabriel = new User(null, "Gabriel", "gabriel@gmail.com");
		User alice = new User(null, "Alice", "alice@gmail.com");
		User claudia = new User(null, "Claudia", "claudia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gabriel, alice, claudia));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Title 1", "Post body 1", new AuthorDTO(gabriel));
		Post post2 = new Post(null, sdf.parse("05/06/2018"), "Title 2", "Post body 2", new AuthorDTO(gabriel));
		

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		gabriel.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(gabriel);
	}
}
