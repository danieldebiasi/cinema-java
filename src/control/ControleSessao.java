/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.List;
import javax.swing.ButtonGroup;
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
    
    /**
     * Este método é responsável por requisitar uma consulta para verificar se uma
     * sala está em utilização por alguma sessão.
     * @param numSala
     * @return boolean
     */
    public static boolean isSalaOcupada(int numSala){
        Consulta consulta = new Consulta();
        
        return consulta.isSalaOcupada(numSala);
    }
    
    /**
     * Este método é responsável por requisitar uma consulta para verificar se um´
     * filme está em exibição.
     * @param codFilme
     * @return boolean
     */
    public static boolean isFilmeEmExibicao(String codFilme){
        Consulta consulta = new Consulta();
        
        return consulta.isFilmeEmExibicao(Integer.parseInt(codFilme));
    } 
    
    /**
     * Este método é responsável por requisitar uma alteração em determinada sessão.
     * @param codSessao
     * @param codFilme
     * @param numSala
     * @param hora
     * @return 
     */
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
     * Este método é responsável por requisitar uma tabela atualizada de sessões.
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
    
    /**
     * Este método é responsável por requisitar as poltronas de uma sessão.
     * @param codSessao
     * @return poltronas
     */
    public static int[] getPoltronas(int codSessao){
        Consulta consulta = new Consulta();
        int[] poltronas;
        
        Sessao sessao = consulta.consultarSessao(codSessao);
        poltronas = new int[50];
        
        System.arraycopy(sessao.getPoltronas(), 0, poltronas, 0, 50);
        
        return poltronas;
    }
    
    /**
     * Este método é responsável por requisitar a venda de um ingresso.
     * @param codSessao
     * @param poltrona
     * @param tipo
     * @param valor
     * @return 
     */
    public static String venda(String codSessao, String poltrona, String tipo, String valor){
        if(codSessao.equals("") || poltrona.equals("") || tipo.equals("") ||
           valor.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Consulta consulta = new Consulta();
            Alteracao alteracao = new Alteracao();
            
            Sessao sessao = consulta.consultarSessao(Integer.parseInt(codSessao));
            
            int[] poltronas = new int[50];
            poltronas = sessao.getPoltronas();
            poltronas[Integer.parseInt(poltrona)-1] = 1;
            System.out.println(poltronas[Integer.parseInt(poltrona)-1]);
            sessao.setPoltronas(poltronas);
            
            String ret = alteracao.alterar(sessao);
            
            return "Venda realizada com sucesso!";
        }
    }
    
}
