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
    
    /**
     * Este método é responsável por requisitar o cadastro de sessões.
     * @param codFilme
     * @param numSala
     * @param hora
     * @return String
     */
    public static String tryCadastro(String codFilme, String numSala, String hora){
        System.out.println(hora);
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
    
    /**
     * Este método é responsável por fazer a requisição de busca de uma sessão.
     * @param codSessao
     * @return 
     */
    public static String[] buscar(int codSessao){
        String[] rset;
        rset = new String[12];
        Consulta consulta = new Consulta();
        
        Sessao sessao = consulta.consultarSessao(codSessao);
        
        rset[0] = Integer.toString(sessao.getCodSessao());
        rset[1] = Integer.toString(sessao.getFilme().getCodFilme());
        rset[2] = sessao.getFilme().getTitulo();
        rset[3] = sessao.getFilme().getGenero();
        rset[4] = sessao.getFilme().getDiretor();
        rset[5] = Integer.toString(sessao.getFilme().getAno());
        rset[6] = Integer.toString(sessao.getFilme().getDuracao());
        rset[7] = sessao.getFilme().getClasIndicativa();
        rset[8] = sessao.getFilme().getSinopse();
        rset[9] = Integer.toString(sessao.getSala().getNumSala());
        rset[10] = sessao.getSala().getStatus();
        rset[11] = sessao.getHora();
        
        return rset;
    }
    
    public static String alterar(String codSessao, String codFilme, String numSala, String hora){
        if(codSessao.equals("") || codFilme.equals("") || numSala.equals("") || hora.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            ArquivoFilme arquivofilme = new ArquivoFilme();
            ArquivoSala arquivosala = new ArquivoSala();
            ArquivoSessao arquivo = new ArquivoSessao();

            Filme filme = arquivofilme.buscar(Integer.parseInt(codFilme));
            Sala sala = arquivosala.buscar(Integer.parseInt(numSala));
            Sessao sessao = new Sessao(Integer.parseInt(codSessao), filme, sala, hora);
            
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(sessao);
        }
    }
    
    /**
     * Este método é responsável por requisitar a exclusão de uma sessão.
     * @param codSessao
     * @param codFilme
     * @param numSala
     * @param hora
     * @return String
     */
    public static String excluir(String codSessao, String codFilme, String numSala, String hora){
        ArquivoFilme arquivofilme = new ArquivoFilme();
        ArquivoSala arquivosala = new ArquivoSala();
        ArquivoSessao arquivo = new ArquivoSessao();

        Filme filme = arquivofilme.buscar(Integer.parseInt(codFilme));
        Sala sala = arquivosala.buscar(Integer.parseInt(numSala));
        Sessao sessao = new Sessao(Integer.parseInt(codSessao), filme, sala, hora); 
        
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(sessao);
    }
    
    /**
     * Este método retorna tabela atualizada de sessões.
     * @return model
     */
    public static DefaultTableModel updateTable(){
        ArquivoSessao arquivo = new ArquivoSessao();
        List<Sessao> sessoes = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código Sessão", "Filme", "Sala", "Horário"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < sessoes.size(); i++){
            String cod = Integer.toString(sessoes.get(i).getCodSessao());
            String filme = sessoes.get(i).getFilme().getTitulo();
            String sala = Integer.toString(sessoes.get(i).getSala().getNumSala());
            String horario = sessoes.get(i).getHora();
            
            Object[] linha = {cod, filme, sala, horario};
            
            model.addRow(linha);
        }       
        
        return model;
    }
    
}
