/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe abstrata descreve atributos e métodos que serão utilizados para manipular
 * dados de pessoas presentes no sistema.
 * 
 * @author Daniel/Gabriel/Roberth/Thiago
 */
abstract class Pessoa implements PessoaInterface {

    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String telefone;
    private String dataNasc; 
    private String salario;
    
    public Pessoa(String nome, String rg, String cpf, String endereco, String telefone, String dataNasc, String salario){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.salario = salario;
    }
    
    /**
     * Obter nome da pessoa.
     * @return the nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Definir nome da pessoa.
     * @param nome the nome to set
     */
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obter RG da pessoa.
     * @return the rg
     */
    @Override
    public String getRg() {
        return rg;
    }

    /**
     * Definir RG da pessoa.
     * @param rg the rg to set
     */
    @Override
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Obter CPF da pessoa.
     * @return the cpf
     */
    @Override
    public String getCpf() {
        return cpf;
    }

    /**
     * Definir CPF da pessoa.
     * @param cpf the cpf to set
     */
    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obter endereço da pessoa.
     * @return the endereco
     */
    @Override
    public String getEndereco() {
        return endereco;
    }

    /**
     * Definir endereço da pessoa.
     * @param endereco the endereco to set
     */
    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obter telefone da pessoa.
     * @return the telefone
     */
    @Override
    public String getTelefone() {
        return telefone;
    }

    /**
     * Definir telefone da pessoa.
     * @param telefone the telefone to set
     */
    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obter dia de nascimento da pessoa.
     * @return the diaNascimento
     */
    @Override
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * Definir dia de nascimento da pessoa.
     * @param diaNascimento the diaNascimento to set
     */
    @Override
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * Obter salário da pessoa.
     * @return the salario
     */
    @Override
    public String getSalario() {
        return salario;
    }

    /**
     * Definir salário da pessoa.
     * @param salario the salario to set
     */
    @Override
    public void setSalario(String salario) {
        this.salario = salario;
    }
    
}
