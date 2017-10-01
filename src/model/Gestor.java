/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
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
     * @return the numContrato
     */
    public int getNumContrato() {
        return numContrato;
    }

    /**
     * @param numContrato the numContrato to set
     */
    public void setNumContrato(int numContrato) {
        this.numContrato = numContrato;
    }
       
}
