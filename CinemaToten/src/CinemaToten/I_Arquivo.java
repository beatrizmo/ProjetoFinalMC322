package CinemaToten;

import java.io.IOException;

//Interface que define os métodos para gravar e ler arquivos
public interface I_Arquivo {
    boolean gravarArquivo(String conteudo) throws IOException;
    String lerArquivo() throws IOException;
}

