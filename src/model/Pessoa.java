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
abstract class Pessoa {

    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String telefone;
    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;   
    private double salario;
    
    public Pessoa(String nome, String rg, String cpf, String endereco, String telefone, int diaNascimento, int mesNascimento, int anoNascimento, double salario){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.salario = salario;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the diaNascimento
     */
    public int getDiaNascimento() {
        return diaNascimento;
    }

    /**
     * @param diaNascimento the diaNascimento to set
     */
    public void setDiaNascimento(int diaNascimento) {
        this.diaNascimento = diaNascimento;
    }

    /**
     * @return the mesNascimento
     */
    public int getMesNascimento() {
        return mesNascimento;
    }

    /**
     * @param mesNascimento the mesNascimento to set
     */
    public void setMesNascimento(int mesNascimento) {
        this.mesNascimento = mesNascimento;
    }

    /**
     * @return the anoNascimento
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * @param anoNascimento the anoNascimento to set
     */
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
