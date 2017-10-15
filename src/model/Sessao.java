/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe possui atributos e métodos necessários para a manipulação de Sessões no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Sessao {

    private Filme filme;
    private Sala sala;
    private int hora;
    private int minuto;
    
    /**
     * Obter filme em exibição.
     * @return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Definir filme em exibição.
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * Obter sala da sessão.
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Definir sala da sessão.
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Obter hora da sessão.
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * Definir hora da sessão.
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Obter minuto da sessão.
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Definir minuto da sessão.
     * @param minuto the minuto to set
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }    
    
}
