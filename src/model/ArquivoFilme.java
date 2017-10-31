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
 * Esta classe contém os métodos para manipulação do arquivo de filmes.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public final class ArquivoFilme extends Arquivo {
    
    private final String arquivo = "filmes.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoFilme(){
    }
    
    /**
     * Este método é responsável pela geração do arquivo CSV de filmes.
     */
    private void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("codFilme");
                writer.write(";");
                writer.write("titulo");
                writer.write(";");
                writer.write("genero");
                writer.write(";");
                writer.write("sinopse");
                writer.write(";");
                writer.write("diretor");
                writer.write(";");
                writer.write("ano");
                writer.write(";");
                writer.write("clasIndicativa");
                writer.write(";");
                writer.write("duracao");
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável pela inserção de novos filmes no arquivo de filmes.
     * @param filme 
     * @throws FilmeDuplicadoException 
     */
    public void inserir(Filme filme) throws FilmeDuplicadoException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        
        //Verificação de duplicidade - a ser implementada
        
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(Integer.toString(this.incremento(arquivo)));
                writer.write(";");
                writer.write(filme.getTitulo());
                writer.write(";");
                writer.write(filme.getGenero());
                writer.write(";");
                writer.write(filme.getSinopse());
                writer.write(";");
                writer.write(filme.getDiretor());
                writer.write(";");
                writer.write(Integer.toString(filme.getAno()));
                writer.write(";");
                writer.write(filme.getClasIndicativa());
                writer.write(";");
                writer.write(Integer.toString(filme.getDuracao()));
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /**
     * Este método é responsável por buscar no arquivo de filmes a existência
     * de um filme dado seu código.
     * @param codFilme
     * @return filme
     */
    public Filme buscar(int codFilme){
        
        Filme filme = null;
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

                        if(Integer.parseInt(split[0]) == codFilme){                    
                            filme = new Filme(Integer.parseInt(split[0]), split[1], split[2], split[3],
                                        split[4], Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]));

                            break;
                        }

                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
        
        return filme;
        
    }
    
    /**
     * Este método é responsável por buscar todos os filmes do arquivo de filmes.
     * @return filmes
     */
    public List<Filme> getAll(){
        List<Filme> filmes = new ArrayList<>();
        Filme filme = null;
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

                        filme = new Filme(Integer.parseInt(split[0]), split[1], split[2], split[3],
                                    split[4], Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]));

                        filmes.add(filme);
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return filmes;
    }
    
    /**
     * Este método é responsável por alterar o registro de um determinado filme.
     * @param filme 
     */
    public void alterar(Filme filme){
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
                    
                    if(Integer.parseInt(split[0]) == filme.getCodFilme()){                    
                        elemento = Integer.toString(filme.getCodFilme()).concat(";");
                        elemento += filme.getTitulo().concat(";");
                        elemento += filme.getGenero().concat(";");
                        elemento += filme.getSinopse().concat(";");
                        elemento += filme.getDiretor().concat(";");
                        elemento += Integer.toString(filme.getAno()).concat(";");
                        elemento += filme.getClasIndicativa().concat(";");
                        elemento += Integer.toString(filme.getDuracao());
                        
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
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    /**
     * Este método é responsável por excluir o registro de um filme.
     * @param filme 
     */
    public void excluir(Filme filme){
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
                    
                    if(!(Integer.parseInt(split[0]) == filme.getCodFilme())){
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
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
