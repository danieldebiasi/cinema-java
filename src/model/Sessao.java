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

    private int codSessao;
    private Filme filme;
    private Sala sala;
    private int hora;
    private int minuto;
    private int[] poltronas = new int[50];
    
    public Sessao(int codSessao, Filme filme, Sala sala, int hora, int minuto, int[] poltronas){
        this.codSessao = codSessao;
        this.filme = filme;
        this.sala = sala;
        this.hora = hora;
        this.minuto = minuto;
        for(int i=0; i < poltronas.length; i++){
            poltronas[i] = 0;
        }
    }
    
    public Sessao(){
    }
    
    /**
     * Obter o código da sessão.
     * @return 
     */
    public int getCodSessao(){
        return codSessao;
    }
    
    /**
     * Definir o código de uma sessão.
     * @param codSessao 
     */
    public void setCodSessao(int codSessao){
        this.codSessao = codSessao;
    }
    
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
    
    /**
     * Obter poltronas da sessão.
     * @return 
     */
    public int[] getPoltronas(){
        return poltronas;
    }
    
    /**
     * Definir poltronas da sessão.
     * @param poltronas 
     */
    public void setPoltronas(int[] poltronas){
        this.poltronas = poltronas;
    }
    
}
