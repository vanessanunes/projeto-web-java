package br.com.gama.aula.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.gama.aula.model.Musica;

public interface MusicaDAO extends CrudRepository<Musica, Integer>{

}
