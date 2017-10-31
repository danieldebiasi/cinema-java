/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
        FileReader file;
        
        if(Files.exists(arquivoPath)){
            try {
                file = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(file);

                try {
                    reader.readLine();
                    String rset = reader.readLine();

                    while(rset != null){
                        String[] split = rset.split(";");

                        if(split[0].equals(rg)){                    
                            gestor = new Gestor(split[0], split[1], split[2], split[3],
                                              split[4], split[5], split[6], split[7]);

                            break;
                        }

                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return gestor;
    }
    
    /**
     * Este método é responsável por buscar todos os gestores do arquivo de gestores.
     * @return filmes
     */
    public List<Gestor> getAll(){
        List<Gestor> gestores = new ArrayList<>();
        Gestor gestor = null;
        FileReader file;
        
        if(Files.exists(arquivoPath)){
            try {
                file = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(file);

                try {
                    reader.readLine();
                    String rset = reader.readLine();

                    while(rset != null){
                        String[] split = rset.split(";");

                        gestor = new Gestor(split[0], split[1], split[2], split[3],
                                          split[4], split[5], split[6], split[7]);

                        gestores.add(gestor);
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        
        return gestores;
    }
    
    /**
     * Este método é responsável por alterar o registro de um determinado gestor.
     * @param gestor 
     */
    public void alterar(Gestor gestor){
        String completo = "";
        String elemento = "";
        FileReader file;        
        
        try {
            file = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(file);
            
            try {
                completo = reader.readLine()+"\n";
                String rset = reader.readLine();
                
                while(rset != null){
                    String[] split = rset.split(";");
                    
                    if(split[0].equals(gestor.getRg())){                    
                        elemento = gestor.getRg().concat(";");
                        elemento += gestor.getNome().concat(";");
                        elemento += gestor.getCpf().concat(";");
                        elemento += gestor.getEndereco().concat(";");
                        elemento += gestor.getTelefone().concat(";");
                        elemento += gestor.getDataNasc().concat(";");
                        elemento += gestor.getSalario().concat(";");
                        elemento += gestor.getNumContrato();
                        
                        completo += elemento+"\n";
                    }else{
                        completo += rset+"\n";
                    }
                    
                    rset = reader.readLine();
                }
                
                try {
                    FileWriter fwriter = new FileWriter(arquivo);
                    try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                        String[] all = completo.split("\n");
                        
                        for(int i = 0; i < all.length; i++){
                            writer.write(all[i]);

                            writer.newLine();
                        }

                        writer.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * Este método é responsável por excluir o registro de um gestor.
     * @param gestor 
     */
    public void excluir(Gestor gestor){
        String completo = "";
        String elemento = "";
        FileReader file;        
        
        try {
            file = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(file);
            
            try {
                completo = reader.readLine()+"\n";
                String rset = reader.readLine();
                
                while(rset != null){
                    String[] split = rset.split(";");
                    
                    if(!(split[0].equals(gestor.getRg()))){
                        completo += rset+"\n";
                    }
                    
                    rset = reader.readLine();
                }
                
                try {
                    FileWriter fwriter = new FileWriter(arquivo);
                    try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                        String[] all = completo.split("\n");
                        
                        for(int i = 0; i < all.length; i++){
                            writer.write(all[i]);

                            writer.newLine();
                        }

                        writer.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
