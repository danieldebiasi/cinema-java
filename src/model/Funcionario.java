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
    private int horaEntrada;
    private int minutoEntrada;
    private int horaSaida;
    private int minutoSaida; 
    
    public Funcionario(String nome, String rg, String cpf, String endereco, String telefone, int diaNascimento, int mesNascimento, int anoNascimento, double salario, String carteiraDeTrabalho, int horaEntrada, int minutoEntrada, int horaSaida, int minutoSaida){
        super(nome, rg, cpf, endereco, telefone, diaNascimento, mesNascimento, anoNascimento, salario);
        this.carteiraDeTrabalho = carteiraDeTrabalho;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.horaSaida = horaSaida;
        this.minutoSaida = minutoSaida;
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
    public int getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Definir hora de entrada do funcionário.
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Obter minuto de entrada do funcionário.
     * @return the minutoEntrada
     */
    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    /**
     * Definir minuto de entrada do funcionário.
     * @param minutoEntrada the minutoEntrada to set
     */
    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }

    /**
     * Obter hora de saída do funcionário.
     * @return the horaSaida
     */
    public int getHoraSaida() {
        return horaSaida;
    }

    /**
     * Definir hora de saída do funcionário.
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(int horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * Obter minuto de saída do funcionário.
     * @return the minutoSaida
     */
    public int getMinutoSaida() {
        return minutoSaida;
    }

    /**
     * Definir minuto de saída do funcionário.
     * @param minutoSaida the minutoSaida to set
     */
    public void setMinutoSaida(int minutoSaida) {
        this.minutoSaida = minutoSaida;
    }
    
}
