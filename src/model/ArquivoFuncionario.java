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
 * Esta classe contém os métodos para manipulação do arquivo de funcionários.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ArquivoFuncionario extends Arquivo {
    
    private final String arquivo = "funcionarios.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoFuncionario(){
    }
    
    /**
     * Este método é responsável pela geração do arquivo CSV de funcionários.
     */
    public void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("rg");
                writer.write(",");
                writer.write("nome");
                writer.write(",");
                writer.write("cpf");
                writer.write(",");
                writer.write("endereco");
                writer.write(",");
                writer.write("telefone");
                writer.write(",");
                writer.write("dataNasc");
                writer.write(",");
                writer.write("salario");
                writer.write(",");
                writer.write("carteiraDeTrabalho");
                writer.write(",");
                writer.write("horaEntrada");
                writer.write(",");
                writer.write("horaSaida");
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável pela inserção de novos funcionários no arquivo
     * de funcionários.
     * @param funcionario 
     * @throws FuncionarioDuplicadoException 
     */
    public void inserir(Funcionario funcionario) throws FuncionarioDuplicadoException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        
        //Verificação de duplicidade - a ser implementada
        
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(funcionario.getRg());
                writer.write(";");
                writer.write(funcionario.getNome());
                writer.write(";");
                writer.write(funcionario.getCpf());
                writer.write(";");
                writer.write(funcionario.getEndereco());
                writer.write(";");
                writer.write(funcionario.getTelefone());
                writer.write(";");
                writer.write(funcionario.getDataNasc());
                writer.write(";");
                writer.write(funcionario.getSalario());
                writer.write(";");
                writer.write(funcionario.getCarteiraDeTrabalho());
                writer.write(";");
                writer.write(funcionario.getHoraEntrada());
                writer.write(";");
                writer.write(funcionario.getHoraSaida());
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método é responsável por buscar no arquivo de funcionários a existência
     * de um funcionário dado seu RG.
     * @param rg
     * @return funcionario
     */
    public Funcionario buscar(String rg){
        Funcionario funcionario = null;
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
                            funcionario = new Funcionario(split[0], split[1], split[2], split[3],
                                              split[4], split[5], split[6], split[7], split[8], split[9]);

                            break;
                        }

                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return funcionario;
    }
    
    /**
     * Este método é responsável por buscar todos os funcionários do arquivo de funcionários.
     * @return filmes
     */
    public List<Funcionario> getAll(){
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;
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

                        funcionario = new Funcionario(split[0], split[1], split[2], split[3],
                                          split[4], split[5], split[6], split[7], split[8], split[9]);

                        funcionarios.add(funcionario);
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        
        return funcionarios;
    }
    
    /**
     * Este método é responsável por alterar o registro de um determinado funcionário.
     * @param funcionario 
     */
    public void alterar(Funcionario funcionario){
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
                    
                    if(split[0].equals(funcionario.getRg())){                    
                        elemento = funcionario.getRg().concat(";");
                        elemento += funcionario.getNome().concat(";");
                        elemento += funcionario.getCpf().concat(";");
                        elemento += funcionario.getEndereco().concat(";");
                        elemento += funcionario.getTelefone().concat(";");
                        elemento += funcionario.getDataNasc().concat(";");
                        elemento += funcionario.getSalario().concat(";");
                        elemento += funcionario.getCarteiraDeTrabalho().concat(";");
                        elemento += funcionario.getHoraEntrada().concat(";");
                        elemento += funcionario.getHoraSaida();
                        
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
                    Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    /**
     * Este método é responsável por excluir o registro de um funcionário.
     * @param rg 
     */
    public void excluir(Funcionario funcionario){
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
                    
                    if(!(split[0].equals(funcionario.getRg()))){
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
                    Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
