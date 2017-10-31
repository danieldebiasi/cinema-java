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
     * @return String
     */
    public String alterar(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();
        arquivo.alterar(filme);
        return "Filme alterado com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de filmes.
     * @param funcionario 
     * @return String
     */
    public String alterar(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();        
        arquivo.alterar(funcionario);
        return "Funcionário alterado com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de gestores.
     * @param gestor 
     * @return String
     */
    public String alterar(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();        
        arquivo.alterar(gestor);
        return "Gestor alterado com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de salas.
     * @param sala 
     * @return string 
     */
    public String alterar(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();
        arquivo.alterar(sala);
        return "Sala alterada com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma alteração ao arquivo de sessões.
     * @param sessao 
     * @return String
     */
    public String alterar(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        arquivo.alterar(sessao);
        return "Sessão alterada com sucesso!";
    }
    
}
