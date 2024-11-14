package com.saif.montres;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;
import com.saif.montres.service.MontreService;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled=true)

public class MontresApplication implements CommandLineRunner {
	MontreService  montreService;
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
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}
