package br.ufrn.imd.controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;

import br.ufrn.imd.modelo.atletas.Atleta;
import br.ufrn.imd.modelo.atletas.AtletaColetivo;
import br.ufrn.imd.modelo.atletas.Selecao;
import br.ufrn.imd.modelo.esportes.Basquete;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.esportes.Futebol;
import br.ufrn.imd.modelo.esportes.Volei;
import br.ufrn.imd.modelo.partidas.Partida;


public class BancoSelecao {

	private HashSet<Selecao> selecoes;
	
	public BancoSelecao() throws FileNotFoundException {
		this.selecoes = new HashSet<Selecao>();
		
		URL urlSelecoes = getClass().getResource("selecoes.csv");
		File fileSelecoes = new File(urlSelecoes.getPath());
		Scanner scSelecoes = new Scanner(fileSelecoes);
		while(scSelecoes.hasNext()) {
			String line = scSelecoes.nextLine();
			String[] data = line.split(",");
			Selecao tmpSelecao = new Selecao();
			tmpSelecao.setID(Integer.parseInt(data[0]));
			tmpSelecao.setPais(data[1]);
			
			tmpSelecao.setEsporte(this.buscaEsportePorID(Integer.parseInt(data[2])));
			tmpSelecao.setTime(this.buscaAtletasPorSelecao(tmpSelecao.getID()));
			
		}
		scSelecoes.close();
		
	}
	
	private Esporte buscaEsportePorID(int ID) {
		URL urlEsportes = getClass().getResource("esportes.csv");
		File fileEsportes = new File(urlEsportes.getPath());
		Scanner scEsportes;
		Esporte esporte = null;
		try {
			scEsportes = new Scanner(fileEsportes);
			
			boolean encontrado = false;
			while(scEsportes.hasNext() && !encontrado) {
				String lineEsporte = scEsportes.nextLine();
				String[] dataEsporte = lineEsporte.split(",");
				if(dataEsporte[0].equals(String.valueOf(ID))) {
					if(dataEsporte[1].equals("Volei")) {
						esporte = new Volei();
					}
					else if(dataEsporte[1].equals("Basquete")) {
						esporte = new Basquete();
					}
					else if(dataEsporte[1].equals("Futebol")){
						esporte = new Futebol();
					}
					esporte.setID(ID);
					esporte.setNome(dataEsporte[1]);
					esporte.setGenero(dataEsporte[2]);
					encontrado = true;
				}
			}
			scEsportes.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return esporte;
	}
	
	private HashSet<Partida> buscaPartidaPorSelecao(int ID){
		return null;
	}

	private HashSet<Atleta> buscaAtletasPorSelecao(int ID){
		URL url = getClass().getResource("atletas.csv"); 
		File file = new File(url.getPath()); 
		Scanner sc;
		HashSet<Atleta> atletas = new HashSet<Atleta>();
	
		try {
			sc = new Scanner(file);
			while(sc.hasNext()) {
				String line = sc.nextLine(); 
				String[] data = line.split(","); 
				AtletaColetivo tmpAtleta = new AtletaColetivo();
				tmpAtleta.setNome(data[0]); 
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
				
				try{ 
					tmpAtleta.setDataNascimento(ft.parse(data[1])); 
				} catch(ParseException e){ 
					System.err.println("Erro ao analisar data usando " + ft); 
					System.exit(1);
				}
				tmpAtleta.setPeso(Double.parseDouble(data[2]));
				tmpAtleta.setAltura(Double.parseDouble(data[3]));
				tmpAtleta.setPosicao(data[4]);
				atletas.add(tmpAtleta);
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		
		
		return atletas;
	}
	
	public HashSet<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(HashSet<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

		
}
