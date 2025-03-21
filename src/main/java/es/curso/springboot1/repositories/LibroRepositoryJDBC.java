package es.curso.springboot1.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import es.curso.springboot1.negocio.Libro;

@Repository
@Qualifier("jdbc")

public class LibroRepositoryJDBC implements LibroRepository {
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public List<Libro> buscarTodos() {
        return plantilla.query("select * from libros", new LibroRowMapper());
    }

    @Override
    public void insertar(Libro libro) {
        plantilla.update("insert into libros values(?,?,?,?)",
                libro.getid(), libro.getTitulo(), libro.getAutor(), libro.getPaginas());
    }

    @Override
    public void borrar(String id) {
        plantilla.update("delete from libros where id=?", id);
    }

    @Override
    public List<Libro> buscarTodosPorTitulo(String titulo) {
        return plantilla.query("select * from libros where titulo like?", new LibroRowMapper(), "%" + titulo + "%");

    }

    @Override
    public List<Libro> buscarTodosPorAutor(String autor) {
        return plantilla.query("select * from libros where autor like?", new LibroRowMapper(), "%" + autor + "%");

    }

    @Override
    public Libro buscarUno(String id) {
        return plantilla.queryForObject("select * from libros where id=?", new LibroRowMapper(), id);

    }
   
    @Override
    public PageResponse<Libro> buscarPaginado(int page, int size) {
        int offset = page * size;
        String sql = "SELECT * FROM libros LIMIT ? OFFSET ?";
        List<Libro> libros = plantilla.query(sql, new LibroRowMapper(), size, offset);

        String countSql = "SELECT COUNT(*) FROM libros";
        int total = plantilla.queryForObject(countSql, Integer.class);

        return new PageResponse<>(libros, page, size, total);
    }
    }


