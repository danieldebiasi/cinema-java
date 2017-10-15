/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe implementa a exceção para gestores já cadastrados no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class GestorDuplicadoException extends Exceptions {
    public GestorDuplicadoException(){
        super("Gestor já cadastrado!");
    }
}
