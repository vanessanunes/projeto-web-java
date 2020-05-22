package br.com.gama.aula.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.gama.aula.model.Artista;

public interface ArtistaDAO extends CrudRepository<Artista, Integer>{
	public ArrayList<Artista> findByNacionalidade(String nacionalidade);
	
	
}
