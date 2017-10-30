/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 * Esta classe herda as características da classe Pessoa, e possui atributos e métodos
 * específicos de funcionários.
 * 
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Funcionario extends Pessoa {

    private String carteiraDeTrabalho;
    private String horaEntrada;
    private String horaSaida;
    
    public Funcionario(String nome, String rg, String cpf, String endereco, String telefone, String dataNasc, String salario, String carteiraDeTrabalho, String horaEntrada, String horaSaida){
        super(nome, rg, cpf, endereco, telefone, dataNasc, salario);
        this.carteiraDeTrabalho = carteiraDeTrabalho;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }
    
    /**
     * Obter identificação da carteira de trabalho do funcionário.
     * @return the carteiraDeTrabalho
     */
    public String getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    /**
     * Definir identificação da carteira de trabalho do funcionário.
     * @param carteiraDeTrabalho the carteiraDeTrabalho to set
     */
    public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    /**
     * Obter hora de entrada do funcionário.
     * @return the horaEntrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Definir hora de entrada do funcionário.
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Obter hora de saída do funcionário.
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * Definir hora de saída do funcionário.
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }    
}
