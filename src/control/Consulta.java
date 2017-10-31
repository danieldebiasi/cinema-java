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
     * @param codFilme
     * @return filme
     */
    public Filme consultarFilme(int codFilme){
        ArquivoFilme arquivo = new ArquivoFilme();
        
        return arquivo.buscar(codFilme);        
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de funcionários.
     * @param rg
     * @return funcionario
     */
    public Funcionario consultarFuncionario(String rg){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();
        
        return arquivo.buscar(rg);
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de gestores.
     * @param rg
     * @return gestor
     */
    public Gestor consultarGestor(String rg){
        ArquivoGestor arquivo = new ArquivoGestor();
        
        return arquivo.buscar(rg);
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de salas.
     * @param sala
     * @return sala
     */
    public Sala consultarSala(int numSala){
        ArquivoSala arquivo = new ArquivoSala();
        
        return arquivo.buscar(numSala);
    }
    
    /**
     * Este método é responsável por requisitar uma busca ao arquivo de sessões.
     * @param codSessao
     * @return sessao
     */
    public Sessao consultarSessao(int codSessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        return arquivo.buscar(codSessao);
    }
}
