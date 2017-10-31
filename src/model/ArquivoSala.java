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
 * Esta classe contém os métodos para manipulação do arquivo de salas.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ArquivoSala extends Arquivo {
    
    public static final String arquivo = "salas.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoSala(){
    }
    
    /**
     * Este método é responsável pela geração do arquivo CSV de salas.
     */
    public void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("numSala");
                writer.write(";");
                writer.write("status");
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável pela inserção de novas salas no arquivo de salas.
     * @param sala 
     * @throws SalaDuplicadaException 
     */
    public void inserir(Sala sala) throws SalaDuplicadaException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        
        //Verificação de duplicidade - a ser implementada
        
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(Integer.toString(sala.getNumSala()));
                writer.write(";");
                writer.write(sala.getStatus());
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável por buscar no arquivo de salas a existência de 
     * uma sala dado seu número.
     * @param numSala
     * @return sala
     */
    public Sala buscar(int numSala){
        Sala sala = null;
        FileReader file;
        
        try {
            file = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(file);
            
            try {
                reader.readLine();
                String rset = reader.readLine();
                
                while(rset != null){
                    String[] split = rset.split(";");
                    
                    if(Integer.parseInt(split[0]) == numSala){                    
                        sala = new Sala(Integer.parseInt(split[0]), split[1]);
                    
                        break;
                    }
                    
                    rset = reader.readLine();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        return sala;
    }
    
    public List<Sala> getAll(){
        List<Sala> salas = new ArrayList<>();
        Sala sala = null;
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

                        sala = new Sala(Integer.parseInt(split[0]), split[1]);

                        salas.add(sala);
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
        
        return salas;
    }
    
    /**
     * Este método é responsável por alterar o registro de uma determinada sala.
     * @param sala 
     */
    public void alterar(Sala sala){
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
                    
                    if(Integer.parseInt(split[0]) == sala.getNumSala()){                    
                        elemento = Integer.toString(sala.getNumSala()).concat(";");
                        elemento += sala.getStatus().concat(";");
                        
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
                    Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * Este método é responsável por excluir o registro de uma sala.
     * @param sala 
     */
    public void excluir(Sala sala){
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
                    
                    if(!(Integer.parseInt(split[0]) == sala.getNumSala())){
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
                    Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
