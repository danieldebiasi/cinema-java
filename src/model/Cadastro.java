/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe é responsável pelo cadastro dos objetos presentes no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Cadastro {
    
    private static final Logger LOGGER = Logger.getLogger(Arquivo.class.getName());
    
    /**
     * Este método é responsável pelo cadastro de filmes.
     * @param filme 
     */
    public void cadastrar(Filme filme){
        try {
            ArquivoFilme arquivo = new ArquivoFilme();
            arquivo.inserir(filme);
        } catch (FilmeDuplicadoException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    /**
     * Este método é responsável pelo cadastro de funcionários.
     * @param funcionario 
     * @throws CpfException 
     */
    public void cadastrar(Funcionario funcionario) throws CpfException{
        if(funcionario.getCpf().length() != 11){
            throw new CpfException();
        }
        
        try{
            ArquivoFuncionario arquivo = new ArquivoFuncionario();
            arquivo.inserir(funcionario);
        }
        catch (FuncionarioDuplicadoException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }        
    }
    
    /**
     * Este método é responsável pelo cadastro de gestores.
     * @param gestor 
     * @throws CpfException 
     */
    public void cadastrar(Gestor gestor) throws CpfException{
        if(gestor.getCpf().length() != 11){
            throw new CpfException();
        }
        
        try{
            ArquivoGestor arquivo = new ArquivoGestor();
            arquivo.inserir(gestor);
        }
        catch (GestorDuplicadoException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    /**
     * Este método é responsável pelo cadastro de salas.
     * @param sala 
     */
    public void cadastrar(Sala sala){
        try {
            ArquivoSala arquivo = new ArquivoSala();
            arquivo.inserir(sala);
        } catch (SalaDuplicadaException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    /**
     * Este método é responsável pelo cadastro de sessões.
     * @param sessao 
     */
    public void cadastrar(Sessao sessao){
        try {
            ArquivoSessao arquivo = new ArquivoSessao();
            arquivo.inserir(sessao);
        } catch (SessaoDuplicadaException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }    
}
