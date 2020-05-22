package br.com.gama.aula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_aula_musica")
public class Musica {
	
	@Column(name="codigo")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="ano")
	private int ano;
	
	@ManyToOne
	private Artista artista;
	
	public Musica() {
		super();
	}

	public Musica(int codigo, String titulo, int ano, Artista artista) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
		this.artista = artista;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	
	
	
	
	
	
	
	

}
