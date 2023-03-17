package com.myspace.config;

import com.myspace.dtos.AuthorDTO;
import com.myspace.dtos.CommentDTO;
import com.myspace.entities.Post;
import com.myspace.entities.User;
import com.myspace.repositories.PostRepository;
import com.myspace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Seed implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        var p1 = new Post(null, sdf.parse("16/03/2023"), "Partiu Viajem", "Indo viajar Londres", new AuthorDTO(maria));
        var p2 = new Post(null, sdf.parse("17/03/2023"), "Partiu Viajem", "Indo viajar Paris", new AuthorDTO(maria));

        var c1 = new CommentDTO("Boa viagem", sdf.parse("15/03/2023"), new AuthorDTO(alex));
        var c2 = new CommentDTO("Sucesso", sdf.parse("16/03/2023"), new AuthorDTO(bob));
        var c3 = new CommentDTO("Have a nice day!!", sdf.parse("17/03/2023"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);
    }
}
