/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe possui atributos e métodos necessários para a manipulação de salas no sistema.
 * 
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Sala {

    private int numSala;
    private String status;
    private int[] poltronas = new int[50];
    
    public Sala(int numSala){
        this.numSala = numSala;
        this.status = "Livre";
        for(int i=0; i < poltronas.length; i++){
            poltronas[i] = 0;
        }
    }
    
    /**
     * Obter número da sala.
     * @return the numSala
     */
    public int getNumSala() {
        return numSala;
    }

    /**
     * Definir número da sala.
     * @param numSala the numSala to set
     */
    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    /**
     * Obter status de utilização da sala.
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Definir status de utilização da sala.
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obter estado das poltronas da sala.
     * @return the poltronas
     */
    public int[] getPoltronas() {
        return poltronas;
    }

    /**
     * Definir estado das poltronas da sala.
     * @param poltronas the poltronas to set
     */
    public void setPoltronas(int[] poltronas) {
        this.poltronas = poltronas;
    }    
    
}
