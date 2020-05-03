package br.com.otima.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.otima.cadastro.service.ICadastroService;

@SpringBootApplication
public class Application {
	
	@Autowired
	ICadastroService cadastroService;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	

}
