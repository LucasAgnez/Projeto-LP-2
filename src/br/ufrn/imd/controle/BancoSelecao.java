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
			
			String idEsporteString = data[2];
			
			
			URL urlEsportes = getClass().getResource("esportes.csv");
			File fileEsportes = new File(urlSelecoes.getPath());
			Scanner scEsportes = new Scanner(fileSelecoes);
			
			boolean encontrado = false;
			while(scEsportes.hasNext() && !encontrado) {
				String lineEsporte = scSelecoes.nextLine();
				String[] dataEsporte = line.split(",");
				if(dataEsporte[0].equals(idEsporteString)) {
					if(dataEsporte[1].equals("Volei")) {
						Volei tmpVolei = new Volei();
						tmpVolei.setID(Integer.parseInt(idEsporteString));
						tmpVolei.setNome(dataEsporte[1]);
						tmpVolei.setGenero(dataEsporte[2]);
						tmpSelecao.setEsporte(tmpVolei);
					}
					else if(dataEsporte[1].equals("Basquete")) {
						Basquete tmpBasquete = new Basquete();
						tmpBasquete.setID(Integer.parseInt(idEsporteString));
						tmpBasquete.setNome(dataEsporte[1]);
						tmpBasquete.setGenero(dataEsporte[2]);
						tmpSelecao.setEsporte(tmpBasquete);
					}
					else if(dataEsporte[1].equals("Futebol")){
						Futebol tmpFutebol = new Futebol();
						tmpFutebol.setID(Integer.parseInt(idEsporteString));
						tmpFutebol.setNome(dataEsporte[1]);
						tmpFutebol.setGenero(dataEsporte[2]);
						tmpSelecao.setEsporte(tmpFutebol);
					}
					encontrado = true;
				}
			}
			
			
		}
		
		
		
		
		
		
		/*
		 * URL url = getClass().getResource("atletas.csv"); File file = new
		 * File(url.getPath()); Scanner sc = new Scanner(file); while(sc.hasNext()) {
		 * String line = sc.nextLine(); String[] data = line.split(","); AtletaColetivo
		 * tmpAtleta = new AtletaColetivo();
		 * 
		 * tmpAtleta.setNome(data[0]); SimpleDateFormat ft = new
		 * SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * try{ tmpAtleta.setDataNascimento(ft.parse(data[1])); } catch(ParseException
		 * e){ System.err.println("Erro ao analisar data usando " + ft); System.exit(1);
		 * }
		 * 
		 * tmpAtleta.setPeso(Double.parseDouble(data[2]));
		 * tmpAtleta.setAltura(Double.parseDouble(data[3]));
		 * tmpAtleta.setPosicao(data[4]);
		 * 
		 * 
		 * 
		 * atletasIndividuais.add(tmpAtleta); }
		 * 
		 * sc.close(); this.atletas = file;
		 */
	}

	public HashSet<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(HashSet<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

		
}
