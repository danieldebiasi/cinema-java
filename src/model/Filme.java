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
public class Filme {

    private String titulo;
    private String genero;
    private String sinopse;
    private String diretor;
    private int ano;
    private int clasIndicativa; //em anos
    private int duracao; //em minutos
    
    public Filme(String titulo, String genero, String sinopse, String diretor, int ano, int clasIndicativa, int duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.ano = ano;
        this.clasIndicativa = clasIndicativa;
        this.duracao = duracao;
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the clasIndicativa
     */
    public int getClasIndicativa() {
        return clasIndicativa;
    }

    /**
     * @param clasIndicativa the clasIndicativa to set
     */
    public void setClasIndicativa(int clasIndicativa) {
        this.clasIndicativa = clasIndicativa;
    }

    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }    
    
}
