package br.com.alura.liter_alura.repository;

import br.com.alura.liter_alura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);

    @Query("SELECT a FROM Autor a WHERE a.anoDeNascimento <= :ano AND (a.anoDeFalecimento IS NULL OR a.anoDeFalecimento > :ano)")
    List<Autor> findAutoresVivosNoAno(@Param("ano") Integer ano);
}
