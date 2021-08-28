package br.ufrn.imd.modelo.atletas;

import java.util.Date;

public class Atleta {
	private Date dataNascimento;
	private String nome;
	private double altura;
	private double peso;
	private String nacionalidade;

	
	public Atleta() {
		
	}
	
	public Atleta(Date dataNascimento, String nome, double altura, double peso, 
		String nacionalidade) {
		super();
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.nacionalidade = nacionalidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
