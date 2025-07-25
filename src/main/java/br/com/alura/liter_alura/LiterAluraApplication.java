package br.com.alura.liter_alura;

import br.com.alura.liter_alura.principal.Principal;
import br.com.alura.liter_alura.repository.AutorRepository;
import br.com.alura.liter_alura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository repositorio;
	@Autowired
	private AutorRepository repositorioAutor;


	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio,  repositorioAutor);
			principal.exibeMenu();
	}

}

// Cambridge Sketches