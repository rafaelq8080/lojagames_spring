package com.generation.lojagames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity                                             		
@Table(name = "tb_produtos")	
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull(message = "Nome é obrigatório!")                                       										
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Preço é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	private String foto;

	@Column(columnDefinition = "integer default 0")
	private int curtir;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getCurtir() {
		return curtir;
	}

	public void setCurtir(int curtir) {
		this.curtir = curtir;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}