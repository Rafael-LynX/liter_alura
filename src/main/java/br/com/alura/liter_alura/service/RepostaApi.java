package br.com.alura.liter_alura.service;

import br.com.alura.liter_alura.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepostaApi {
    public List<DadosLivro> results;
}
