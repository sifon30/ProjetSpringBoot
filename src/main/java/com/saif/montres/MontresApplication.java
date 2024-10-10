package com.saif.montres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;

@SpringBootApplication
public class MontresApplication implements CommandLineRunner {
	
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration; 
	public static void main(String[] args) {
		SpringApplication.run(MontresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Montre.class,Genre.class); 

		// TODO Auto-generated method stub
		
	}

}
