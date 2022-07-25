/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import com.view.SalesFrame;

/**
 *
 * @author HAH17
 */
public class InvoiceHeaderTable extends AbstractTableModel {
     
    
    private ArrayList<InvoiceHeader> invoicesArray;
    
    private String[] columns = {"Id", "Invoice Date", "Customer Name", "Invoice Total"};
     
     public InvoiceHeaderTable(ArrayList<InvoiceHeader> invoicesArray){
     
         this.invoicesArray = invoicesArray;   
     }

    @Override
    public int getRowCount() {
         return invoicesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader Inv = invoicesArray.get(rowIndex);
        switch (columnIndex){
             case 0:
                 return Inv.getNum();
            case 1:
                return SalesFrame.Dformate.format(Inv.getDate()) ;
            case 2: return 
                    Inv.getCustomerN();
            case 3: return
                    Inv.getInvoiceTotal();
        }
        return"";
    }
     @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
