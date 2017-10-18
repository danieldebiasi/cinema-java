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
                writer.write(Integer.toString(filme.getClasIndicativa()));
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
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            
            scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(Integer.parseInt(split[0]) == codFilme){
                    filme = new Filme(Integer.parseInt(split[0]), split[1], split[2], 
                            split[3], split[4], Integer.parseInt(split[5]),
                            Integer.parseInt(split[6]), Integer.parseInt(split[7]));
                    
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filme;
    }
    
    /**
     * Este método é responsável por alterar o registro de um determinado filme.
     * @param filme 
     */
    public void alterar(Filme filme){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(Integer.parseInt(split[0]) == filme.getCodFilme()){
                    rset = Integer.toString(filme.getCodFilme()).concat(";");
                    rset += filme.getTitulo().concat(";");
                    rset += filme.getGenero().concat(";");
                    rset += filme.getSinopse().concat(";");
                    rset += filme.getDiretor().concat(";");
                    rset += Integer.toString(filme.getAno()).concat(";");
                    rset += Integer.toString(filme.getClasIndicativa()).concat(";");
                    rset += Integer.toString(filme.getDuracao());
                }
                
                fset += rset+"\n";
            }
                    
            try {
                FileWriter fwriter = new FileWriter(arquivo);
                try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                    writer.write(fset);

                    writer.newLine();
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }     
        } catch (NumberFormatException e) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Este método é responsável por excluir o registro de um filme.
     * @param codFilme 
     */
    public void excluir(int codFilme){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(!(Integer.parseInt(split[0]) == codFilme)){
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
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
