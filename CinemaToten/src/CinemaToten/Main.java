package CinemaToten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void createCSVFile() {

		String fileName = "AssentosReservados.csv";

		//Cria objeto do tipo file chamado "AssentosReservados.csv"
		File file = new File(fileName);

		// Verifica se o arquivo já existe
		if (!file.exists()) {
			try {
				// Cria o arquivo se ele não existir
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Filme> criarCatalogo(String nomeArquivo) {
        ArrayList<Filme> listaFilmes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {  // Ignora o cabeçalho do arquivo CSV
                    primeiraLinha = false;
                    continue;
                }

                String[] campos = linha.split(";");

                String tituloAspas = campos[0].trim();
                String titulo = tituloAspas.replace("\"", "");
                String sinopse = campos[1].trim();
                String duracao = campos[2].trim();
                String caminhoPoster = campos[3].trim();
                String textoSemAspas = caminhoPoster.replace("\"", "");

                Filme filme = new Filme(titulo, sinopse, duracao, textoSemAspas);
                listaFilmes.add(filme);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return listaFilmes;
    }

	public static ArrayList<Sessao> criarSessoes(ArrayList<Filme> listaFilmes) {
		ArrayList<String> listaDatas = new ArrayList<>();
		ArrayList<String> listaHorarios = new ArrayList<>();
		//Cria uma lista com as datas em que os filmes serão exibidos
		listaDatas.add("28/06");
		listaDatas.add("29/06");
		listaDatas.add("30/06");
		//Cria uma lista com os horarios que os filmes serao exibidos
		listaHorarios.add("14h");
		listaHorarios.add("16h");
		listaHorarios.add("18h");
		//Para cada data da listaDatas é criado uma sessao em cada um dos horarios
		ArrayList<Sessao> listaSessoes = new ArrayList<>();
		for (int i=0; i< listaFilmes.size(); i++) {
			for (int j=0; j < listaDatas.size(); j++) {
				for (int k=0; k < listaHorarios.size(); k++) {
					Sessao sessao = new Sessao(listaFilmes.get(i), 6,5, listaHorarios.get(k), listaDatas.get(j));
					listaSessoes.add(sessao);
				}
			}
		}
		return listaSessoes;

	}
	
	public static void main(String[] args){
		//criacao do arquivo que guarda a disponibilidade dos assentos
		createCSVFile();
		// Instancia lista de filmes
		ArrayList<Filme> listaFilmes = new ArrayList<>();
		String caminhoArquivo = "ListaFilmes.csv";
		listaFilmes = criarCatalogo(caminhoArquivo);
		//criacao das sessoes
		ArrayList<Sessao> listaSessoes = new ArrayList<>();
		listaSessoes = criarSessoes(listaFilmes);
		new Entrada(listaSessoes);

	}


}


