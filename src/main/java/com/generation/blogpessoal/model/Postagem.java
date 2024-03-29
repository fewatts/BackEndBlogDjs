package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "tb_postagens")
public class Postagem {
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank(message = "O atributo título é obrigatório!")
		@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 5 e no máximo 100 caracteres!")
		private String titulo;
		
		@NotBlank(message = "O atributo texto é obrigatório!")
		@Size(min = 10, max = 100, message = "O atributo texto deve conter no mínimo 10 e no máximo 100 caracteres!")
		private String texto;

		@Size(max = 5000, message = "O link do set não pode ser maior do que 5000 caracteres")
		private String link;
		
		@UpdateTimestamp
		private LocalDateTime data;

	@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Tema tema;

	@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
