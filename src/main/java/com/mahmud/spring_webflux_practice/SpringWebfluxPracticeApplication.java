package com.mahmud.spring_webflux_practice;

import com.mahmud.spring_webflux_practice.model.User;
import com.mahmud.spring_webflux_practice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringWebfluxPracticeApplication implements CommandLineRunner {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@Autowired
    public SpringWebfluxPracticeApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("mugdho");
		user.setPassword(passwordEncoder.encode("mugdho"));
		userRepository.save(user);
	}

}

