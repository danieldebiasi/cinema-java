/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe implementa a exceção para filmes já cadastrados no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class FilmeDuplicadoException extends Exceptions {
    
    public FilmeDuplicadoException(){
        super("Filme já cadastrado!");
    }
    
}
