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
    public String excluir(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();        
        arquivo.excluir(filme);
        return "Filme excluído com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de funcionários.
     * @param funcionario 
     * @return String
     */
    public String excluir(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();        
        arquivo.excluir(funcionario);
        return "Funcionário excluído com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de gestores.
     * @param gestor 
     * @return String
     */
    public String excluir(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();        
        arquivo.excluir(gestor);
        return "Gestor excluído com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de salas.
     * @param sala 
     * @return String
     */
    public String excluir(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();        
        arquivo.excluir(sala);
        return "Sala excluída com sucesso!";
    }
    
    /**
     * Este método é responsável por requisitar uma exclusão no arquivo de sessões.
     * @param sessao 
     * @return String
     */
    public String excluir(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();        
        arquivo.excluir(sessao);        
        return "Sessão excluída com sucesso!";
    }
    
}
