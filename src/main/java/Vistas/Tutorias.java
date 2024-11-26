/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controladores.TutoriasControlador;
import Modelos.Sesion;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class Tutorias extends javax.swing.JFrame {

    /**
     * Creates new form TutoríasRM
     */
    private TutoriasControlador controlador;
    private List<JPanel> panels;
    private List<JLabel> labels;
    //private List<JButton> buttons;
    
    public Tutorias(TutoriasControlador controlador) {
        this.controlador=controlador;
        initComponents();
        
        panels=List.of(panelSesion1,panelSesion2,panelSesion3,panelSesion4,panelSesion5);
        labels=List.of(lblEnum1,lblEnum2,lblEnum3,lblEnum4,lblEnum5);
        //buttons=List.of(btnVideo1,btnVideo2,btnVideo3,btnVideo4,btnVideo5);
    }
    
    public void mostrarInfo(){       
        ocultarInfo();
        
        for (int i = 0; i < panels.size(); i++) {
            JPanel panel=panels.get(i);
            JLabel label=labels.get(i);
            //JButton button=buttons.get(i);
            Sesion sesion=null;
            
            if(i<controlador.getSesiones().size()) sesion=controlador.getSesiones().get(i);               
            
            if(sesion!=null){
                panel.setVisible(true);
                label.setText("SESIÓN "+(i+1)+": "+controlador.getSesiones().get(i).getTitulo());
            }
            //if(label.getText().isEmpty()) panel.setVisible(false);
        }
    }
    
    public void ocultarInfo(){
        for (JPanel p : panels) {
            p.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        panelSesion1 = new javax.swing.JPanel();
        lblEnum1 = new javax.swing.JLabel();
        btnVideo1 = new javax.swing.JButton();
        panelSesion2 = new javax.swing.JPanel();
        lblEnum2 = new javax.swing.JLabel();
        btnVideo2 = new javax.swing.JButton();
        panelSesion3 = new javax.swing.JPanel();
        lblEnum3 = new javax.swing.JLabel();
        btnVideo3 = new javax.swing.JButton();
        panelSesion4 = new javax.swing.JPanel();
        lblEnum4 = new javax.swing.JLabel();
        btnVideo4 = new javax.swing.JButton();
        panelSesion5 = new javax.swing.JPanel();
        lblEnum5 = new javax.swing.JLabel();
        btnVideo5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TUTORÍAS");

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setText("Regresar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Degradado1.jpg"))); // NOI18N
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblEnum1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnVideo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoytb.jpg"))); // NOI18N
        btnVideo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVideo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesion1Layout = new javax.swing.GroupLayout(panelSesion1);
        panelSesion1.setLayout(panelSesion1Layout);
        panelSesion1Layout.setHorizontalGroup(
            panelSesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnum1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVideo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSesion1Layout.setVerticalGroup(
            panelSesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSesion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVideo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnum1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        lblEnum2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnVideo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoytb.jpg"))); // NOI18N
        btnVideo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVideo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesion2Layout = new javax.swing.GroupLayout(panelSesion2);
        panelSesion2.setLayout(panelSesion2Layout);
        panelSesion2Layout.setHorizontalGroup(
            panelSesion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnum2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVideo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSesion2Layout.setVerticalGroup(
            panelSesion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSesion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVideo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnum2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        lblEnum3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnVideo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoytb.jpg"))); // NOI18N
        btnVideo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVideo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesion3Layout = new javax.swing.GroupLayout(panelSesion3);
        panelSesion3.setLayout(panelSesion3Layout);
        panelSesion3Layout.setHorizontalGroup(
            panelSesion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnum3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVideo3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSesion3Layout.setVerticalGroup(
            panelSesion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSesion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVideo3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnum3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        lblEnum4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnVideo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoytb.jpg"))); // NOI18N
        btnVideo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVideo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideo4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesion4Layout = new javax.swing.GroupLayout(panelSesion4);
        panelSesion4.setLayout(panelSesion4Layout);
        panelSesion4Layout.setHorizontalGroup(
            panelSesion4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnum4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVideo4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSesion4Layout.setVerticalGroup(
            panelSesion4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSesion4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVideo4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnum4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        lblEnum5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnVideo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoytb.jpg"))); // NOI18N
        btnVideo5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVideo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideo5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesion5Layout = new javax.swing.GroupLayout(panelSesion5);
        panelSesion5.setLayout(panelSesion5Layout);
        panelSesion5Layout.setHorizontalGroup(
            panelSesion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnum5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVideo5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSesion5Layout.setVerticalGroup(
            panelSesion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesion5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSesion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVideo5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnum5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelSesion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelSesion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelSesion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelSesion5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSesion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSesion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSesion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSesion5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controlador.mostrarTemario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVideo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideo1ActionPerformed
        // TODO add your handling code here:
        //Aquí iría el código para acceder al video
    }//GEN-LAST:event_btnVideo1ActionPerformed

    private void btnVideo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVideo2ActionPerformed

    private void btnVideo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVideo3ActionPerformed

    private void btnVideo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVideo4ActionPerformed

    private void btnVideo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVideo5ActionPerformed

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
            java.util.logging.Logger.getLogger(Tutorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tutorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tutorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tutorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tutorias(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVideo1;
    private javax.swing.JButton btnVideo2;
    private javax.swing.JButton btnVideo3;
    private javax.swing.JButton btnVideo4;
    private javax.swing.JButton btnVideo5;
    private javax.swing.JButton btnVideo6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblEnum1;
    private javax.swing.JLabel lblEnum2;
    private javax.swing.JLabel lblEnum3;
    private javax.swing.JLabel lblEnum4;
    private javax.swing.JLabel lblEnum5;
    private javax.swing.JLabel lblEnum6;
    private javax.swing.JLabel lblSesion6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelSesion1;
    private javax.swing.JPanel panelSesion2;
    private javax.swing.JPanel panelSesion3;
    private javax.swing.JPanel panelSesion4;
    private javax.swing.JPanel panelSesion5;
    // End of variables declaration//GEN-END:variables
}
