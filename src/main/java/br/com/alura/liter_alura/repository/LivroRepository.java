package br.com.alura.liter_alura.repository;

import br.com.alura.liter_alura.model.Autor;
import br.com.alura.liter_alura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(String idioma);


}
