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
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(sala.getNumSala())){
                    rset = Integer.toString(sala.getNumSala()).concat(";");
                    rset += sala.getStatus();
                   
                    fset += rset;
                    
                    try {
                        FileWriter fwriter = new FileWriter(arquivo);
                        try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                            writer.write(fset);

                            writer.newLine();
                            writer.close();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
            
        } catch (NumberFormatException e) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Este método é responsável por excluir o registro de uma sala.
     * @param numSala 
     */
    public void excluir(int numSala){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(!(Integer.parseInt(split[0]) == numSala)){
                    rset = split[0].concat(";");
                    rset += split[1];
                    
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
                Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
