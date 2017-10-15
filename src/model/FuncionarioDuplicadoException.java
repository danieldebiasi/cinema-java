/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe implementa a exceção para funcionários já cadastrados no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class FuncionarioDuplicadoException extends Exceptions {
    
    public FuncionarioDuplicadoException(){
        super("Funcionário já cadastrado!");
    }
    
}
