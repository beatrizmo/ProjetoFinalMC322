package CinemaToten;

import java.io.IOException;

public interface I_Arquivo {
    boolean gravarArquivo(String conteudo) throws IOException;
    String lerArquivo() throws IOException;
}

