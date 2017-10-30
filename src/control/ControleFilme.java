/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ArquivoFilme;
import model.Filme;

/**
 * Esta classe é responsável pelo controle de operações relacionadas aos filmes.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ControleFilme {
    
    /**
     * Este método é responsável por obter e verificar os dados da interface e 
     * fazer a requisição de inserção no arquivo.
     * @param titulo
     * @param diretor
     * @param genero
     * @param ano
     * @param duracao
     * @param clasIndicativa
     * @param sinopse
     * @return String
     */
    public static String tryCadastro(String titulo, String diretor, String genero, String ano, String duracao, Object clasIndicativa, String sinopse){
        if(titulo.equals("") || diretor.equals("") || genero.equals("") || ano.equals("") ||
            duracao.equals("") || clasIndicativa == null){
            return "Erro: Complete todas as informações!";
        }else{
            Filme filme = new Filme(titulo, genero, sinopse, diretor,
                                    Integer.parseInt(ano), clasIndicativa.toString(),
                                    Integer.parseInt(duracao));
            Cadastro cadastro = new Cadastro();
            
            return cadastro.cadastrar(filme);
        }
    }
    
    /**
     * Este método retorna tabela atualizada de filmes.
     * @return model
     */
    public static DefaultTableModel updateTable(){
        ArquivoFilme arquivo = new ArquivoFilme();
        List<Filme> filmes = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Título"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < filmes.size(); i++){
            String cod = Integer.toString(filmes.get(i).getCodFilme());
            String titulo = filmes.get(i).getTitulo();
            
            Object[] linha = {cod, titulo};
            
            model.addRow(linha);
        }       
        
        return model;
    }
    
    /**
     * Este método é responsável por fazer a requisição de busca de um filme.
     * @param codFilme
     * @return 
     */
    public static String[] buscar(int codFilme){
        String[] rset;
        rset = new String[7];
        ArquivoFilme arquivo = new ArquivoFilme();
        
        Filme filme = arquivo.buscar(codFilme);       
        
        rset[0] = filme.getTitulo();
        rset[1] = filme.getGenero();
        rset[2] = filme.getDiretor();
        rset[3] = Integer.toString(filme.getAno());
        rset[4] = Integer.toString(filme.getDuracao());
        rset[5] = filme.getClasIndicativa();
        rset[6] = filme.getSinopse();
        
        return rset;
    }
    
}
