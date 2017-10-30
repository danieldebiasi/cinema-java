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
     * @return boolean
     */
    public String cadastrar(Filme filme){
        try {
            ArquivoFilme arquivo = new ArquivoFilme();
            arquivo.inserir(filme);
            return "Filme cadastrado com sucesso!";
        } catch (FilmeDuplicadoException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
    
    /**
     * Este método é responsável por requisitar o cadastro de funcionários.
     * @param funcionario 
     * @return String
     * @throws CpfException 
     */
    public String cadastrar(Funcionario funcionario) throws CpfException{
        if(funcionario.getCpf().length() != 11){
            throw new CpfException();
        }
        
        try{
            ArquivoFuncionario arquivo = new ArquivoFuncionario();
            arquivo.inserir(funcionario);
            return "Funcionário cadastrado com sucesso!";
        }
        catch (FuncionarioDuplicadoException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }        
    }
    
    /**
     * Este método é responsável por requisitar o cadastro de gestores.
     * @param gestor 
     * @return String
     * @throws CpfException 
     */
    public String cadastrar(Gestor gestor) throws CpfException{
        if(gestor.getCpf().length() != 11){
            throw new CpfException();
        }
        
        try{
            ArquivoGestor arquivo = new ArquivoGestor();
            arquivo.inserir(gestor);
            return "Gestor cadastrado com sucesso!";
        }
        catch (GestorDuplicadoException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
    
    /**
     * Este método é responsável por requisitar o cadastro de salas.
     * @param sala 
     * @return String
     */
    public String cadastrar(Sala sala){
        try {
            ArquivoSala arquivo = new ArquivoSala();
            arquivo.inserir(sala);
            return "Sala cadastrada com sucesso!";
        } catch (SalaDuplicadaException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
    
    /**
     * Este método é responsável por requisitar o cadastro de sessões.
     * @param sessao 
     * @return String
     */
    public String cadastrar(Sessao sessao){
        try {
            ArquivoSessao arquivo = new ArquivoSessao();
            arquivo.inserir(sessao);
            return "Sessão cadastrada com sucesso!";
        } catch (SessaoDuplicadaException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }    
}
