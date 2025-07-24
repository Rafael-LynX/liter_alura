package br.com.alura.liter_alura.principal;

import br.com.alura.liter_alura.model.Autor;
import br.com.alura.liter_alura.model.DadosAutor;
import br.com.alura.liter_alura.model.DadosLivro;
import br.com.alura.liter_alura.model.Livro;
import br.com.alura.liter_alura.repository.AutorRepository;
import br.com.alura.liter_alura.repository.LivroRepository;
import br.com.alura.liter_alura.service.ConsumoApi;
import br.com.alura.liter_alura.service.ConverteDados;
import br.com.alura.liter_alura.service.RepostaApi;

import java.util.*;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LivroRepository repositorio;
    private AutorRepository repositorioAutor;
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    //private Optional<Autor> autorVivo;

    private final String URL_BASE = "https://gutendex.com/books/";

    public Principal (LivroRepository repositorio, AutorRepository repositorioAutor) { this.repositorio = repositorio;  this.repositorioAutor = repositorioAutor; }




    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    ----------------------------------------------------------
                                 Liter Alura - Aplicação de Livros
                    ----------------------------------------------------------
                    
                    1 - Buscar Livro pelo título
                    2 - Listar Livros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivo em um Determinado Ano
                    5 - Listar Livros em um Determinado Idioma
                    
                    ----------------------------------------------------------
                    9 - Sair                            
                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivrosPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEmUmAno();
                    break;
                case 5:
                    listarLivrosEmUmIdioma();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        }
    }

    private void buscarLivrosPeloTitulo() {
        DadosLivro dados = getDadosLivro();

        if (dados != null) {
            Autor autor = null;

            if (dados.autor() != null && !dados.autor().isEmpty()) {
                DadosAutor dadosAutor = dados.autor().get(0);

                autor = repositorioAutor.findByNome(dadosAutor.nome())
                        .orElseGet(() -> {
                            Autor novoAutor = new Autor(dadosAutor);
                            return  repositorioAutor.save(novoAutor);
                        });
            }

            Livro livro = new Livro(dados, autor);
            repositorio.save(livro);
            imprimirLivro(dados);
        }
    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o nome do livro: ");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(URL_BASE + "?search=" + nomeLivro.replace(" ", "+"));
        RepostaApi resposta = conversor.obterDados(json, RepostaApi.class);

        if (resposta != null && !resposta.results.isEmpty()) {
            return resposta.results.get(0);
        } else  {
            System.out.println("Nenhum livro encontrado!");
            return null;
        }
    }

    private void imprimirLivro(DadosLivro dadosLivro) {
        System.out.println("----- LIVRO -----");
        System.out.println("Titulo: " + dadosLivro.titulo());

        if (dadosLivro.autor() != null && !dadosLivro.autor().isEmpty()) {
            for (DadosAutor autor : dadosLivro.autor()) {
                System.out.println("Autor: " + autor.nome());
            }
        } else  {
            System.out.println("Nenhum autor encontrado!");
        }

        if (dadosLivro.idioma() != null && !dadosLivro.idioma().isEmpty()) {
            System.out.println("Idioma: " + dadosLivro.idioma().get(0));
        } else {
            System.out.println("Idioma: desconhecido");
        }

        System.out.println("Número de downloads: "  + dadosLivro.downloads());

    }

    private void listarLivrosRegistrados() {
        livros = repositorio.findAll();

        for (Livro livro : livros) {
            exibirLivrosDoBanco(livro);
        }
    }

    private void exibirLivrosDoBanco(Livro livro) {

        System.out.println("----- LIVRO -----");
        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Autor: " + (livro.getAutor() != null ? livro.getAutor().getNome(): "desconhecido"));
        System.out.println("Idioma: " + livro.getIdioma());
        System.out.println("Número de Downloads: " + livro.getDownloads());
        System.out.println("------------------");
        System.out.println("                  ");
    }


    private void listarAutoresRegistrados() {
        autores = repositorioAutor.findAll();

        for (Autor autor : autores) {
            imprimirAutor(autor);
        }
    }


    private void imprimirAutor(Autor autor) {
        System.out.println("----- AUTOR -----");
        System.out.println("Nome: " + autor.getNome());
        System.out.println("Ano de Nascimento: " + autor.getAnoDeNascimento());
        System.out.println("Ano de Falecimnto: " + (autor.getAnoDeFalecimento() != null ? autor.getAnoDeFalecimento(): "Ainda vivo"));
        if (autor.getLivros() != null && !autor.getLivros().isEmpty()) {
            System.out.println("Livros: [");
            for (int i = 0; i < autor.getLivros().size(); i++) {
                System.out.println(autor.getLivros().get(i).getTitulo());
                if (i < autor.getLivros().size() - 1) {
                    System.out.println(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("Nenhum livro encontrado!");
        }
        System.out.println("------------------");
        System.out.println("                  ");
    }


    private void listarAutoresVivosEmUmAno() {
        System.out.println("Insira o ano: ");
        int ano = leitura.nextInt();

        autores = repositorioAutor.findAutoresVivosNoAno(ano);

        for (Autor autor : autores) {
            imprimirAutor(autor);
        }
    }


    private void listarLivrosEmUmIdioma() {
        listaDeIdiomas();
        System.out.println("Insira o idioma para a Pesquisa: ");
        var idioma = leitura.nextLine();
        List<Livro> livrosPorIdioma = repositorio.findByIdioma(idioma);

        for (Livro livro : livrosPorIdioma) {
            exibirLivrosDoBanco(livro);

        }
    }

    private void listaDeIdiomas() {
        System.out.println("es- espanhol");
        System.out.println("en- inglês");
        System.out.println("fr- francês");
        System.out.println("pt- português");
    }
}
