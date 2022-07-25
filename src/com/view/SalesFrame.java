/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;


import com.Controller.ActionHandel;
import com.Controller.TableSelectListener;
import com.model.InvoiceHeader;
import com.model.InvoiceHeaderTable;
import com.model.InvoiceLine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

public class SalesFrame extends javax.swing.JFrame {

    /**
     * Creates new form file
     */
    public SalesFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        headerTable = new javax.swing.JTable();
        newInvBtn = new javax.swing.JButton();
        newInvBtn.addActionListener(handler);
        delInvBtn = new javax.swing.JButton();
        delInvBtn.addActionListener(handler);
        Number = new javax.swing.JLabel();
        CustomerN = new javax.swing.JLabel();
        DateL = new javax.swing.JLabel();
        TotalL = new javax.swing.JLabel();
        numLb = new javax.swing.JLabel();
        customerLb = new javax.swing.JLabel();
        dateLb = new javax.swing.JLabel();
        TotalLb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        NewItemBtn = new javax.swing.JButton();
        NewItemBtn.addActionListener(handler);
        DelIttmBtn = new javax.swing.JButton();
        DelIttmBtn.addActionListener(handler);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadMenu = new javax.swing.JMenuItem();
        LoadMenu.addActionListener(handler);
        saveMenu = new javax.swing.JMenuItem();
        saveMenu.addActionListener(handler);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        headerTable.getSelectionModel().addListSelectionListener(selectListener);
        jScrollPane1.setViewportView(headerTable);

        newInvBtn.setText("New Invoice");
        newInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvBtnActionPerformed(evt);
            }
        });

        delInvBtn.setText("Delet Invoice");
        delInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delInvBtnActionPerformed(evt);
            }
        });

        Number.setText("Invoice Number");

        CustomerN.setText("Customer Name");

        DateL.setText("Invoice  Date");

        TotalL.setText("Invoice Total");

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(lineTable);

        NewItemBtn.setText("New Item");
        NewItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewItemBtnActionPerformed(evt);
            }
        });

        DelIttmBtn.setText(" Delete Item");
        DelIttmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelIttmBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        LoadMenu.setText("Load File");
        LoadMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadMenuActionPerformed(evt);
            }
        });
        jMenu1.add(LoadMenu);

        saveMenu.setText("Save files");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newInvBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(delInvBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CustomerN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TotalL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DateL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numLb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customerLb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TotalLb)
                                    .addComponent(dateLb)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(NewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DelIttmBtn)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Number)
                            .addComponent(numLb))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DateL)
                            .addComponent(dateLb))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerN)
                            .addComponent(customerLb))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalLb))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewItemBtn)
                    .addComponent(DelIttmBtn)
                    .addComponent(delInvBtn)
                    .addComponent(newInvBtn))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMenuActionPerformed

    private void newInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newInvBtnActionPerformed

    private void delInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delInvBtnActionPerformed

    private void NewItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewItemBtnActionPerformed

    private void DelIttmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelIttmBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DelIttmBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerN;
    private javax.swing.JLabel DateL;
    private javax.swing.JButton DelIttmBtn;
    private javax.swing.JMenuItem LoadMenu;
    private javax.swing.JButton NewItemBtn;
    private javax.swing.JLabel Number;
    private javax.swing.JLabel TotalL;
    private javax.swing.JLabel TotalLb;
    private javax.swing.JLabel customerLb;
    private javax.swing.JLabel dateLb;
    private javax.swing.JButton delInvBtn;
    private javax.swing.JTable headerTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lineTable;
    private javax.swing.JButton newInvBtn;
    private javax.swing.JLabel numLb;
    private javax.swing.JMenuItem saveMenu;
    // End of variables declaration//GEN-END:variables
private ActionHandel handler = new ActionHandel(this);
public static SimpleDateFormat Dformate = new SimpleDateFormat("dd-MM-YYYY");
private ArrayList<InvoiceHeader> invoicesArray;
private ArrayList<InvoiceLine> linesArr;
private InvoiceHeaderTable headerTableModel;
private TableSelectListener selectListener = new TableSelectListener(this);

    public ArrayList<InvoiceLine> getLinesArr() {
        return linesArr;
    }

    public void setLinesArr(ArrayList<InvoiceLine> linesArr) {
        this.linesArr = linesArr;
    }


    
    public void setInvoicesArray(ArrayList<InvoiceHeader> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }
    
    public ArrayList<InvoiceHeader> getInvoicesArray() {
        return invoicesArray;
    }
    
    
     public InvoiceHeader getInvObject(int code){
         for (InvoiceHeader inv : invoicesArray){
             if(inv.getNum() == code){
                 return inv;
             }
        
         } 
          return null;
    } 
    public InvoiceHeaderTable getHeaderTableModel() {
        return headerTableModel;
    }
    public void setInvoiceHeaderTableModel(InvoiceHeaderTable headerTableModel) {
        this.headerTableModel = headerTableModel;
    }
    public JTable getHeaderTabl() {

        return headerTable;
    }

    public JTable getLineTable() {
        return lineTable;
    }

    public JLabel getTotalLb() {
        return TotalLb;
    }

    public JLabel getCustomerLb() {
        return customerLb;
    }

    public JLabel getDateLb() {
        return dateLb;
    }

    public JLabel getNumLb() {
        return numLb;
    }

    public ActionHandel getHandler() {
        return handler;
    }
    
     
   
    

    
    

}
