/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.Sala;
import model.ArquivoSala;

/**
 * Esta classe é responsável pelo controle das operações relacionadas a salas.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class ControleSala {

    public static int getProximoCodigo(){
        return ArquivoSala.incremento(ArquivoSala.arquivo);
    }
    
    /**
     * Este método é responsável por obter e verificar os dados da interface e
     * fazer a requisição de inserção no arquivo.
     * @param numero
     * @param status
     * @return String
     */
    public static String tryCadastro(String numero, Object status){
        if(numero.equals("") || status==null){
            return "Erro: Complete todas as informações!";
        }else{
            Sala sala = new Sala(Integer.parseInt(numero), status.toString());
            Cadastro cadastro = new Cadastro();
            
            return cadastro.cadastrar(sala);
        }
    }
    
    /**
     * Este método retorna lista atualizada de salas.
     * @return DefaultListModel
     */
    public static DefaultListModel updateList(){
        DefaultListModel<String> model = new DefaultListModel<>();
        ArquivoSala arquivo = new ArquivoSala();
        List<Sala> salas = arquivo.getAll();
        
        model.removeAllElements();
        
        for(int i = 0; i < salas.size(); i++){
            if(salas.get(i).getStatus().equals("Em condição de uso"))
                model.addElement(Integer.toString(salas.get(i).getNumSala()));
        }
        
        return model;
    }
    
    /**
     * Este método retorna tabela atualizada de salas.
     * @return model
     */
    public static DefaultTableModel updateTable(){
        ArquivoSala arquivo = new ArquivoSala();
        List<Sala> salas = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Número", "Status"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < salas.size(); i++){
            String num = Integer.toString(salas.get(i).getNumSala());
            String status = salas.get(i).getStatus();
            
            Object[] linha = {num, status};
            
            model.addRow(linha);
        }       
        
        return model;
    }
    
    /**
     * Este método é responsável por fazer a requisição de busca de um filme.
     * @param numSala
     * @return 
     */
    public static String[] buscar(int numSala){
        String[] rset;
        rset = new String[1];
        Consulta consulta = new Consulta();
        
        Sala sala = consulta.consultarSala(numSala);
        
        rset[0] = sala.getStatus();
        
        return rset;
    }
    
    /**
     * Este método é responsável por fazer a requisição de alteração de salas.
     * @param numSala
     * @param status
     * @return String
     */
    public static String alterar(String numSala, Object status){
        if(numSala.equals("") || status == null){
            return "Erro: Complete todas as informações!";
        }else{
            Sala sala = new Sala(Integer.parseInt(numSala), status.toString());
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(sala);
        }
    }
    
    /**
     * Este método é responsável por fazer a requisição de exlusão de salas.
     * @param numSala
     * @param status
     * @return 
     */
    public static String excluirSala(String numSala, Object status){
        Sala sala = new Sala(Integer.parseInt(numSala), status.toString());
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(sala);
    }
    
}
