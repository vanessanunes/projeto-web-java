package br.com.gama.aula.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.aula.dao.ArtistaDAO;
import br.com.gama.aula.model.Artista;

@CrossOrigin("*")
@RestController
public class ArtistaController {
	
	@Autowired
	private ArtistaDAO dao;
	
	@GetMapping("/artistas")	
	public ResponseEntity<ArrayList<Artista>> getAllArtistas(){
		ArrayList<Artista> lista = (ArrayList<Artista>) dao.findAll();
		if (lista.size() == 0) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/artista/{codigo}")
	public ResponseEntity<Artista> getArtistaById(@PathVariable int codigo){
		Artista artista = dao.findById(codigo).orElse(null);
		if (artista==null) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(artista);
		}
	}
	
	@GetMapping("/artista/{nacionalidade}")
	public ResponseEntity<ArrayList<Artista>> getByNacionalidade(@PathVariable String nacionalidade){
		ArrayList<Artista> artistas = dao.findByNacionalidade(nacionalidade);
		if (artistas==null) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(artistas);
		}
	}
	
	@PostMapping("/artista/novo")
	public ResponseEntity<Artista> adicionarArtista(@RequestBody Artista novo){
		try {
			dao.save(novo);
			return ResponseEntity.ok(novo);
		} catch(Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
}
