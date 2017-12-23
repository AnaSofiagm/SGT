/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.userInterface;

import main.sgt.SGT;
import main.sgt.UC;
import main.sgt.exceptions.InvalidUserTypeException;
import main.sgt.exceptions.UtilizadorJaExisteException;
import main.sgt.exceptions.UtilizadorNaoExisteException;

import javax.swing.table.DefaultTableModel;
import java.util.List;

import static main.userInterface.interfaceUtils.makeUCLookupTable;

/**
 *
 * @author pedro
 */
@SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef", "TryWithIdenticalCatches", "unused", "FieldCanBeLocal"})
public class JAlunoEscolherUC extends javax.swing.JFrame {

    private final SGT sgt;

    /**
     * Creates new form AlunoEscolherUC
     * @param sgt Business logic instance 
     */
    JAlunoEscolherUC(SGT sgt) {
        initComponents();
        this.sgt = sgt;
        updateUCNEscolhidas();
        updateUCEscolhidas();
    }

    private void updateUCNEscolhidas() {
        List<UC> uCsOfUser = this.getUCsOfUser();
        if(uCsOfUser==null) return;
        List<UC> allUCs = this.sgt.getUCs();
        allUCs.removeAll(uCsOfUser);
        this.jTableUCNEscolhidas.setModel(makeUCLookupTable(this.jTableUCNEscolhidas,allUCs));
    }

    private void updateUCEscolhidas() {
        List<UC> uCsOfUser = this.getUCsOfUser();
        if(uCsOfUser==null) return;
        this.jTableUCEscolhidas.setModel(makeUCLookupTable(this.jTableUCEscolhidas,uCsOfUser));
    }

    private List<UC> getUCsOfUser(){
        try {
            return this.sgt.getUCsOfUser();
        } catch (InvalidUserTypeException e) {
            e.printStackTrace();
            this.setVisible(false);
            return null;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPaneUCNEscolhidas = new javax.swing.JScrollPane();
        jTableUCNEscolhidas = new javax.swing.JTable();
        jScrollPaneUCEscolhidas = new javax.swing.JScrollPane();
        jTableUCEscolhidas = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableUCNEscolhidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID:", "Nome:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneUCNEscolhidas.setViewportView(jTableUCNEscolhidas);
        if (jTableUCNEscolhidas.getColumnModel().getColumnCount() > 0) {
            jTableUCNEscolhidas.getColumnModel().getColumn(0).setMinWidth(60);
            jTableUCNEscolhidas.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableUCNEscolhidas.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jTableUCEscolhidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDs:", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneUCEscolhidas.setViewportView(jTableUCEscolhidas);
        if (jTableUCEscolhidas.getColumnModel().getColumnCount() > 0) {
            jTableUCEscolhidas.getColumnModel().getColumn(0).setMinWidth(60);
            jTableUCEscolhidas.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableUCEscolhidas.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonFechar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneUCNEscolhidas, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonRemover)
                            .addComponent(jButtonAdicionar))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPaneUCEscolhidas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonAdicionar)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneUCEscolhidas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneUCNEscolhidas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButtonFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        int selectedRow = this.jTableUCNEscolhidas.getSelectedRow();
        if(selectedRow<0) return;
        String uc_id = (String) this.jTableUCNEscolhidas.getValueAt(selectedRow, 0);
        String uc_name = (String) this.jTableUCNEscolhidas.getValueAt(selectedRow,1);
        try {
            this.sgt.addAlunoToUC(this.sgt.getLoggedUser().getUserNum(),uc_id);
            //Remove row
            DefaultTableModel tableModel = (DefaultTableModel) this.jTableUCNEscolhidas.getModel();
            tableModel.removeRow(selectedRow);
            this.jTableUCNEscolhidas.setModel(tableModel);
            //Add row
            tableModel = (DefaultTableModel) this.jTableUCEscolhidas.getModel();
            tableModel.addRow(new String[]{uc_id,uc_name});
            this.jTableUCEscolhidas.setModel(tableModel);
        } catch (UtilizadorJaExisteException e) {
            updateUCEscolhidas();
            updateUCNEscolhidas();
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        int selectedRow = this.jTableUCEscolhidas.getSelectedRow();
        if(selectedRow<0) return;
        String uc_id = (String) this.jTableUCEscolhidas.getValueAt(selectedRow, 0);
        String uc_name = (String) this.jTableUCEscolhidas.getValueAt(selectedRow,1);
        try {
            this.sgt.removeAlunoFromUC(this.sgt.getLoggedUser().getUserNum(),uc_id);
            //Remove row
            DefaultTableModel tableModel;
            tableModel = (DefaultTableModel) this.jTableUCEscolhidas.getModel();
            tableModel.removeRow(selectedRow);
            this.jTableUCEscolhidas.setModel(tableModel);
            //Add row
            tableModel = (DefaultTableModel) this.jTableUCNEscolhidas.getModel();
            tableModel.addRow(new String[]{uc_id,uc_name});
            this.jTableUCNEscolhidas.setModel(tableModel);

        } catch (UtilizadorNaoExisteException e) {
            updateUCEscolhidas();
            updateUCNEscolhidas();
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFecharActionPerformed

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
            java.util.logging.Logger.getLogger(JAlunoEscolherUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAlunoEscolherUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAlunoEscolherUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAlunoEscolherUC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAlunoEscolherUC(new SGT()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneUCEscolhidas;
    private javax.swing.JScrollPane jScrollPaneUCNEscolhidas;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableUCEscolhidas;
    private javax.swing.JTable jTableUCNEscolhidas;
    // End of variables declaration//GEN-END:variables
}
