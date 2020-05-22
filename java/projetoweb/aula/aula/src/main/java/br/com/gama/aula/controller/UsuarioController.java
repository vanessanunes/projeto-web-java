package br.com.gama.aula.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.aula.dao.UsuarioDAO;
import br.com.gama.aula.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> getAllUsers(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>) dao.findAll();
		
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable int id){
		System.out.println(id);
		Usuario usuario = dao.findById(id).orElse(null);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(usuario);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		Usuario usuarioLogado=dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		if(usuarioLogado==null) {
			return ResponseEntity.status(403).build();
		} else {
			return ResponseEntity.ok(usuarioLogado);
		}
	}
	

}

