/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.ArquivoFilme;
import model.ArquivoFuncionario;
import model.ArquivoGestor;
import model.ArquivoSala;
import model.ArquivoSessao;
import model.CpfException;
import model.Filme;
import model.FilmeDuplicadoException;
import model.Funcionario;
import model.FuncionarioDuplicadoException;
import model.Gestor;
import model.GestorDuplicadoException;
import model.Sala;
import model.SalaDuplicadaException;
import model.Sessao;
import model.SessaoDuplicadaException;

/**
 * Esta classe é responsável pelo cadastro dos objetos presentes no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Cadastro {
    
    private static final Logger LOGGER = Logger.getLogger(Cadastro.class.getName());
    
    /**
     * Este método é responsável peor requisitar o cadastro de filmes.
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
     * Este método é responsável por requisitar o cadastro de funcionários.
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
     * Este método é responsável por requisitar o cadastro de gestores.
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
     * Este método é responsável por requisitar o cadastro de salas.
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
     * Este método é responsável por requisitar o cadastro de sessões.
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
