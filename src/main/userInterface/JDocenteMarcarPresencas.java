/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.userInterface;

import main.sgt.*;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;

import static main.userInterface.InterfaceUtils.*;

/**
 *
 * @author pedro
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "Convert2Lambda", "Anonymous2MethodRef", "TryWithIdenticalCatches"})
public class JDocenteMarcarPresencas extends javax.swing.JFrame {

    private final SGT sgt;
    private Docente loggedUser;
    private String uc;
    private String turno;
    private String aula;


    /**
     * Creates new form DocenteMarcarPresencas
     * @param sgt Business logic instance 
     */
    JDocenteMarcarPresencas(SGT sgt) {
        this.sgt = sgt;
        this.loggedUser = (Docente) this.sgt.getLoggedUser();
        initComponents();
        initComboBoxUCs();
    }

    private void initComboBoxUCs() {
        Set<String> ucs = this.loggedUser.getUcsEturnos().keySet();
        this.uc = makeComboBoxUCs(this.jComboBoxUCs,ucs);
        updateComboBoxTurnos();
    }

    private void updateComboBoxTurnos() {
        if(this.uc==null) return;
        this.turno = makeComboBoxTurnos(this.jComboBoxTurnos,this.loggedUser.getUcsEturnos().get(this.uc));
        updateComboBoxAulas();
    }

    private void updateComboBoxAulas() {
        this.jComboBoxAula.removeAllItems();
        if(this.uc==null || this.turno==null) return;
        for(Aula a: this.sgt.getUC(uc).getTurno(shiftFromString(turno),shiftTypeFromStr(turno)).getAulas()){
            this.jComboBoxAula.addItem(String.valueOf(a.getNumero()));
        }
        this.aula = (String) this.jComboBoxAula.getSelectedItem();
        updatePresencas();
    }

    private void updatePresencas() {
        if(this.aula==null){
            ((DefaultTableModel) this.jTablePresencas.getModel()).setRowCount(0);
            return;
        }
        Turno t = this.sgt.getUC(this.uc).getTurno(shiftFromString(this.turno),shiftTypeFromStr(this.turno));
        List<String> naoPresentes = t.getAlunos();
        List<String> presentes = t.getAula(Integer.parseInt(this.aula)).getPresencas();
        naoPresentes.removeAll(presentes);
        DefaultTableModel tModel = prepareTable(naoPresentes.size()+presentes.size(),3,this.jTablePresencas);
        int i = 0;
        for(String aluno: naoPresentes){
            Aluno a = (Aluno) this.sgt.getUser(aluno);
            tModel.setValueAt(a.getUserNum(),i,0);
            tModel.setValueAt(a.getName(),i,1);
            tModel.setValueAt(false,i,2);
            i++;
        }
        for (String aluno: presentes){
            Aluno a = (Aluno) this.sgt.getUser(aluno);
            tModel.setValueAt(a.getUserNum(),i,0);
            tModel.setValueAt(a.getName(),i,1);
            tModel.setValueAt(true,i,2);
            i++;
        }
        this.jTablePresencas.setModel(tModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUCs = new javax.swing.JLabel();
        jComboBoxUCs = new javax.swing.JComboBox<>();
        jLabelTurnos = new javax.swing.JLabel();
        jComboBoxTurnos = new javax.swing.JComboBox<>();
        jLabelAulas = new javax.swing.JLabel();
        jComboBoxAula = new javax.swing.JComboBox<>();
        jScrollPanePresencas = new javax.swing.JScrollPane();
        jTablePresencas = new javax.swing.JTable();
        jButtonAdicionarAula = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelUCs.setText("UCs:");

        jComboBoxUCs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUCsActionPerformed(evt);
            }
        });

        jLabelTurnos.setText("Turnos");

        jComboBoxTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnosActionPerformed(evt);
            }
        });

        jLabelAulas.setText("Aulas");

        jComboBoxAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAulaActionPerformed(evt);
            }
        });

        jTablePresencas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Nome", "Presenca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePresencas.setColumnSelectionAllowed(true);
        jTablePresencas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePresencasMouseClicked(evt);
            }
        });
        jScrollPanePresencas.setViewportView(jTablePresencas);
        jTablePresencas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTablePresencas.getColumnModel().getColumnCount() > 0) {
            jTablePresencas.getColumnModel().getColumn(2).setMinWidth(69);
            jTablePresencas.getColumnModel().getColumn(2).setPreferredWidth(69);
            jTablePresencas.getColumnModel().getColumn(2).setMaxWidth(69);
        }

        jButtonAdicionarAula.setText("Adicionar Aula");
        jButtonAdicionarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarAulaActionPerformed(evt);
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
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelUCs)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxUCs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTurnos))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxAula, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAdicionarAula))
                            .addComponent(jLabelAulas))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPanePresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAulas)
                    .addComponent(jLabelTurnos)
                    .addComponent(jLabelUCs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarAula)
                    .addComponent(jComboBoxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUCs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPanePresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFechar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAulaActionPerformed
        this.aula = String.valueOf(this.sgt.addAula(this.uc,shiftFromString(this.turno),shiftTypeFromStr(this.turno)));
        updateComboBoxAulas();
    }//GEN-LAST:event_jButtonAdicionarAulaActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jComboBoxAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAulaActionPerformed
        this.aula =  (String) this.jComboBoxAula.getSelectedItem();
        updatePresencas();
    }//GEN-LAST:event_jComboBoxAulaActionPerformed

    private void jComboBoxTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnosActionPerformed
        this.turno = (String) this.jComboBoxTurnos.getSelectedItem();
        updateComboBoxAulas();
    }//GEN-LAST:event_jComboBoxTurnosActionPerformed

    private void jComboBoxUCsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUCsActionPerformed
        this.uc = (String) this.jComboBoxUCs.getSelectedItem();
        updateComboBoxTurnos();
    }//GEN-LAST:event_jComboBoxUCsActionPerformed

    private void jTablePresencasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePresencasMouseClicked
        if(this.jTablePresencas.getSelectedColumn()==2){
            int selRow = this.jTablePresencas.getSelectedRow();
            String aluno = (String) this.jTablePresencas.getValueAt(selRow,0);
            boolean presente = (boolean) this.jTablePresencas.getValueAt(selRow,2);
            if(!presente){
                this.sgt.marcarPresenca(aluno,this.uc,shiftFromString(this.turno),Integer.parseInt(this.aula),shiftTypeFromStr(this.turno));
                this.jTablePresencas.getModel().setValueAt(!(boolean) jTablePresencas.getValueAt(selRow,2),selRow,2);
            }
        }
    }//GEN-LAST:event_jTablePresencasMouseClicked

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
            java.util.logging.Logger.getLogger(JDocenteMarcarPresencas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDocenteMarcarPresencas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDocenteMarcarPresencas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDocenteMarcarPresencas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDocenteMarcarPresencas(new SGT()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAula;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JComboBox<String> jComboBoxAula;
    private javax.swing.JComboBox<String> jComboBoxTurnos;
    private javax.swing.JComboBox<String> jComboBoxUCs;
    private javax.swing.JLabel jLabelAulas;
    private javax.swing.JLabel jLabelTurnos;
    private javax.swing.JLabel jLabelUCs;
    private javax.swing.JScrollPane jScrollPanePresencas;
    private javax.swing.JTable jTablePresencas;
    // End of variables declaration//GEN-END:variables

}
