/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerCompra;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author unifnsilva
 */
public class Comprar extends javax.swing.JFrame {

    /**
     * Creates new form Comprar
     */
    public Comprar() {
        initComponents();
        
    }
    public Comprar(String id) throws SQLException{
        initComponents();
        controller = new ControllerCompra(this);
        controller.printCotacao();
        this.id = id;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btComprarBitcoin = new javax.swing.JButton();
        btComprarRipple = new javax.swing.JButton();
        btComprarEthereum = new javax.swing.JButton();
        lblBitcoin = new javax.swing.JLabel();
        lblRipple = new javax.swing.JLabel();
        lblEthereum = new javax.swing.JLabel();
        btVolta = new javax.swing.JButton();
        txtBitcoin = new javax.swing.JTextField();
        txtRipple = new javax.swing.JTextField();
        txtEthereum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btComprarBitcoin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btComprarBitcoin.setText("Comprar Bitcoin");
        btComprarBitcoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarBitcoinActionPerformed(evt);
            }
        });

        btComprarRipple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btComprarRipple.setText("Comprar Ripple");
        btComprarRipple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarRippleActionPerformed(evt);
            }
        });

        btComprarEthereum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btComprarEthereum.setText("Comprar Ethereum");
        btComprarEthereum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarEthereumActionPerformed(evt);
            }
        });

        lblBitcoin.setText("Bitcoin: ");

        lblRipple.setText("Ripple: ");

        lblEthereum.setText("Ethereum: ");

        btVolta.setText("Voltar para o menu");
        btVolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBitcoin)
                    .addComponent(lblRipple)
                    .addComponent(lblEthereum))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEthereum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btComprarEthereum))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRipple)
                                    .addComponent(txtBitcoin))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btComprarBitcoin, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btComprarRipple, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVolta)
                        .addContainerGap(157, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComprarBitcoin)
                    .addComponent(lblBitcoin)
                    .addComponent(txtBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComprarRipple)
                    .addComponent(lblRipple)
                    .addComponent(txtRipple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btComprarEthereum)
                        .addComponent(txtEthereum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEthereum))
                .addGap(44, 44, 44)
                .addComponent(btVolta)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btComprarBitcoinActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        try {
            controller.atualizar(id, 1, 0, 0);
        } catch (SQLException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                                

    private void btVoltaActionPerformed(java.awt.event.ActionEvent evt) {                                        
        this.setVisible(false);
        Menu m = new Menu(id);
        m.setVisible(true);
    }                                       

    private void btComprarRippleActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            controller.atualizar(id, 0, 1, 0);
        } catch (SQLException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                               

    private void btComprarEthereumActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        try {
            controller.atualizar(id,0,0,1);
        } catch (SQLException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                                 

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Comprar().setVisible(true);
//            }
//        });
//    }

    public JButton getBtComprarBitcoin() {
        return btComprarBitcoin;
    }

    public void setBtComprarBitcoin(JButton btComprarBitcoin) {
        this.btComprarBitcoin = btComprarBitcoin;
    }

    public JButton getBtComprarEthereum() {
        return btComprarEthereum;
    }

    public void setBtComprarEthereum(JButton btComprarEthereum) {
        this.btComprarEthereum = btComprarEthereum;
    }

    public JButton getBtComprarRipple() {
        return btComprarRipple;
    }

    public void setBtComprarRipple(JButton btComprarRipple) {
        this.btComprarRipple = btComprarRipple;
    }

    public JButton getBtVolta() {
        return btVolta;
    }

    public void setBtVolta(JButton btVolta) {
        this.btVolta = btVolta;
    }



    public JTextField getTxtBitcoin() {
        return txtBitcoin;
    }

    public void setTxtBitcoin(JTextField txtBitcoin) {
        this.txtBitcoin = txtBitcoin;
    }

    public JTextField getTxtEthereum() {
        return txtEthereum;
    }

    public void setTxtEthereum(JTextField txtEthereum) {
        this.txtEthereum = txtEthereum;
    }

    public JTextField getTxtRipple() {
        return txtRipple;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ControllerCompra getController() {
        return controller;
    }

    public void setController(ControllerCompra controller) {
        this.controller = controller;
    }

    public JLabel getLblBitcoin() {
        return lblBitcoin;
    }

    public void setLblBitcoin(JLabel lblBitcoin) {
        this.lblBitcoin = lblBitcoin;
    }

    public JLabel getLblEthereum() {
        return lblEthereum;
    }

    public void setLblEthereum(JLabel lblEthereum) {
        this.lblEthereum = lblEthereum;
    }

    public JLabel getLblRipple() {
        return lblRipple;
    }

    public void setLblRipple(JLabel lblRipple) {
        this.lblRipple = lblRipple;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Comprar().setVisible(true);
//            }
//        });
//    }
    public void setTxtRipple(JTextField txtRipple) {
        this.txtRipple = txtRipple;
    }
    private String id;
    private ControllerCompra controller;
    // Variables declaration - do not modify                     
    private javax.swing.JButton btComprarBitcoin;
    private javax.swing.JButton btComprarEthereum;
    private javax.swing.JButton btComprarRipple;
    private javax.swing.JButton btVolta;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblEthereum;
    private javax.swing.JLabel lblRipple;
    private javax.swing.JTextField txtBitcoin;
    private javax.swing.JTextField txtEthereum;
    private javax.swing.JTextField txtRipple;
    // End of variables declaration                   
}
