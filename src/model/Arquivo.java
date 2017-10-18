/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.File;
import java.util.Scanner;

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
    public int incremento(String arquivo){
        int incremento = 1;
               
        File file = new File(arquivo);
        
        Scanner scanner = new Scanner(arquivo);
        String rset = null;

        scanner.nextLine();

        while(scanner.hasNext()){
            incremento++;
        }
        
        return incremento;
    }    
}
