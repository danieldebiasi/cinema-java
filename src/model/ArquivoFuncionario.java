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
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            
            scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(rg)){
                    funcionario = new Funcionario(split[0], split[1], split[2], split[3], 
                            split[4], split[5], split[6], split[7], split[8], split[9]);
                    
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionario;
    }
    
    /**
     * Este método é responsável por alterar o registro de um determinado funcionário.
     * @param funcionario 
     */
    public void alterar(Funcionario funcionario){
        File file = new File(arquivo);
        
        try {
            Scanner scanner = new Scanner(arquivo);
            String rset = null;
            String fset = "";
            
            fset += scanner.nextLine();
            
            while(scanner.hasNext()){
                rset = scanner.nextLine();
                String[] split = rset.split(";");
                
                if(split[0].equals(funcionario.getRg())){
                    rset = funcionario.getRg().concat(";");
                    rset += funcionario.getNome().concat(";");
                    rset += funcionario.getCpf().concat(";");
                    rset += funcionario.getEndereco().concat(";");
                    rset += funcionario.getTelefone().concat(";");
                    rset += funcionario.getDataNasc().concat(";");
                    rset += funcionario.getSalario().concat(";");
                    rset += funcionario.getCarteiraDeTrabalho().concat(";");
                    rset += funcionario.getHoraEntrada().concat(";");
                    rset += funcionario.getHoraSaida();
                    
                    fset += rset;
                    
                    try {
                        FileWriter fwriter = new FileWriter(arquivo);
                        try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                            writer.write(fset);

                            writer.newLine();
                            writer.close();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
            
        } catch (NumberFormatException e) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, e);
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
                    rset += split[7].concat(";");
                    rset += split[8].concat(";");
                    rset += split[9];
                    
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
                Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ArquivoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
