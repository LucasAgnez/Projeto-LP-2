package br.ufrn.imd.controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import br.ufrn.imd.modelo.atletas.Atleta;
import br.ufrn.imd.modelo.atletas.AtletaColetivo;
import br.ufrn.imd.modelo.atletas.Selecao;
import br.ufrn.imd.modelo.esportes.Basquete;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.esportes.Futebol;
import br.ufrn.imd.modelo.esportes.Volei;
import br.ufrn.imd.modelo.partidas.PartidaBasquete;
import br.ufrn.imd.modelo.partidas.PartidaFutebol;
import br.ufrn.imd.modelo.partidas.PartidaVolei;


public class BancoSelecao {

	private HashSet<Selecao> selecoes;
	
	private static BancoSelecao bancoSelecao;
	
	private HashSet<PartidaFutebol> partidasFutebol;
	private HashSet<PartidaBasquete> partidasBasquete;
	private HashSet<PartidaVolei> partidasVolei;
	
	public BancoSelecao() throws FileNotFoundException {
		this.selecoes = new HashSet<Selecao>();
		
		File fileSelecoes = new File("resources" + File.separator + "selecoes.csv");
		Scanner scSelecoes = new Scanner(fileSelecoes);
		while(scSelecoes.hasNext()) {
			String line = scSelecoes.nextLine();
			String[] data = line.split(",");
			Selecao tmpSelecao = new Selecao();
			tmpSelecao.setID(Integer.parseInt(data[0]));
			tmpSelecao.setPais(data[1]);
			
			tmpSelecao.setEsporte(this.buscaEsportePorID(Integer.parseInt(data[2])));
			tmpSelecao.setTime(this.buscaAtletasPorSelecao(tmpSelecao.getID()));
			this.selecoes.add(tmpSelecao);
			
		}
		scSelecoes.close();
		
	
		//Setando as partidas
		partidasFutebol = this.buscaPartidasFutebol();
		partidasBasquete = this.buscaPartidasBasquete();
		partidasVolei = this.buscaPartidasVolei();
		for(Selecao selecao : this.selecoes) {
			Esporte esporte = selecao.getEsporte();
			if(esporte instanceof Futebol) {
				((Futebol)esporte).setPartidas(partidasFutebol);
			}
			else if(esporte instanceof Volei) {
				((Volei) esporte).setPartidas(partidasVolei);
			}
			else if(esporte instanceof Basquete) {
				((Basquete) esporte).setPartidas(partidasBasquete);
			}
		}
		
	}
	
	
	private HashSet<PartidaBasquete> buscaPartidasBasquete() {
		//URL url = getClass().getResource("partidas_basquete.csv");
		File file = new File("resources" + File.separator + "partidas_basquete.csv");
		Scanner sc;
		
		HashSet<PartidaBasquete> partidas = new HashSet<PartidaBasquete>(); 
		try {
			sc = new Scanner(file);
			
			while(sc.hasNext()) {
				PartidaBasquete tmpPartida = new PartidaBasquete();
				
				String line = sc.nextLine();
				String[] data= line.split(",");
				
				tmpPartida.setParticipante1(this.getSelecaoPorID(Integer.parseInt(data[0])));
				tmpPartida.setParticipante2(this.getSelecaoPorID(Integer.parseInt(data[1])));
				tmpPartida.setDescricao(data[2]);
				tmpPartida.setPontuacaoParticipante1(Integer.parseInt(data[3]));
				tmpPartida.setPontuacaoParticipante2(Integer.parseInt(data[4]));
				tmpPartida.calculaVencedor();
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				try{ 
					tmpPartida.setData(ft.parse(data[5])); 
				} catch(ParseException e){ 
					System.err.println("Erro ao analisar data usando " + ft); 
					System.exit(1);
				}
				
				partidas.add(tmpPartida);
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return partidas;
	}


	private HashSet<PartidaVolei> buscaPartidasVolei() {
		//URL url = getClass().getResource( "partidas_volei.csv");
		File file = new File("resources" + File.separator +  "partidas_volei.csv");
		Scanner sc;
		
		HashSet<PartidaVolei> partidas = new HashSet<PartidaVolei>(); 
		try {
			sc = new Scanner(file);
			
			while(sc.hasNext()) {
				PartidaVolei tmpPartida = new PartidaVolei();
				
				String line = sc.nextLine();
				String[] data= line.split(",");
				
				tmpPartida.setParticipante1(this.getSelecaoPorID(Integer.parseInt(data[0])));
				tmpPartida.setParticipante2(this.getSelecaoPorID(Integer.parseInt(data[1])));
				tmpPartida.setDescricao(data[2]);
				tmpPartida.setPontosSet1Parti1(Integer.parseInt(data[3]));
				tmpPartida.setPontosSet1Parti2(Integer.parseInt(data[4]));
				tmpPartida.setPontosSet2Parti1(Integer.parseInt(data[5]));
				tmpPartida.setPontosSet2Parti2(Integer.parseInt(data[6]));
				tmpPartida.setPontosSet3Parti1(Integer.parseInt(data[7]));
				tmpPartida.setPontosSet3Parti2(Integer.parseInt(data[8]));
				tmpPartida.setPontosSet4Parti1(Integer.parseInt(data[9]));
				tmpPartida.setPontosSet4Parti2(Integer.parseInt(data[10]));
				tmpPartida.setPontosSet5Parti1(Integer.parseInt(data[11]));
				tmpPartida.setPontosSet5Parti2(Integer.parseInt(data[12]));
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				tmpPartida.calculaSets();
				tmpPartida.calculaVencedor();
				
				try{ 
					tmpPartida.setData(ft.parse(data[13])); 
				} catch(ParseException e){ 
					System.err.println("Erro ao analisar data usando " + ft); 
					System.exit(1);
				}
				
				partidas.add(tmpPartida);
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return partidas;
	}


	private HashSet<PartidaFutebol> buscaPartidasFutebol() {
		//URL url = getClass().getResource("partidas_futebol.csv");
		File file = new File("resources" + File.separator + "partidas_futebol.csv");
		Scanner sc;
		
		HashSet<PartidaFutebol> partidas = new HashSet<PartidaFutebol>(); 
		try {
			sc = new Scanner(file);
			
			while(sc.hasNext()) {
				PartidaFutebol tmpPartida = new PartidaFutebol();
				
				String line = sc.nextLine();
				String[] data= line.split(",");
				
				tmpPartida.setParticipante1(this.getSelecaoPorID(Integer.parseInt(data[0])));
				tmpPartida.setParticipante2(this.getSelecaoPorID(Integer.parseInt(data[1])));
				tmpPartida.setDescricao(data[2]);
				tmpPartida.setPlacarParticipante1(Integer.parseInt(data[3]));
				tmpPartida.setPlacarParticipante2(Integer.parseInt(data[4]));
				tmpPartida.calculaVencedor();
				
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				try{ 
					tmpPartida.setData(ft.parse(data[5])); 
				} catch(ParseException e){ 
					System.err.println("Erro ao analisar data usando " + ft); 
					System.exit(1);
				}
				
				partidas.add(tmpPartida);
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return partidas;
	}


	private Esporte buscaEsportePorID(int ID) {
		//URL urlEsportes = getClass().getResource("esportes.csv");
		File fileEsportes = new File("resources" + File.separator + "esportes.csv");
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
	
	
	private HashSet<Atleta> buscaAtletasPorSelecao(int ID){
		//URL url = getClass().getResource("atletas.csv"); 
		File file = new File("resources" + File.separator + "atletas.csv"); 
		Scanner sc;
		HashSet<Atleta> atletas = new HashSet<Atleta>();
	
		try {
			sc = new Scanner(file);
			while(sc.hasNext()) {
				
				String line = sc.nextLine(); 
				String[] data = line.split(","); 
				if(data[6].equals(String.valueOf(ID))){
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
					tmpAtleta.setAltura(Integer.parseInt(data[3]));
					tmpAtleta.setNacionalidade(data[4]);
					tmpAtleta.setPosicao(data[5]);
					atletas.add(tmpAtleta);
				}
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		
		
		return atletas;
	}
	
	
	public Selecao getSelecaoPorID(int ID) {
		for(Selecao selecao : this.selecoes) {
			if(selecao.getID() == ID) {
				return selecao;
			}
		}
		return null;
	}
	
	public HashSet<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(HashSet<Selecao> selecoes) {
		this.selecoes = selecoes;
	}
	
	public Selecao[] getSelecoesPorEsporte(int ID){
		HashSet<Selecao> selecoesEsporte = new HashSet<Selecao>();
		for(Selecao selecao : this.selecoes) {
			if(selecao.getEsporte().getID() == ID) {
				selecoesEsporte.add(selecao);
			}
		}
		return selecoesEsporte.toArray(Selecao[]::new);
	}
	
	public Esporte[] getEsportes() {
		//URL urlEsportes = getClass().getResource("esportes.csv");
		File fileEsportes = new File("resources" + File.separator + "esportes.csv");
		Scanner sc;
		HashSet<Esporte> esportes = new HashSet<Esporte>();
		try {
			sc = new Scanner(fileEsportes);
			
			while(sc.hasNext()) {
				String line= sc.nextLine();
				String[] data = line.split(",");
				Esporte tmpEsporte = null;
				
				if(data[1].equals("Volei")) {
					tmpEsporte = new Volei();
				}
				else if(data[1].equals("Basquete")) {
					tmpEsporte = new Basquete();
				}
				else if(data[1].equals("Futebol")){
					tmpEsporte = new Futebol();
				}
				
				tmpEsporte.setID(Integer.parseInt(data[0]));
				tmpEsporte.setNome(data[1]);
				tmpEsporte.setGenero(data[2]);

				esportes.add(tmpEsporte);
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return esportes.stream().sorted((e1, e2) -> e1.toString().compareTo(e2.toString())).toArray(Esporte[]::new);
	}
	
	public static BancoSelecao getInstance() {
		if (bancoSelecao == null) {
			try {
				bancoSelecao = new BancoSelecao();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return bancoSelecao;
	}
	
	public ArrayList<PartidaFutebol> getPartidasFutebol(){
		return new ArrayList<>(partidasFutebol);
	}
	
	public ArrayList<PartidaBasquete> getPartidasBasquete(){
		return new ArrayList<>(partidasBasquete);
	}
	
	public ArrayList<PartidaVolei> getPartidasVolei(){
		return new ArrayList<>(partidasVolei);
	}
	
	public HashSet<PartidaFutebol> getPartidasFutebolPorSelecao(String pais){
		HashSet<PartidaFutebol> partidas = new HashSet<PartidaFutebol>();
		for(Selecao s : selecoes) {
			if(s.getPais().equalsIgnoreCase(pais)) {
				if(s.getEsporte() instanceof Futebol) {
					((Futebol)s.getEsporte()).getPartidas();
				}
			}
		}
		return partidas;
	}
	
	public HashSet<PartidaBasquete> getPartidasBasquetePorSelecao(String pais){
		HashSet<PartidaBasquete> partidas = new HashSet<PartidaBasquete>();
		for(Selecao s : selecoes) {
			if(s.getPais().equalsIgnoreCase(pais)) {
				if(s.getEsporte() instanceof Basquete) {
					((Basquete)s.getEsporte()).getPartidas();
				}
			}
		}
		return partidas;
	}
	
	public HashSet<PartidaVolei> getPartidasVoleiPorSelecao(String pais){
		HashSet<PartidaVolei> partidas = new HashSet<PartidaVolei>();
		for(Selecao s : selecoes) {
			if(s.getPais().equalsIgnoreCase(pais)) {
				if(s.getEsporte() instanceof Volei) {
					((Volei)s.getEsporte()).getPartidas();
				}
			}
		}
		return partidas;
	}
	
	public ArrayList<Atleta>  getAtletas(String nome) {
		ArrayList<Atleta> atls = new ArrayList<Atleta>();
		for(Selecao s : selecoes) {
			for(Atleta a : s.getTime()) {
				if(a.getNome().toLowerCase().contains(nome.toLowerCase())) {
					atls.add(a);
				}
			}
		}

		return atls;
	}

	public void salvarPartidaFutebol(PartidaFutebol partida) throws IOException{
		String linha = String.valueOf(partida.getParticipante1().getID()) + "," + 
				String.valueOf(partida.getParticipante2().getID()) + "," +
				partida.getDescricao() + "," +
				String.valueOf(partida.getPlacarParticipante1()) + "," +
				String.valueOf(partida.getPlacarParticipante2()) + "," + 
				String.format("%td/%<tm/%<tY %<tH:%<tM", partida.getData());
		
		
	    FileWriter fw = new FileWriter("resources" + File.separator + "partidas_futebol.csv", true); 
	    fw.write(System.getProperty("line.separator") + linha);
	    fw.close();	
	    partidasFutebol.add(partida);
	}
	
	public void salvarPartidaBasquete(PartidaBasquete partida) throws IOException{
		String linha = String.valueOf(partida.getParticipante1().getID()) + "," + 
				String.valueOf(partida.getParticipante2().getID()) + "," +
				partida.getDescricao() + "," +
				String.valueOf(partida.getPontuacaoParticipante1()) + "," +
				String.valueOf(partida.getPontuacaoParticipante2()) + "," + 
				String.format("%td/%<tm/%<tY %<tH:%<tM", partida.getData());
		
		
	    FileWriter fw = new FileWriter("resources" + File.separator + "partidas_basquete.csv", true); 
	    fw.write(System.getProperty("line.separator") + linha);
	    fw.close();	
	    partidasBasquete.add(partida);
	}
	
	public void salvarPartidaVolei(PartidaVolei partida) throws IOException{
		String linha = String.valueOf(partida.getParticipante1().getID()) + "," + 
				String.valueOf(partida.getParticipante2().getID()) + "," +
				partida.getDescricao() + "," +
				String.valueOf(partida.getPontosSet1Parti1()) + "," +
				String.valueOf(partida.getPontosSet1Parti2()) + "," + 
				String.valueOf(partida.getPontosSet2Parti1()) + "," +
				String.valueOf(partida.getPontosSet2Parti2()) + "," + 
				String.valueOf(partida.getPontosSet3Parti1()) + "," +
				String.valueOf(partida.getPontosSet3Parti2()) + "," +
				String.valueOf(partida.getPontosSet4Parti1()) + "," +
				String.valueOf(partida.getPontosSet4Parti2()) + "," +
				String.valueOf(partida.getPontosSet5Parti1()) + "," +
				String.valueOf(partida.getPontosSet5Parti2()) + "," + 
				String.format("%td/%<tm/%<tY %<tH:%<tM", partida.getData());
		
		
	    FileWriter fw = new FileWriter("resources" + File.separator + "partidas_volei.csv", true); 
	    fw.write(System.getProperty("line.separator") + linha);
	    fw.close();	
	    partidasVolei.add(partida);
	}
		
}
