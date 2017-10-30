/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.CpfException;
import model.Funcionario;
import model.Gestor;

/**
 * Esta classe é responsável pelo controle de operações relacionadas a pessoas.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ControlePessoa {

    /**
     * Este método é responsável por obter e verificar os dados da interface e 
     * realizar a requisição de inserção no arquivo.
     * @param nome
     * @param rg
     * @param cpf
     * @param endereco
     * @param telefone
     * @param dataNasc
     * @param salario
     * @param entrada
     * @param saida
     * @param carteira
     * @param sinopse
     * @return String
     */
    public static String tryCadastroFuncionario(String nome, String rg, String cpf, String endereco, 
                                                String telefone, String dataNasc, String salario, 
                                                String entrada, String saida, String carteira){
        
        if(nome.equals("") || rg.equals("") || cpf.equals("") || endereco.equals("") ||
           telefone.equals("") || dataNasc.equals("") || salario.equals("") || 
           entrada.equals("") || saida.equals("") || carteira.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Funcionario funcionario = new Funcionario(nome, rg, cpf, endereco, telefone, dataNasc,
                                                      salario, entrada, saida, carteira);
            Cadastro cadastro = new Cadastro();
            
            try {
                return cadastro.cadastrar(funcionario);
            } catch (CpfException ex) {
                Logger.getLogger(ControlePessoa.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        }
    }
    
    /**
     * Este método é responsável por obter e verificar os dados da interface e 
     * realizar a requisição de inserção no arquivo.
     * @param nome
     * @param rg
     * @param cpf
     * @param endereco
     * @param telefone
     * @param dataNasc
     * @param salario
     * @param contrato
     * @return String
     */
    public static String tryCadastroGestor(String nome, String rg, String cpf, String endereco, 
                                                String telefone, String dataNasc, String salario, 
                                                String contrato){
        if(nome.equals("") || rg.equals("") || cpf.equals("") || endereco.equals("") ||
           telefone.equals("") || dataNasc.equals("") || salario.equals("") || 
           contrato.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Gestor gestor = new Gestor(nome, rg, cpf, endereco, telefone, dataNasc,
                                       salario, contrato);
            Cadastro cadastro = new Cadastro();
            
            try {
                return cadastro.cadastrar(gestor);
            } catch (CpfException ex) {
                Logger.getLogger(ControlePessoa.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        }
    }
    
}
