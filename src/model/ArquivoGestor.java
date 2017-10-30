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
 * Esta classe contém os métodos para manipulação do arquivo de gestores.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ArquivoGestor extends Arquivo {

    private final String arquivo = "gestores.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoGestor(){
    }
    
    /**
     * Este método é responsável pela geração do arquivo CSV de gestores.
     */
    public void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("rg");
                writer.write(";");
                writer.write("nome");
                writer.write(";");
                writer.write("cpf");
                writer.write(";");
                writer.write("endereco");
                writer.write(";");
                writer.write("telefone");
                writer.write(";");
                writer.write("dataNasc");
                writer.write(";");
                writer.write("salario");
                writer.write(";");
                writer.write("numContrato");
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável pela inserção de novos gestores no arquivo de gestores.
     * @param gestor 
     * @throws GestorDuplicadoException 
     */
    public void inserir(Gestor gestor) throws GestorDuplicadoException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        
        //Verificação de duplicidade - a ser implementada
        
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(gestor.getRg());
                writer.write(";");
                writer.write(gestor.getNome());
                writer.write(";");
                writer.write(gestor.getCpf());
                writer.write(";");
                writer.write(gestor.getEndereco());
                writer.write(";");
                writer.write(gestor.getTelefone());
                writer.write(";");
                writer.write(gestor.getDataNasc());
                writer.write(";");
                writer.write(gestor.getSalario());
                writer.write(";");
                writer.write(gestor.getNumContrato());
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável por buscar no arquivo de gestores a existência de
     * um gestor dado seu RG.
     * @param rg
     * @return gestor
     */
    public Gestor buscar(String rg){
        Gestor gestor = null;
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            
            scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(rg)){
                    gestor = new Gestor(split[0], split[1], split[2], split[3], 
                            split[4], split[5], split[6], split[7]);
                    
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return gestor;
    }
    
    /**
     * Este método é responsável por alterar o registro de um determinado gestor.
     * @param gestor 
     */
    public void alterar(Gestor gestor){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(gestor.getRg())){
                    rset = gestor.getRg().concat(";");
                    rset += gestor.getNome().concat(";");
                    rset += gestor.getCpf().concat(";");
                    rset += gestor.getEndereco().concat(";");
                    rset += gestor.getTelefone().concat(";");
                    rset += gestor.getDataNasc().concat(";");
                    rset += gestor.getSalario().concat(";");
                    rset += gestor.getNumContrato().concat(";");
                   
                    fset += rset;
                    
                    try {
                        FileWriter fwriter = new FileWriter(arquivo);
                        try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                            writer.write(fset);

                            writer.newLine();
                            writer.close();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
            
        } catch (NumberFormatException e) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Este método é responsável por excluir o registro de um funcionário.
     * @param rg 
     */
    public void excluir(String rg){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(!(split[0]).equals(rg)){
                    rset = split[0].concat(";");
                    rset += split[1].concat(";");
                    rset += split[2].concat(";");
                    rset += split[3].concat(";");
                    rset += split[4].concat(";");
                    rset += split[5].concat(";");
                    rset += split[6].concat(";");
                    rset += split[7];
                    
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
                Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
