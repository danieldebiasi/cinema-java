/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.List;
import javax.swing.DefaultListModel;
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
            model.addElement(Integer.toString(salas.get(i).getNumSala()));
        }
        
        return model;
    }
    
}
