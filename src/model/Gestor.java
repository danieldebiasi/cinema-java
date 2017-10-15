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

    private int numContrato;
    
    public Gestor(String nome, String rg, String cpf, String endereco, String telefone, int diaNascimento, int mesNascimento, int anoNascimento, double salario, int numContrato){
        super(nome, rg, cpf, endereco, telefone, diaNascimento, mesNascimento, anoNascimento, salario);
        this.numContrato = numContrato;
    }
    
    /**
     * Obter número do contrato do gestor.
     * @return the numContrato
     */
    public int getNumContrato() {
        return numContrato;
    }

    /**
     * Definir número do contrato do gestor.
     * @param numContrato the numContrato to set
     */
    public void setNumContrato(int numContrato) {
        this.numContrato = numContrato;
    }
       
}
