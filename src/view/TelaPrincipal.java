/*
 * Projeto de Gerenciamento de Cinema em Java
 * Programação Orientada a Objetos II
 * Professor Ivan Ricarte
 * Faculdade de Tecnologia - UNICAMP
 */
package view;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Esta classe é responsável pela interface da tela principal.
 * @author Daniel/Gabriel/Roberth/Thiago
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelSair = new javax.swing.JLabel();
        jLabelAjuda = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCadFilmes = new javax.swing.JMenuItem();
        jMenuItemCadSalas = new javax.swing.JMenuItem();
        jMenuItemCadSessoes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadPessoas = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        jMenuItemConFilmes = new javax.swing.JMenuItem();
        jMenuItemConSalas = new javax.swing.JMenuItem();
        jMenuItemConSessoes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemConPessoas = new javax.swing.JMenuItem();
        jMenuVendas = new javax.swing.JMenu();
        jMenuItemNovaVenda = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinema");
        setBackground(new java.awt.Color(154, 201, 249));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(159, 168, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Cinema Manager");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cinema.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Desenvolvedores");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Daniel Rodrigues De Biasi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Gabriel Duenias Rosa");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Roberth Riyu Tamayose");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Thiago Kaoru Alves Takehama");

        jLabelSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jLabelSair.setToolTipText("Sair");
        jLabelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelSairMouseReleased(evt);
            }
        });

        jLabelAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        jLabelAjuda.setToolTipText("Sair");
        jLabelAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelAjudaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)))
                                .addGap(204, 204, 204))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelSair)
                                .addContainerGap()))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGap(51, 51, 51)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAjuda)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSair)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabelAjuda)
                .addContainerGap())
        );

        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.setFocusable(false);

        jMenuItemCadFilmes.setText("Filmes");
        jMenuItemCadFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadFilmesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadFilmes);

        jMenuItemCadSalas.setText("Salas");
        jMenuItemCadSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadSalasActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadSalas);

        jMenuItemCadSessoes.setText("Sessões");
        jMenuItemCadSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadSessoesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadSessoes);
        jMenuCadastros.add(jSeparator1);

        jMenuItemCadPessoas.setText("Pessoas");
        jMenuItemCadPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadPessoasActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadPessoas);

        jMenuBar1.add(jMenuCadastros);

        jMenuConsultas.setText("Consultas");
        jMenuConsultas.setFocusable(false);

        jMenuItemConFilmes.setText("Filmes");
        jMenuItemConFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConFilmesActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConFilmes);

        jMenuItemConSalas.setText("Salas");
        jMenuItemConSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConSalasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConSalas);

        jMenuItemConSessoes.setText("Sessões");
        jMenuItemConSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConSessoesActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConSessoes);
        jMenuConsultas.add(jSeparator2);

        jMenuItemConPessoas.setText("Pessoas");
        jMenuItemConPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConPessoasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConPessoas);

        jMenuBar1.add(jMenuConsultas);

        jMenuVendas.setText("Vendas");
        jMenuVendas.setFocusable(false);

        jMenuItemNovaVenda.setText("Nova Venda");
        jMenuItemNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovaVendaActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItemNovaVenda);

        jMenuBar1.add(jMenuVendas);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(796, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        if(JOptionPane.showConfirmDialog(null, "Encerrar o sistema?") == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItemCadFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFilmesActionPerformed
        CadastroFilme dialog = new CadastroFilme(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFilmesActionPerformed

    private void jMenuItemCadSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadSalasActionPerformed
        CadastroSala dialog = new CadastroSala(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadSalasActionPerformed

    private void jMenuItemCadSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadSessoesActionPerformed
        CadastroSessao dialog = new CadastroSessao(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadSessoesActionPerformed

    private void jMenuItemCadPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadPessoasActionPerformed
        CadastroPessoa dialog = new CadastroPessoa(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadPessoasActionPerformed

    private void jMenuItemConFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConFilmesActionPerformed
        ConsultaFilme dialog = new ConsultaFilme(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemConFilmesActionPerformed

    private void jMenuItemConSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConSalasActionPerformed
           ConsultaSala dialog = new ConsultaSala(this, true);
           dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemConSalasActionPerformed

    private void jMenuItemConSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConSessoesActionPerformed
        ConsultaSessao dialog = new ConsultaSessao(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemConSessoesActionPerformed

    private void jMenuItemConPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConPessoasActionPerformed
        ConsultaPessoa dialog = new ConsultaPessoa(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemConPessoasActionPerformed

    private void jMenuItemNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovaVendaActionPerformed
        Venda dialog = new Venda(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemNovaVendaActionPerformed

    private void jLabelSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSairMouseReleased
        if(JOptionPane.showConfirmDialog(null, "Encerrar o sistema?") == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jLabelSairMouseReleased

    private void jLabelAjudaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAjudaMouseReleased
        Ajuda dialog = new Ajuda(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jLabelAjudaMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);               
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAjuda;
    private javax.swing.JLabel jLabelSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenuItem jMenuItemCadFilmes;
    private javax.swing.JMenuItem jMenuItemCadPessoas;
    private javax.swing.JMenuItem jMenuItemCadSalas;
    private javax.swing.JMenuItem jMenuItemCadSessoes;
    private javax.swing.JMenuItem jMenuItemConFilmes;
    private javax.swing.JMenuItem jMenuItemConPessoas;
    private javax.swing.JMenuItem jMenuItemConSalas;
    private javax.swing.JMenuItem jMenuItemConSessoes;
    private javax.swing.JMenuItem jMenuItemNovaVenda;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/cinema.png")));
    }
}
