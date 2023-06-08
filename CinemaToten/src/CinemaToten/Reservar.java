package CinemaToten;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Reservar implements I_Arquivo {
	private final String NOME_ARQUIVO;
	
	public Reservar(String NOME_ARQUIVO) {
		this.NOME_ARQUIVO = NOME_ARQUIVO;
	}
	
	public boolean reservarAssento(String posAssento, Sessao sessao) { //true se disponivel
		//verificar se um assento esta ocupado quando for selecionado no mapa de assentos
		
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	public boolean comprarAssento(String posAssento, Sessao sessao) { //true se comprado
		//verificar se um assento esta ocupado quando o usuario for comprar
		//throws exception se tiver acabado de ser comprado por alguem!
		//gravar no arquivo se estiver disponivel
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public boolean gravarArquivo(String conteudo) throws IOException {
		try {
            FileWriter escritor = new FileWriter(NOME_ARQUIVO, true);
            escritor.write(conteudo + "\n");
            escritor.close();
            return true;
        } catch (IOException e) {
        	e.printStackTrace();
        	return false;
        }
	}

	@Override
	public String lerArquivo() throws IOException {
		try {
			return new String(Files.readAllBytes(Paths.get(NOME_ARQUIVO)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}





