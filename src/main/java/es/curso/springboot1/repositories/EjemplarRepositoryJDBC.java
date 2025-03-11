package es.curso.springboot1.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import es.curso.springboot1.negocio.Ejemplar;

    @Repository
@Qualifier("jdbc")

public class EjemplarRepositoryJDBC implements EjemplarRepository{
@Autowired
private JdbcTemplate plantilla;

 @Override
    public List<Ejemplar> buscarTodos() {
        return plantilla.query("select * from ejemplar", new EjemplarRowMapper());
    }

@Override
public Ejemplar buscarUno(String isbn, int numero) {
    return plantilla.queryForObject("select * from ejemplar where isbn=? and numero=?", new EjemplarRowMapper(), isbn, numero);

  
   
}

@Override
public void insertar(Ejemplar ejemplar) {
    plantilla.update("insert into ejemplar values(?,?,?)",
    ejemplar.getIsbn(), ejemplar.getNumero(), ejemplar.isDisponible());
  
}

@Override
public void borrar(Ejemplar ejemplar) {
    plantilla.update("delete from ejemplar where isbn=?", ejemplar.getIsbn());
   
}

}

