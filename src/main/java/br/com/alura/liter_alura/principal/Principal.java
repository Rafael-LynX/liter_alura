package br.com.alura.liter_alura.principal;

import br.com.alura.liter_alura.service.ConsumoApi;
import br.com.alura.liter_alura.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String URL_BASE = "https://gutendex.com/";


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
        System.out.println("Digite o nome do livro: ");
        var nome = leitura.nextLine();

    }




    private void listarLivrosRegistrados() {}




    private void listarAutoresRegistrados() {}




    private void listarAutoresVivosEmUmAno() {}




    private void listarLivrosEmUmIdioma() {}









}
