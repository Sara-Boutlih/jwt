package org.sid;

import org.sid.dao.TaskRepository;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtSpringSecApplication{
	

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
		System.out.println(" application démarée");
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}
	


}
