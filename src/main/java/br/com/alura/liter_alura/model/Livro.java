package br.com.alura.liter_alura.model;


import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Autor autor;

    private String idioma;

    private Double downloads;

    public Livro(String titulo) {
        this.titulo = titulo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", downloads=" + downloads;
    }
}
