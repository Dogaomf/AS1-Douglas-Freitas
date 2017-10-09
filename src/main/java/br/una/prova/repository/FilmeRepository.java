
package br.una.prova.repository;

import br.una.prova.entity.Filme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmeRepository extends CrudRepository<Filme, Integer>{
    List<Filme> findByNomeLike(String nome);
    List<Filme> findByNotaImdbGreaterThan(int notaImdb);

}
