/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import model.ArquivoFilme;
import model.ArquivoFuncionario;
import model.ArquivoGestor;
import model.ArquivoSala;
import model.ArquivoSessao;
import model.Filme;
import model.Funcionario;
import model.Gestor;
import model.Sala;
import model.Sessao;

/**
 * Esta classe é responsável pela consulta aos objetos presentes no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Consulta {

    /**
     * Este método é responsável por requisitar uma busca ao arquivo de filmes.
     * @param filme
     * @return filme
     */
    public Filme consultar(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();
        
        return arquivo.buscar(filme.getCodFilme());        
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de funcionários.
     * @param funcionario
     * @return funcionario
     */
    public Funcionario consultar(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();
        
        return arquivo.buscar(funcionario.getRg());
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de gestores.
     * @param gestor
     * @return gestor
     */
    public Gestor consultar(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();
        
        return arquivo.buscar(gestor.getRg());
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de salas.
     * @param sala
     * @return sala
     */
    public Sala consultar(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();
        
        return arquivo.buscar(sala.getNumSala());
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de sessões.
     * @param sessao
     * @return sessao
     */
    public Sessao consultar(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        return arquivo.buscar(sessao.getCodSessao());
    }
}
