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

import br.com.gama.aula.dao.MusicaDAO;
import br.com.gama.aula.model.Artista;
import br.com.gama.aula.model.Musica;

@CrossOrigin("*")
@RestController
public class MusicaController {
	
	@Autowired
	private MusicaDAO dao;
	
	@PostMapping("/musica/nova")
	public ResponseEntity<Musica> adicionarMusica(@RequestBody Musica musica){
		try {
			dao.save(musica);
			return ResponseEntity.ok(musica);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
	
	@GetMapping("/musicas")
	public ResponseEntity<ArrayList<Musica>> getAllMusicas(){
		ArrayList<Musica> musicas = (ArrayList<Musica>) dao.findAll();
		if (musicas.size()==0) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(musicas);
		}
	}
	
	@GetMapping("/musica/{codigo}")
	public ResponseEntity<Musica> getArtistaById(@PathVariable int codigo){
		Musica musica = dao.findById(codigo).orElse(null);
		if (musica==null) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(musica);
		}
	}

}
