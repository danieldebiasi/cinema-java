/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe contém os métodos para manipulação do arquivo de sessões.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ArquivoSessao extends Arquivo {
    
    private final String arquivo = "sessoes.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoSessao(){
    }
    
    /**
     * Este método é responsável pela geração do arquivo CSV das sessões.
     */
    public void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("codSessao");
                writer.write(";");
                writer.write("codFilme");
                writer.write(";");
                writer.write("numSala");
                writer.write(";");
                writer.write("hora");
                writer.write(";");
                writer.write("minuto");
                writer.write(";");
                for(int i = 0; i < 50; i++){
                    writer.write("poltrona"+Integer.toString(i+1));
                    if(i != 49) writer.write(";");
                }
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável pela inserção de novas sessões no arquivo de sessões.
     * @param sessao 
     * @throws SessaoDuplicadaException 
     */
    public void inserir(Sessao sessao) throws SessaoDuplicadaException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        
        //Verificação de duplicidade - a ser implementada
        
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(Integer.toString(sessao.getCodSessao()));
                writer.write(";");
                writer.write(Integer.toString(sessao.getFilme().getCodFilme()));
                writer.write(";");
                writer.write(Integer.toString(sessao.getSala().getNumSala()));
                writer.write(";");
                writer.write(Integer.toString(sessao.getHora()));
                writer.write(";");
                writer.write(Integer.toString(sessao.getMinuto()));
                writer.write(";");
                for(int i = 0; i < 50; i++){
                    writer.write(Integer.toString(sessao.getPoltronas()[i]));
                    if(i != 49) writer.write(";");
                }
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável por buscar no arquivo de sessões a existência de uma
     * sessão dado seu código.
     * @param codSessao
     * @return sessao
     */
    public Sessao buscar(int codSessao){
        Sessao sessao = null;
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            
            scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(codSessao)){
                    ArquivoFilme arqfilme = new ArquivoFilme();
                    ArquivoSala arqsala = new ArquivoSala();
                    
                    Filme filme = arqfilme.buscar(Integer.parseInt(split[1]));
                    Sala sala = arqsala.buscar(Integer.parseInt(split[2]));
                    
                    int[] poltronas = new int[50];
                    for(int i = 0; i < 50; i++){
                        poltronas[i] = Integer.parseInt(split[i+5]);
                    }
                    
                    sessao = new Sessao(Integer.parseInt(split[0]), filme, sala, 
                            Integer.parseInt(split[3]), Integer.parseInt(split[4]), poltronas);
                    
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sessao;
    }
    
    /**
     * Este método é responsável por alterar o registro de uma sessão.
     * @param sessao 
     */
    public void alterar(Sessao sessao){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(sessao.getCodSessao())){
                    rset = Integer.toString(sessao.getCodSessao()).concat(";");
                    rset += Integer.toString(sessao.getFilme().getCodFilme()).concat(";");
                    rset += Integer.toString(sessao.getSala().getNumSala()).concat(";");
                    rset += Integer.toString(sessao.getHora()).concat(";");
                    rset += Integer.toString(sessao.getMinuto()).concat(";");
                    for(int i = 0; i < 50; i++){
                        rset += Integer.toString(sessao.getPoltronas()[i]);
                        if(i != 49) rset+=";";
                    }
                   
                    fset += rset;
                    
                    try {
                        FileWriter fwriter = new FileWriter(arquivo);
                        try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                            writer.write(fset);

                            writer.newLine();
                            writer.close();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
            
        } catch (NumberFormatException e) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Este método é responsável por excluir o registro de uma sessão.
     * @param codSessao 
     */
    public void excluir(int codSessao){
        File file = new File(arquivo);

        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";

            fset += scanner.nextLine();

            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");

                if(!(Integer.parseInt(split[0]) == codSessao)){
                    rset = split[0].concat(";");
                    rset += split[1].concat(";");
                    rset += split[2].concat(";");
                    rset += split[3].concat(";");
                    rset += split[4].concat(";");
                    for(int i = 0; i < 50; i++){
                        rset += split[i+5];
                        if(i != 49) rset += (";");
                    }

                    fset += rset+"\n";
                }
            }

            try {
                FileWriter fwriter = new FileWriter(arquivo);
                try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                    writer.write(fset);

                    writer.newLine();
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

       
