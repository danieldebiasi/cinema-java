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
 * Esta classe é responsável pela exclusão de objetos presentes no sistema.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class Exclusao {

    /**
     * Este método é responsável por requisitar uma exlusão no arquivo de filmes.
     * @param filme 
     */
    public void excluir(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();
        
        arquivo.excluir(filme.getCodFilme());
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de funcionários.
     * @param funcionario 
     */
    public void excluir(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();
        
        arquivo.excluir(funcionario.getRg());
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de gestores.
     * @param gestor 
     */
    public void excluir(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();
        
        arquivo.excluir(gestor.getRg());
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de salas.
     * @param sala 
     */
    public void exlcuir(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();
        
        arquivo.excluir(sala.getNumSala());
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de sessões.
     * @param sessao 
     */
    public void excluir(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        arquivo.excluir(sessao.getCodSessao());
    }
    
}
