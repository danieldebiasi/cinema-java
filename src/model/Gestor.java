/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe herda as características da classe Pessoa, e possui atributos e métodos 
 * específicos de gestores do cinema.
 * 
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Gestor extends Pessoa {

    private String numContrato;
    
    public Gestor(String rg, String nome, String cpf, String endereco, String telefone, String dataNasc, String salario, String numContrato){
        super(nome, rg, cpf, endereco, telefone, dataNasc, salario);
        this.numContrato = numContrato;
    }
    
    /**
     * Obter número do contrato do gestor.
     * @return the numContrato
     */
    public String getNumContrato() {
        return numContrato;
    }

    /**
     * Definir número do contrato do gestor.
     * @param numContrato the numContrato to set
     */
    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }
       
}
