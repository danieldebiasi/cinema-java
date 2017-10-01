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
public class Sessao {

    private Filme filme;
    private Sala sala;
    private int hora;
    private int minuto;
    
    /**
     * @return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * @param minuto the minuto to set
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }    
    
}
