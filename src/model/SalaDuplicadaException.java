/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe implementa a exceção para salas já cadastradas no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class SalaDuplicadaException extends Exceptions {

    public SalaDuplicadaException(){
        super("Sala já cadastrada!");
    }
    
}
