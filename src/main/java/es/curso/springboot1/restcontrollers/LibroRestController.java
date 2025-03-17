package es.curso.springboot1.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.curso.springboot1.negocio.Libro;
import es.curso.springboot1.repositories.LibroRepository;
import es.curso.springboot1.repositories.PageResponse;

@RestController
@RequestMapping("/webapi/libros")
public class LibroRestController {
    @Autowired
    @Qualifier("jdbc")
    private LibroRepository libroRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Libro> buscarTodos() {
        return libroRepository.buscarTodos();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public void insertar(@RequestBody Libro libro) {
        libroRepository.insertar(libro);
    }

    @DeleteMapping("/libros/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void borrarLibro(@PathVariable String id) {
        libroRepository.borrar(id);
    }

    @GetMapping(params = { "titulo" })
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Libro> buscarTodosPorTitulo(@RequestParam String titulo) {
        return libroRepository.buscarTodosPorTitulo(titulo);
    }

    @GetMapping(params = { "autor" })
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Libro> buscarTodosPorAutor(@RequestParam String autor) {
        return libroRepository.buscarTodosPorAutor(autor);
    }

    @GetMapping("/{isbn}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Libro buscarUno(@PathVariable String isbn) {
        return libroRepository.buscarUno(isbn);
    }

      @GetMapping("/paginado")
      public PageResponse<Libro> obtenerOrdenadoresPaginado(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "5") int size) {
        return libroRepository.buscarPaginado(page, size);
    }
}