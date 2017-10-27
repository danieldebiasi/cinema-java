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
 * Esta classe é responsável pela alteração dos objetos presentes no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Alteracao {
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de filmes.
     * @param filme 
     */
    public void alterar(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();
        
        arquivo.alterar(filme);
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de filmes.
     * @param funcionario 
     */
    public void alterar(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();
        
        arquivo.alterar(funcionario);
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de gestores.
     * @param gestor 
     */
    public void alterar(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();
        
        arquivo.alterar(gestor);
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de salas.
     * @param sala 
     */
    public void alterar(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();
        
        arquivo.alterar(sala);
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de sessões.
     * @param sessao 
     */
    public void alterar(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        arquivo.alterar(sessao);
    }
    
}
