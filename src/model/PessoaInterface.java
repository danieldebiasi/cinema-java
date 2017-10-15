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
public interface PessoaInterface {
    public String getNome();
    public void setNome(String nome);
    public String getRg();
    public void setRg(String rg);
    public String getCpf();
    public void setCpf(String cpf);
    public String getEndereco();
    public void setEndereco(String endereco);
    public String getTelefone();
    public void setTelefone(String telefone);
    public int getDiaNascimento();
    public void setDiaNascimento(int diaNascimento);
    public int getMesNascimento();
    public void setMesNascimento(int mesNascimento);
    public int getAnoNascimento();
    public void setAnoNascimento(int anoNascimento);
    public double getSalario();
    public void setSalario(double salario);    
}
