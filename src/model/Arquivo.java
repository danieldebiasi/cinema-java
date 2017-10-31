/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe contém os métodos para manipulação dos arquivos utilizados no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
abstract class Arquivo {
    
    /**
     * Este método é responsável por garantir que haja valores únicos nos arquivos,
     * simulando chaves primárias.
     * @param arquivo
     * @return incremento
     */
    public static int incremento(String arquivo){
        int incremento = 1;
        Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
        
        if(Files.exists(arquivoPath)){
            try {
                FileReader file = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(file);

                try {
                    reader.readLine();
                    String line = reader.readLine();
                    while(line != null){
                        String[] split = line.split(";");
                        incremento = Integer.parseInt(split[0])+1;
                        line = reader.readLine();
                    }

                    file.close();
                    reader.close();

                } catch (IOException ex) {
                    Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return incremento;
    }    
}
