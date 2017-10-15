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
    public int getDiaNascimento() {
        return diaNascimento;
    }

    /**
     * Definir dia de nascimento da pessoa.
     * @param diaNascimento the diaNascimento to set
     */
    @Override
    public void setDiaNascimento(int diaNascimento) {
        this.diaNascimento = diaNascimento;
    }

    /**
     * Obter mês de nascimento da pessoa.
     * @return the mesNascimento
     */
    @Override
    public int getMesNascimento() {
        return mesNascimento;
    }

    /**
     * Definir mês de nascimento da pessoa.
     * @param mesNascimento the mesNascimento to set
     */
    @Override
    public void setMesNascimento(int mesNascimento) {
        this.mesNascimento = mesNascimento;
    }

    /**
     * Obter ano de nascimento da pessoa.
     * @return the anoNascimento
     */
    @Override
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * Definir ano de nascimento da pessoa.
     * @param anoNascimento the anoNascimento to set
     */
    @Override
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * Obter salário da pessoa.
     * @return the salario
     */
    @Override
    public double getSalario() {
        return salario;
    }

    /**
     * Definir salário da pessoa.
     * @param salario the salario to set
     */
    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
