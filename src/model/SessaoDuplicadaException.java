/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe implementa a exceção para Sessões já cadastradas (indisponíveis)
 * no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class SessaoDuplicadaException extends Exceptions {
    
    public SessaoDuplicadaException(){
        super("Sessão já cadastrada!");
    }
    
}
