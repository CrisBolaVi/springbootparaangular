package es.curso.springboot1.negocio;

public class Libro {

    private String id;
    private String titulo;
    private String autor;
    private int paginas;
    
    public Libro(String id, String titulo, String autor, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }
    public Libro(String id) {
        this.id = id;
    }
    public Libro() {
    }
    public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
}
