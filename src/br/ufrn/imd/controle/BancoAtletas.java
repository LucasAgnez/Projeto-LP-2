package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.ufrn.imd.modelo.atletas.*;

public class BancoAtletas {
	private Set<Selecao> selecoes;
	private Set<Atleta> atletasIndividuais;
	private File atletas;
	
	public BancoAtletas() throws FileNotFoundException {
		this.selecoes = new HashSet<Selecao>();
		this.atletasIndividuais = new HashSet<Atleta>();
		URL url = getClass().getResource("atletas.csv");
		System.out.println(url.getPath());
		File file = new File(url.getPath());
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] data = line.split(",");
			AtletaColetivo tmpAtleta = new AtletaColetivo();
			
			tmpAtleta.setNome(data[0]);
			SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
			
			try{
				tmpAtleta.setDataNascimento(ft.parse(data[1]));
			}
			catch(ParseException e){
				System.err.println("Erro ao analisar data usando " + ft);
				System.exit(1);
			}
			
			tmpAtleta.setPeso(Double.parseDouble(data[2]));
			tmpAtleta.setAltura(Double.parseDouble(data[3]));
			tmpAtleta.setPosicao(data[4]);
			
			
			
			atletasIndividuais.add(tmpAtleta);
		}
		
		sc.close();
		this.atletas = file; 
	}
	
	
	
	public File getAtletas() {
		return atletas;
	}



	public void setAtletas(File atletas) {
		this.atletas = atletas;
	}



	public Set<Selecao> getSelecoes() {
		return selecoes;
	}
	
	public void setSelecoes(Set<Selecao> selecoes) {
		this.selecoes = selecoes;
	}
	
	public void addSelecao(Selecao selecao) {
		selecoes.add(selecao);
	}
	
	public Set<Atleta> getAtletasIndividuais() {
		return atletasIndividuais;
	}
	
	public void setAtletasIndividuais(Set<Atleta> atletasIndividuais) {
		this.atletasIndividuais = atletasIndividuais;
	}
	
	public void addAtleta(Atleta atleta) {
		atletasIndividuais.add(atleta);
	}
	
	public ArrayList<Atleta>  buscarAtleta(String nome) {
		ArrayList<Atleta> atls = new ArrayList<Atleta>();
		for(Atleta a : atletasIndividuais) {
			if(a.getNome().equalsIgnoreCase(nome)) {
				atls.add(a);
			}
		}
		for(Selecao s : selecoes) {
			for(Atleta a : s.getTime()) {
				if(a.getNome().equalsIgnoreCase(nome)) {
					atls.add(a);
				}
			}
		}
		return atls;
	}
	
	public Selecao buscarSelecao(String nome) {
		for(Selecao s : selecoes) {
			if(nome.equalsIgnoreCase(s.getPais())) {
				return s;
			}
		}
		System.out.println("selecao nao encontrada");
		return null;
	}

}

