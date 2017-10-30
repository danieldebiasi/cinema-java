/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import model.ArquivoFilme;
import model.ArquivoSala;
import model.ArquivoSessao;
import model.Filme;
import model.Sala;
import model.Sessao;

/**
 * Este método é responsável por obter e verificar os dados da interface e
 * fazer a requisição de inserção no arquivo.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ControleSessao {
    
    public static String tryCadastro(String codFilme, String numSala, String hora){
        if(codFilme.equals("") || numSala.equals("") || hora.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            ArquivoFilme arquivofilme = new ArquivoFilme();
            ArquivoSala arquivosala = new ArquivoSala();
            ArquivoSessao arquivo = new ArquivoSessao();
            
            Filme filme = arquivofilme.buscar(Integer.parseInt(codFilme));
            Sala sala = arquivosala.buscar(Integer.parseInt(numSala));
            Sessao sessao = new Sessao(filme, sala, hora);
            
            Cadastro cadastro = new Cadastro();
            
            return cadastro.cadastrar(sessao);
        }
    }
    
}
