package es.curso.springboot1.repositories;
import java.util.List;
import es.curso.springboot1.negocio.Libro;

public interface LibroRepository {
    List<Libro> buscarTodos();
    List<Libro> buscarTodosPorTitulo(String titulo);
    List<Libro> buscarTodosPorAutor(String autor);
    Libro buscarUno(String isbn);
    
    void insertar(Libro libro);
    void borrar(String id);

    PageResponse<Libro> buscarPaginado(int page, int size);
}

